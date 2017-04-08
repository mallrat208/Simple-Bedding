package com.mr208.simplebedding;

import java.util.ArrayList;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ObjectIntIdentityMap;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.mr208.simplebedding.blocks.BlockCarpetBed;
import com.mr208.simplebedding.blocks.BlockHayBed;
import com.mr208.simplebedding.blocks.BlockHayCarpet;
import com.mr208.simplebedding.proxy.CommonProxy;

@Mod(	modid = SimpleBedding.MOD_ID,
		name = SimpleBedding.MOD_NAME,
		version = SimpleBedding.MOD_VERSION)
public class SimpleBedding {
	
	public static final String MOD_ID = "simplebedding";
	public static final String MOD_NAME = "Simple Bedding";
	public static final String MOD_VERSION = "${version}";
	
	public static final String PROXY_COMMON = "com.mr208.simplebedding.proxy.CommonProxy";
	public static final String PROXY_CLIENT = "com.mr208.simplebedding.proxy.ClientProxy";
	
	public static ArrayList<BlockCarpetBed> carpetBeds = new ArrayList<BlockCarpetBed>();
	
	public static BlockCarpetBed carpetBedWhite;
	public static BlockCarpetBed carpetBedOrange;
	public static BlockCarpetBed carpetBedMagenta;
	public static BlockCarpetBed carpetBedLightBlue;
	public static BlockCarpetBed carpetBedYellow;
	public static BlockCarpetBed carpetBedLime;
	public static BlockCarpetBed carpetBedPink;
	public static BlockCarpetBed carpetBedGray;
	public static BlockCarpetBed carpetBedSilver;
	public static BlockCarpetBed carpetBedCyan;
	public static BlockCarpetBed carpetBedPurple;
	public static BlockCarpetBed carpetBedBlue;
	public static BlockCarpetBed carpetBedBrown;
	public static BlockCarpetBed carpetBedGreen;
	public static BlockCarpetBed carpetBedRed;
	public static BlockCarpetBed carpetBedBlack;
	public static BlockHayBed hayBed;
	public static BlockHayCarpet hayCarpet;
	
	@Mod.Instance(MOD_ID)
	public static SimpleBedding INSTANCE;
	
	@SidedProxy(clientSide = PROXY_CLIENT, serverSide = PROXY_COMMON, modId = MOD_ID)
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public static void onPreInit(FMLPreInitializationEvent event) {
		
		hayBed = new BlockHayBed();
		OreDictionary.registerOre("listBedding", hayBed);
		
		int dye = 0;
		carpetBedWhite = new BlockCarpetBed(dye++);
		OreDictionary.registerOre("listBedding",carpetBedWhite);
		SimpleBedding.carpetBeds.add(carpetBedWhite);

		carpetBedOrange = new BlockCarpetBed(dye++);
		SimpleBedding.carpetBeds.add(carpetBedOrange);
		OreDictionary.registerOre("listBedding",carpetBedWhite);

		carpetBedMagenta = new BlockCarpetBed(dye++);
		SimpleBedding.carpetBeds.add(carpetBedMagenta);
		OreDictionary.registerOre("listBedding",carpetBedMagenta);

		carpetBedLightBlue = new BlockCarpetBed(dye++);
		SimpleBedding.carpetBeds.add(carpetBedLightBlue);
		OreDictionary.registerOre("listBedding",carpetBedLightBlue);

		carpetBedYellow = new BlockCarpetBed(dye++);
		SimpleBedding.carpetBeds.add(carpetBedYellow);
		OreDictionary.registerOre("listBedding",carpetBedYellow);

		carpetBedLime = new BlockCarpetBed(dye++);
		SimpleBedding.carpetBeds.add(carpetBedLime);
		OreDictionary.registerOre("listBedding",carpetBedLime);

		carpetBedPink = new BlockCarpetBed(dye++);
		SimpleBedding.carpetBeds.add(carpetBedPink);
		OreDictionary.registerOre("listBedding",carpetBedPink);

		carpetBedGray = new BlockCarpetBed(dye++);
		SimpleBedding.carpetBeds.add(carpetBedGray);
		OreDictionary.registerOre("listBedding",carpetBedGray);

		carpetBedSilver = new BlockCarpetBed(dye++);
		SimpleBedding.carpetBeds.add(carpetBedSilver);
		OreDictionary.registerOre("listBedding",carpetBedSilver);

		carpetBedCyan = new BlockCarpetBed(dye++);
		SimpleBedding.carpetBeds.add(carpetBedCyan);
		OreDictionary.registerOre("listBedding",carpetBedCyan);

		carpetBedPurple = new BlockCarpetBed(dye++);
		SimpleBedding.carpetBeds.add(carpetBedPurple);
		OreDictionary.registerOre("listBedding",carpetBedPurple);

		carpetBedBlue = new BlockCarpetBed(dye++);
		SimpleBedding.carpetBeds.add(carpetBedBlue);
		OreDictionary.registerOre("listBedding",carpetBedBlue);

		carpetBedBrown = new BlockCarpetBed(dye++);
		SimpleBedding.carpetBeds.add(carpetBedBrown);
		OreDictionary.registerOre("listBedding",carpetBedBrown);

		carpetBedGreen = new BlockCarpetBed(dye++);
		SimpleBedding.carpetBeds.add(carpetBedGreen);
		OreDictionary.registerOre("listBedding",carpetBedGreen);

		carpetBedRed = new BlockCarpetBed(dye++);
		SimpleBedding.carpetBeds.add(carpetBedRed);
		OreDictionary.registerOre("listBedding",carpetBedRed);

		carpetBedBlack = new BlockCarpetBed(dye++);
		SimpleBedding.carpetBeds.add(carpetBedBlack);
		OreDictionary.registerOre("listBedding",carpetBedBlack);

		hayCarpet = new BlockHayCarpet();
		
		proxy.registerModelResourceLocation(hayBed);
		proxy.registerModelResourceLocation(hayCarpet);
		for (BlockCarpetBed bed : carpetBeds) {
			proxy.registerModelResourceLocation(bed);
		}
		
		
	}
	
	@Mod.EventHandler
	public static void onInit(FMLInitializationEvent event) {
		proxy.registerCarpetBeds();
	}
	
	@Mod.EventHandler
	public static void onPostInit(FMLPostInitializationEvent event) {

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(hayBed).copy(), new Object[]{"WWW", "PPP", 'W', Items.WHEAT, 'P', "plankWood"}));
		GameRegistry.addShapedRecipe(new ItemStack(hayCarpet,3), new Object[]{"BB",'B', Blocks.HAY_BLOCK});
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(carpetBedWhite).copy(), new Object[]{"D", "P", 'D', "dyeWhite", 'P', "listBedding"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(carpetBedMagenta).copy(), new Object[]{"D", "P", 'D', "dyeMagenta", 'P', "listBedding"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(carpetBedOrange).copy(), new Object[]{"D", "P", 'D', "dyeOrange", 'P', "listBedding"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(carpetBedLightBlue).copy(), new Object[]{"D", "P", 'D', "dyeLightBlue", 'P', "listBedding"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(carpetBedYellow).copy(), new Object[]{"D", "P", 'D', "dyeYellow", 'P', "listBedding"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(carpetBedLime).copy(), new Object[]{"D", "P", 'D', "dyeLime", 'P', "listBedding"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(carpetBedPink).copy(), new Object[]{"D", "P", 'D', "dyePink", 'P', "listBedding"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(carpetBedGray).copy(), new Object[]{"D", "P", 'D', "dyeGray", 'P', "listBedding"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(carpetBedSilver).copy(), new Object[]{"D", "P", 'D', "dyeLightGray", 'P', "listBedding"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(carpetBedCyan).copy(), new Object[]{"D", "P", 'D', "dyeCyan", 'P', "listBedding"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(carpetBedPurple).copy(), new Object[]{"D", "P", 'D', "dyePurple", 'P', "listBedding"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(carpetBedBlue).copy(), new Object[]{"D", "P", 'D', "dyeBlue", 'P', "listBedding"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(carpetBedBrown).copy(), new Object[]{"D", "P", 'D', "dyeBrown", 'P', "listBedding"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(carpetBedRed).copy(), new Object[]{"D", "P", 'D', "dyeRed", 'P', "listBedding"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(carpetBedBlack).copy(), new Object[]{"D", "P", 'D', "dyeBlack", 'P', "listBedding"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(carpetBedGreen).copy(), new Object[]{"D","P",'D',"dyeGreen",'P',"listBedding"}));

	}

	public static final CreativeTabs creativeTab = new CreativeTabs(MOD_ID) {
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(hayBed);
		}
	};
}
