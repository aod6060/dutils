package com.derf.utils.creativetabs;

import com.derf.utils.items.DItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class DCreativeTabs {
	
	public static CreativeTabs TAB_DUTILS;
	public static CreativeTabs TAB_DUTILS_PHARMACEUTICALS;
	
	public static void create() {
		TAB_DUTILS = new DCreativeTabsDUtils();
		TAB_DUTILS_PHARMACEUTICALS = new DCreativeTabsDUtilsPharmaceuticals();
	}
}
