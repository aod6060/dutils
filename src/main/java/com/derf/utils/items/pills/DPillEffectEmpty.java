package com.derf.utils.items.pills;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class DPillEffectEmpty implements IDPillEffect {

	@Override
	public void onPillEffect(EntityPlayer player, ItemStack stack) {
		// Empty effect that won't do anything...
	}

	@Override
	public int getDuration() {
		return 0;
	}

	@Override
	public int getLevel() {
		return 0;
	}

	@Override
	public Potion getEffect() {
		return null;
	}

}
