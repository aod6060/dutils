package com.derf.utils.creativetabs;

import com.derf.utils.items.DItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class DCreativeTabsDUtils extends CreativeTabs {

	public DCreativeTabsDUtils() {
		super("tab_dutils");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(DItems.TOOL_CASING);
	}

}
