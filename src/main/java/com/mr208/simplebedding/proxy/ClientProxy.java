package com.mr208.simplebedding.proxy;

import javax.annotation.Nonnull;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import net.minecraftforge.client.model.ModelLoader;

import com.mr208.simplebedding.SimpleBedding;
import com.mr208.simplebedding.blocks.BlockCarpetBed;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerModelResourceLocation(Block block) {

			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),0,new ModelResourceLocation(block.getRegistryName(),"inventory"));
	}

	@Override
	public void registerCarpetBeds() {

		BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();
		ItemColors itemColors = Minecraft.getMinecraft().getItemColors();


		for(BlockCarpetBed bed: SimpleBedding.carpetBeds) {

			blockColors.registerBlockColorHandler(bed.getBlockColor(),bed);
			itemColors.registerItemColorHandler(bed.getItemColor(), bed);
		}

	}
}
