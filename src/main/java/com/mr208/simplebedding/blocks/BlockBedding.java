package com.mr208.simplebedding.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.mr208.simplebedding.SimpleBedding;

public class BlockBedding extends Block {

	public static final PropertyBool OCCUPIED = PropertyBool.create("occupied");

	protected static final AxisAlignedBB BEDDING_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);

	public BlockBedding(Material material) {
		super(material);
		this.setCreativeTab(SimpleBedding.creativeTab);
	}

	@Override
	public boolean isBed(IBlockState state, IBlockAccess world, BlockPos pos, Entity player) {
		return true;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {

		if (worldIn.isRemote) {
			return true;
		} else {
			if (worldIn.provider.canRespawnHere() && worldIn.getBiome(pos) != Biomes.HELL) {
				if(state.getValue(OCCUPIED)) {
					EntityPlayer entityPlayer = this.getPlayerInBed(worldIn, pos);

					if (entityPlayer != null) {
						playerIn.addChatComponentMessage(new TextComponentTranslation("tile.bed.occupied"));
						return true;
					}

					state = state.withProperty(OCCUPIED, false);
					worldIn.setBlockState(pos,state,4);
				}

				EntityPlayer.SleepResult entityplayer$sleepresult = playerIn.trySleep(pos);

				if (entityplayer$sleepresult == EntityPlayer.SleepResult.OK) {
					state = state.withProperty(OCCUPIED, true);
					worldIn.setBlockState(pos, state, 4);
					return true;
				} else {
					if(entityplayer$sleepresult == EntityPlayer.SleepResult.NOT_POSSIBLE_NOW) {
						playerIn.addChatComponentMessage(new TextComponentTranslation("tile.bed.noSleep"));
					} else if( entityplayer$sleepresult == EntityPlayer.SleepResult.NOT_SAFE) {
						playerIn.addChatComponentMessage(new TextComponentTranslation("tile.bed.notSafe"));
					}

					return true;
				}
				} else {
					worldIn.setBlockToAir(pos);
					worldIn.newExplosion((Entity) null, (double)pos.getX()+0.5D, (double) pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, 5.0F, true, true);
					return true;
			}
			}
		}

	private EntityPlayer getPlayerInBed(World worldIn, BlockPos blockPos){
		for(EntityPlayer entityPlayer : worldIn.playerEntities) {
			if(entityPlayer.isPlayerSleeping() && entityPlayer.bedLocation.equals(blockPos)) {
				return entityPlayer;
			}
		}
		return  null;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BEDDING_AABB;
	}

	@Override
	public boolean isBlockSolid(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return side == EnumFacing.UP ? true : (blockAccess.getBlockState(pos.offset(side)).getBlock() == this ? true : super.shouldSideBeRendered(blockState, blockAccess, pos, side));
	}

	@Override
	public EnumFacing getBedDirection(IBlockState state, IBlockAccess world, BlockPos pos) {
		return EnumFacing.UP;
	}

	@Override
	public BlockPos getBedSpawnPosition(IBlockState state, IBlockAccess world, BlockPos pos, EntityPlayer player) {
		if(world instanceof World) return pos;
		else return null;
	}

	@Override
	public boolean canSpawnInBlock() {
		return true;
	}

	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return true;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(OCCUPIED) ? 1 : 0;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(OCCUPIED, (meta == 1));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {OCCUPIED});
	}
}
