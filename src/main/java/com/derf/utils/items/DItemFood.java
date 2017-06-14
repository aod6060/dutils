package com.derf.utils.items;

import net.minecraft.item.ItemFood;

public class DItemFood extends ItemFood {

	public DItemFood(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}

}
