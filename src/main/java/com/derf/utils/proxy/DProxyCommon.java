package com.derf.utils.proxy;

import com.derf.utils.DLoader;
import com.derf.utils.DLogger;
import com.derf.utils.blocks.DBlocks;
import com.derf.utils.creativetabs.DCreativeTabs;
import com.derf.utils.items.DItems;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DProxyCommon implements IDProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		DLogger.getLogger().info("Hello, from preInit");
		DBlocks.registerTileEntity();
		DCreativeTabs.create();
		DBlocks.creativeTabs();
		DItems.creativeTabs();
	}

	@Override
	public void init(FMLInitializationEvent e) {
		DLogger.getLogger().info("Hello, from init");
		//DRegistry.registerRecipes(DLoader.modid); - Getting Rid of this for testing...
		DBlocks.crafting();
		DItems.crafting();
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		DLogger.getLogger().info("Hello, from postInit");
	}

}
