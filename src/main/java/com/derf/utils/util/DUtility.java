package com.derf.utils.util;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.actors.threadpool.Arrays;

public final class DUtility {

	@SideOnly(Side.CLIENT)
	public static boolean isInCreativeTab(CreativeTabs targetTab, Item item) {
		List<CreativeTabs> allTabs = Arrays.asList(item.getCreativeTabs());
		
		boolean b = allTabs.stream()
						   .filter(tab -> tab == targetTab)
						   .findAny()
						   .isPresent();
		if(b) {
			return true;
		} else {
			CreativeTabs creativeTabs = item.getCreativeTab();
			return creativeTabs != null && (targetTab == CreativeTabs.SEARCH || targetTab == creativeTabs);
		}
						 
	}
}
