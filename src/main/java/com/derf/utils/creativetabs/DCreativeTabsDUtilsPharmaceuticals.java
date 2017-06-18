package com.derf.utils.creativetabs;

import com.derf.utils.items.DItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class DCreativeTabsDUtilsPharmaceuticals extends CreativeTabs {

	public DCreativeTabsDUtilsPharmaceuticals() {
		super("tab_dutils_pharmaceuticals");
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack getTabIconItem() {
		// TODO Auto-generated method stub
		return new ItemStack(DItems.EMPTY_CAPSULE);
	}

}
