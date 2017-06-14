package com.derf.utils.items.pills;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class DPillEffect implements IDPillEffect {

	private Potion potion = null;
	
	private int duration = 0;
	
	private int level = 0;
	
	public DPillEffect(Potion potion, int duration, int level) {
		this.potion = potion;
		this.duration = duration;
		this.level = level;
	}
	
	@Override
	public void onPillEffect(EntityPlayer player, ItemStack stack) {
		player.addPotionEffect(new PotionEffect(this.getEffect(), this.getDuration(), this.getLevel()));
	}

	@Override
	public int getDuration() {
		return this.duration;
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public Potion getEffect() {
		return this.potion;
	}
}
