package com.derf.utils.items.pills;

import com.derf.utils.items.DItem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


/*
 * Effect type: Potions
 * Duration: how long a the effect will last
 * Potency: How powerful the effect will be.
 * 
 * Special Case for Cure - This will cure a player with any affect... Similar to drinking milk...
 */
public class DItemPill extends DItem {

	public DItemPill(String name) {
		super(name);
		this.setHasSubtypes(true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs itemIn, NonNullList<ItemStack> tab) {		
		if(this.func_194125_a(itemIn)) {
			for(int i = 0; i < DPillEffectsFactory.getMaxSize(); i++) {
				tab.add(new ItemStack(this, 1, i));
			}
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		// TODO Auto-generated method stub
		//return super.getUnlocalizedName(stack);
		return this.getUnlocalizedName() + "." + DPillEffectsFactory.get(stack.getMetadata()).getName();
	}
	
	
}
