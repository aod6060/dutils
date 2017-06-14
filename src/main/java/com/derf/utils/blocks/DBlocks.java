package com.derf.utils.blocks;

import com.derf.utils.DRegistry;
import com.derf.utils.creativetabs.DCreativeTabs;
import com.google.common.base.Preconditions;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.IForgeRegistry;

public final class DBlocks {
	
	// Giron Block
	public static Block GIRON_BLOCK = new DBlock("giron_block", DBlockMeta.DEFAULT);
	// Machine Casing
	public static Block MACHINE_CASING = new DBlock("machine_casing", DBlockMeta.DEFAULT);
	
	public static void registerTileEntity() {
		
	}
	
	public static void creativeTabs() {
		GIRON_BLOCK.setCreativeTab(DCreativeTabs.TAB_DUTILS);
		MACHINE_CASING.setCreativeTab(DCreativeTabs.TAB_DUTILS);
	}
	
	public static void crafting() {
		
	}
	
	public static void variant() {
		
	}
	
	public static void rendererRegister() {
		DRegistry.registerRenderer(GIRON_BLOCK, "giron_block");
		DRegistry.registerRenderer(MACHINE_CASING, "machine_casing");
	}
	
	// Handle Regisgry
	
	@Mod.EventBusSubscriber
	public static class RegistryHandler {
		
		@SubscribeEvent
		public static void registerBlock(final RegistryEvent.Register<Block> event) {
			final Block[] blocks = {
					DBlocks.GIRON_BLOCK,
					DBlocks.MACHINE_CASING
			};
			
			final IForgeRegistry<Block> registry = event.getRegistry();
			
			registry.registerAll(blocks);
		}
		
		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
			final ItemBlock[] items = {
				new ItemBlock(DBlocks.GIRON_BLOCK),
				new ItemBlock(DBlocks.MACHINE_CASING)
			};
			
			final IForgeRegistry<Item> registry = event.getRegistry();
			
			for(final ItemBlock item : items) {
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has a null registry name...");
				registry.register(item.setRegistryName(registryName));
			}
		}
	}
}
