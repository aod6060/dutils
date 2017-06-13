package com.derf.utils.items;

import com.derf.utils.DRegistry;
import com.derf.utils.creativetabs.DCreativeTabs;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class DItems {
	
	// Simple Test Item
	public static Item TEST = new DItem("test");
	
	// Array of Items for registeration
	private static Item[] ITEMS = {
		TEST
	};
	
	/**
	 * Used to register Items to MC...
	 * @param event
	 */
	@SubscribeEvent
	public void register(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ITEMS);
	}
	
	/**
	 * 
	 */
	public static void creativeTabs() {
		TEST.setCreativeTab(DCreativeTabs.TAB_DUTILS);
	}
	
	public static void crafting() {
		// Used for Smelting and Brewing for now... I'll
		// Add something using JSON to allow for smelting
		// and Brewing Recipes... Crafting Recipes will
		// Be handled by MC's new system...
	}
	
	public static void registerRenderer() {
		DRegistry.registerRenderer(TEST, "test");
	}
}
