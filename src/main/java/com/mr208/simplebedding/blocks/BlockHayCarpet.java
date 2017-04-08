package com.mr208.simplebedding.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.mr208.simplebedding.SimpleBedding;

public class BlockHayCarpet extends Block {

	protected static final AxisAlignedBB BEDDING_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);

	public BlockHayCarpet()
	{
		super(Material.CLOTH);
		setSoundType(SoundType.CLOTH);
		this.setCreativeTab(SimpleBedding.creativeTab);
		String name = "carpet.hay";
		this.setRegistryName(name);
		GameRegistry.register(this);
		ItemBlock itemBlock = new ItemBlock(this);
		itemBlock.setRegistryName(name);
		itemBlock.setMaxStackSize(64);
		GameRegistry.register(itemBlock);
		this.setUnlocalizedName(SimpleBedding.MOD_ID+"."+name);
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BEDDING_AABB;
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


}
