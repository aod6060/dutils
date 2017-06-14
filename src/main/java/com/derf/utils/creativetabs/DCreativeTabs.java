package com.derf.utils.creativetabs;

import com.derf.utils.items.DItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class DCreativeTabs {
	
	public static CreativeTabs TAB_DUTILS;
	
	public static void create() {
		TAB_DUTILS = new CreativeTabs("tab_dutils") {
			@Override
			public ItemStack getTabIconItem() {
				// TODO Auto-generated method stub
				return new ItemStack(DItems.TOOL_CASING);
			}
			
		};
	}
}
