package com.derf.utils.creativetabs;

import com.derf.utils.items.DItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class DCreativeTabsDUtilsPharmaceuticals extends CreativeTabs {

	public DCreativeTabsDUtilsPharmaceuticals() {
		super("tab_dutils_pharmaceuticals");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(DItems.EMPTY_CAPSULE);
	}

}
