package com.derf.utils.items.pills;

import net.minecraft.potion.Potion;

/**
 * This basically creates pill effects...
 * @author Fred
 *
 */
public class DPillEffectFactory {
	private final static int MAX_DURATION = 500;
	
	
	public static IDPillEffect create(Potion potion, int duration, int level) {
		return new DPillEffect(potion, duration, level);
	}
	
	public static IDPillEffect create(Potion potion, int level) {
		return create(potion, MAX_DURATION, level);
	}
	
	public static IDPillEffect create(Potion potion) {
		return create(potion, 0);
	}
	
	public static IDPillEffect createCure() {
		return new DPillEffectCure();
	}
	
	public static IDPillEffect createEmpty() {
		return new DPillEffectEmpty();
	}
	
	
	/**
	 * Static Pill Effects
	 */
	// Empty
	// Cure
	// Speed
	// Slowness
	// Haste
	// Mining Fatigue
	// Strength
	// Instant Heath
	// Instant Damage
	// Jump Boost
	// Nausea
	// Regeneration
	// Resistance
	// Fire Resistance
	// Water Breathing
	// Invisibility
	// Blindness
	// Night Vision
	// Hunger
	// Weakness
	// Poison
	// Wither
	// Heath Boost
	// Absorption
	// Saturation
	// Glowing
	// Levitation
	// Luck
	// Unluck
}
