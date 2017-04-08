package com.mr208.simplebedding.blocks;

import javax.annotation.Nonnull;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import com.mr208.simplebedding.SimpleBedding;

public class BlockCarpetBed extends BlockBedding {

	int color;

	public BlockCarpetBed(int colorIn) {
		super(Material.CLOTH);

		this.color = colorIn;
		setSoundType(SoundType.CLOTH);
		String name = "bed.carpet." + colorIn;
		this.setRegistryName(name);
		GameRegistry.register(this);

		ItemBlock itemBlock = new ItemBlock(this);
		itemBlock.setRegistryName(name);
		itemBlock.setMaxStackSize(3);
		GameRegistry.register(itemBlock);
		this.setUnlocalizedName(SimpleBedding.MOD_ID+"."+name);
	}

	@Override
	public boolean recolorBlock(World world, BlockPos pos, EnumFacing side, EnumDyeColor color) {
		return super.recolorBlock(world, pos, side, color);
	}

	@SideOnly(Side.CLIENT)
	public IBlockColor getBlockColor() {
		return new IBlockColor() {
			@Override
			public int colorMultiplier(@Nonnull IBlockState state, IBlockAccess access, BlockPos pos, int tint) {

				return getColor(color);
			}
		};
	}
	@SideOnly(Side.CLIENT)
	public IItemColor getItemColor() {
		return new IItemColor() {
			@Override
			public int getColorFromItemstack(ItemStack stack, int tintIndex) {
				return tintIndex == 0 ? getColor(color) : 0xFFFFFF;
			}
		};
	}

	protected int getColor(int colorIndex) {
		if(colorIndex>=15) colorIndex = 15;
		return ItemDye.DYE_COLORS[15 - colorIndex];
	}
}
