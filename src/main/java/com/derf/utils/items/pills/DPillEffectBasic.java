package com.derf.utils.items.pills;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class DPillEffectBasic implements IDPillEffect {

	private Potion potion = MobEffects.ABSORPTION;
	
	private int duration = 0;
	
	private int potency = 0;
	
	private String name;
	
	public DPillEffectBasic() {}
	
	public DPillEffectBasic(Potion potion, int duration, int potency, String name) {
		this.potion = potion;
		this.duration = duration;
		this.potency = potency;
		this.name = name;
	}
	
	@Override
	public void onPillEffect(EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(this.getPotionEffect(), this.getDuration(), this.getPotency()));
	}

	@Override
	public Potion getPotionEffect() {
		return this.potion;
	}

	@Override
	public int getDuration() {
		return this.duration;
	}

	@Override
	public int getPotency() {
		return this.potency;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
