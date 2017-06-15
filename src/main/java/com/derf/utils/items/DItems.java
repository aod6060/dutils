package com.derf.utils.items;

import com.derf.utils.DRegistry;
import com.derf.utils.creativetabs.DCreativeTabs;
import com.derf.utils.items.pills.DItemPill;
import com.derf.utils.items.pills.DPillEffectsFactory;

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
	public static Item GIRON_APPLE = new DItemFoodGironApple("giron_apple", 4, 4, false).setAlwaysEdible();
	
	// Pills
	// Empty Capsules...
	public static Item EMPTY_CAPSULE = new DItem("empty_capsule");
	// Pills
	public static Item PILLS = new DItemPill("pill");
	
	public static void creativeTabs() {
		GIRON_BASE.setCreativeTab(DCreativeTabs.TAB_DUTILS);
		GIRON_INGOT.setCreativeTab(DCreativeTabs.TAB_DUTILS);
		GIRON_NUGGET.setCreativeTab(DCreativeTabs.TAB_DUTILS);
		TOOL_CASING.setCreativeTab(DCreativeTabs.TAB_DUTILS);
		GIRON_APPLE.setCreativeTab(DCreativeTabs.TAB_DUTILS);
		EMPTY_CAPSULE.setCreativeTab(DCreativeTabs.TAB_DUTILS); // Reddye + Bonemeal + GIRON_NUGGET = Empty Capsule... For now...
		PILLS.setCreativeTab(DCreativeTabs.TAB_DUTILS);
	}
	
	public static void crafting() {
		// Used for Smelting and Brewing for now... I'll
		// Add something using JSON to allow for smelting
		// and Brewing Recipes... Crafting Recipes will
		// Be handled by MC's new system...
		// Register Smelting Recipe for now...
		DRegistry.addSmelting(GIRON_BASE, new ItemStack(GIRON_INGOT, 3), 1.0f);
	}
	
	public static void variants() {
	}
	
	public static void registerRenderer() {
		DRegistry.registerRenderer(GIRON_BASE, "giron_base");
		DRegistry.registerRenderer(GIRON_INGOT, "giron_ingot");
		DRegistry.registerRenderer(GIRON_NUGGET, "giron_nugget");
		DRegistry.registerRenderer(TOOL_CASING, "tool_casing");
		DRegistry.registerRenderer(GIRON_APPLE, "giron_apple");
		DRegistry.registerRenderer(GIRON_APPLE, 1, "giron_apple");
		DRegistry.registerRenderer(EMPTY_CAPSULE, "empty_capsule");
		
		
		for(int i = 0; i < DPillEffectsFactory.getMaxSize(); i++) {
			DRegistry.registerRenderer(PILLS, i, "empty_capsule");
		}
	}
	
	
	@Mod.EventBusSubscriber
	public static class RegistryHandler {
		
		@SubscribeEvent
		public static void registerItem(final RegistryEvent.Register<Item> event) {
			
			final Item[] items = {
					DItems.GIRON_BASE,
					DItems.GIRON_INGOT,
					DItems.GIRON_NUGGET,
					DItems.TOOL_CASING,
					DItems.GIRON_APPLE,
					DItems.EMPTY_CAPSULE,
					DItems.PILLS
			};
			
			event.getRegistry().registerAll(items);
		}
		
	}
}
