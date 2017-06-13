package com.derf.utils.items;

import net.minecraft.item.Item;

public class DItem extends Item {
	
	public DItem(String name) {
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
}
