package com.derf.utils;

import com.derf.utils.blocks.DBlocks;
import com.derf.utils.items.DItems;
import com.derf.utils.proxy.IDProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=DLoader.modid, name=DLoader.name, version=DLoader.version)
public class DLoader {
	// Mod's Meta Data....
	public static final String modid = "dutils";
	public static final String name = "DUtils";
	public static final String version = "build 1";
	
	// Instance
	@Instance
	public static DLoader instance = new DLoader();
	
	// Proxies
	@SidedProxy(clientSide="com.derf.utils.proxy.DProxyClient", serverSide="com.derf.utils.proxy.DProxyServer")
	public static IDProxy proxy;
	
	// Constructor
	public DLoader() {
		// Handle registration..
		DLogger.create();
		//MinecraftForge.EVENT_BUS.register(new DBlocks());
		//MinecraftForge.EVENT_BUS.register(new DItems());
	}
	
	// Event Handlers
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
}
