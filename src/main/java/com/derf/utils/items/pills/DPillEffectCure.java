package com.derf.utils.items.pills;

import java.util.Iterator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class DPillEffectCure implements IDPillEffect {

	@Override
	public void onPillEffect(EntityPlayer player) {
		ItemStack milk = new ItemStack(Items.MILK_BUCKET);
		player.curePotionEffects(milk);
	}
	

	@Override
	public Potion getPotionEffect() {
		return null;
	}

	@Override
	public int getDuration() {
		return 0;
	}

	@Override
	public int getPotency() {
		return 0;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "cure";
	}

}
