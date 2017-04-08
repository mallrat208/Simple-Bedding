package com.mr208.simplebedding.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.mr208.simplebedding.SimpleBedding;

public class BlockHayBed extends BlockBedding {

	public BlockHayBed() {
		super(Material.CLOTH);

		setSoundType(SoundType.CLOTH);
		String name = "bed.hay";
		this.setRegistryName(name);
		GameRegistry.register(this);

		ItemBlock itemBlock = new ItemBlock(this);
		itemBlock.setRegistryName(name);
		itemBlock.setMaxStackSize(3);
		GameRegistry.register(itemBlock);
		this.setUnlocalizedName(SimpleBedding.MOD_ID+"."+name);
	}
}
