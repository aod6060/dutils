package com.derf.utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This basically wraps up some stuff for registry...
 * @author Fred
 *
 */
public class DRegistry {
	// Models
	public static void registerRenderer(Item item, int meta, String name) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(DLoader.modid + ":" + name, "inventory"));
	}
	
	public static void registerRenderer(Item item, String name) {
		registerRenderer(item, 0, name);
	}
	
	public static void registerRenderer(Block block, int meta, String name) {
		registerRenderer(Item.getItemFromBlock(block), meta, name);
	}
	
	public static void registerRenderer(Block block, String name) {
		registerRenderer(block, 0, name);
	}
	
	// Variants
	public static void addVariants(Block block, String... args) {
		addVariants(Item.getItemFromBlock(block), args);
	}
	
	public static void addVariants(Item item, String... args) {
		List<String> argsList = Arrays.asList(args);
		List<ResourceLocation> resList = argsList.stream()
		         								 .map(arg -> new ResourceLocation(DLoader.modid + ":" + arg))
		         								 .collect(Collectors.toList());
		if(resList.size() > 0) {
			ModelBakery.registerItemVariants(item,resList.toArray(new ResourceLocation[0]));
		}
		
	}
	
	// Fuel Handler
	public static void registerFuelHandler(IFuelHandler fuel) {
		GameRegistry.registerFuelHandler(fuel);
	}
	
	// Smelting...
	public static void addSmelting(ItemStack input, ItemStack output, float xp) {
		GameRegistry.addSmelting(input, output, xp);
	}
	
	public static void addSmelting(Item input, ItemStack output, float xp) {
		GameRegistry.addSmelting(input, output, xp);
	}
	
	public static void addSmelting(Block input, ItemStack output, float xp) {
		GameRegistry.addSmelting(input, output, xp);
	}
	
	// Brewing... Note: I'm going to have some fun with brewing... Pendents...
	public static void addBrewingRecipe(ItemStack input, ItemStack ingredient, ItemStack output) {
		BrewingRecipeRegistry.addRecipe(input, ingredient, output);
	}
	
	// World Generator
	public static void registerWorldGenerator(IWorldGenerator generator, int weight) {
		GameRegistry.registerWorldGenerator(generator, weight);
	}
	
	// TileEntity
	public static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String name) {
		GameRegistry.registerTileEntity(tileEntityClass, name);
	}
}
