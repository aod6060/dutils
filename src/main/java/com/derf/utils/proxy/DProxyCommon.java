package com.derf.utils.proxy;

import com.derf.utils.DLoader;
import com.derf.utils.DLogger;
import com.derf.utils.DRegistry;
import com.derf.utils.creativetabs.DCreativeTabs;
import com.derf.utils.items.DItems;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class DProxyCommon implements IDProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		DLogger.getLogger().info("Hello, from preInit");
		DCreativeTabs.create();
		DItems.creativeTabs();
		
		
	}

	@Override
	public void init(FMLInitializationEvent e) {
		DLogger.getLogger().info("Hello, from init");
		DRegistry.registerRecipes(DLoader.modid);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		DLogger.getLogger().info("Hello, from postInit");
	}

}
