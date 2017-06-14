package com.derf.utils.blocks;

import net.minecraft.block.Block;

public class DBlock extends Block {
	
	public DBlock(String name, DBlockMeta meta) {
		super(meta.getMaterial());
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setHardness(meta.getHardness());
		this.setResistance(meta.getResistance());
		this.setLightLevel(meta.getLightLevel());
		this.setHarvestLevel(meta.getToolClass(), meta.getToolLevel());
		this.setSoundType(meta.getSoundType());
	}
}
