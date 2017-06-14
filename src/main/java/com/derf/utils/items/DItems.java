package com.derf.utils.items;

import com.derf.utils.DRegistry;
import com.derf.utils.creativetabs.DCreativeTabs;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class DItems {
	// Giron Base
	public static Item GIRON_BASE = new DItem("giron_base");
	// Giron Ingot
	public static Item GIRON_INGOT = new DItem("giron_ingot");
	// Giron Nugget
	public static Item GIRON_NUGGET = new DItem("giron_nugget");
	// tool casing
	public static Item TOOL_CASING = new DItem("tool_casing");
	
	
	// Giron Apples
	
	public static void creativeTabs() {
		GIRON_BASE.setCreativeTab(DCreativeTabs.TAB_DUTILS);
		GIRON_INGOT.setCreativeTab(DCreativeTabs.TAB_DUTILS);
		GIRON_NUGGET.setCreativeTab(DCreativeTabs.TAB_DUTILS);
		TOOL_CASING.setCreativeTab(DCreativeTabs.TAB_DUTILS);
	}
	
	public static void crafting() {
		// Used for Smelting and Brewing for now... I'll
		// Add something using JSON to allow for smelting
		// and Brewing Recipes... Crafting Recipes will
		// Be handled by MC's new system...
		// Register Smelting Recipe for now...
		DRegistry.addSmelting(GIRON_BASE, new ItemStack(GIRON_INGOT, 3), 1.0f);
	}
	
	public static void registerRenderer() {
		DRegistry.registerRenderer(GIRON_BASE, "giron_base");
		DRegistry.registerRenderer(GIRON_INGOT, "giron_ingot");
		DRegistry.registerRenderer(GIRON_NUGGET, "giron_nugget");
		DRegistry.registerRenderer(TOOL_CASING, "tool_casing");
	}
	
	
	@Mod.EventBusSubscriber
	public static class RegistryHandler {
		
		@SubscribeEvent
		public static void registerItem(final RegistryEvent.Register<Item> event) {
			
			final Item[] items = {
					DItems.GIRON_BASE,
					DItems.GIRON_INGOT,
					DItems.GIRON_NUGGET,
					DItems.TOOL_CASING
			};
			
			event.getRegistry().registerAll(items);
		}
		
	}
}
