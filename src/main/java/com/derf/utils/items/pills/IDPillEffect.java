package com.derf.utils.items.pills;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

/**
 * This is an interface for the pill items...
 * it will contain all methods related to pill effects
 * @author Fred
 *
 */
public interface IDPillEffect {
	
	/**
	 * Applies Effect on player
	 * @param player
	 */
	void onPillEffect(EntityPlayer player);
	
	/**
	 * Returns the potion type
	 * @return
	 */
	Potion getPotionEffect();
	
	/**
	 * Returns the duration for pill effect
	 * @return
	 */
	int getDuration();
	
	/**
	 * Returns the potiency of the pill 
	 * @return
	 */
	int getPotency();
	
	/**
	 * This will return the name
	 * @return
	 */
	String getName();
	
}
