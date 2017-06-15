package com.derf.utils.items.pills;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;

/**
 * This is the PillEffect Factory for create pill effects
 * @author Fred
 *
 */
public final class DPillEffectsFactory {
	
	private static final int MIN_DURATION = 3600;
	private static final int MIN_POTENCY = 0;
	
	private static List<IDPillEffect> effects = new ArrayList<IDPillEffect>();
	
	
	private static IDPillEffect createCure() {
		return new DPillEffectCure();
	}
	
	private static IDPillEffect createBasic(Potion potion, int duration, int potency, String name) {
		return new DPillEffectBasic(potion, duration, potency, name);
	}
	
	private static IDPillEffect createBasic(Potion potion, int potency, String name) {
		return createBasic(potion, MIN_DURATION, potency, name);
	}
	
	private static IDPillEffect createBasic(Potion potion, String name) {
		return createBasic(potion, MIN_POTENCY, name);
	}
	
	/**
	 * This will init the PillEffects... Don't call this method use register...
	 */
	public static void init() {
		effects.clear();
		// Register Cureative Pill
		//effects.add(createCure()); // 0
		register(createCure());
		// Register Teir 1 Pills
		// Speed
		register(createBasic(MobEffects.SPEED, "speed"));
		// Slowness
		register(createBasic(MobEffects.SLOWNESS, "slowness"));
		// Haste
		register(createBasic(MobEffects.HASTE, "haste"));
		// Mining Fatigue
		register(createBasic(MobEffects.MINING_FATIGUE, "mining_fatigue"));
		// strength
		register(createBasic(MobEffects.STRENGTH, "strength"));
		// Instant Health
		register(createBasic(MobEffects.INSTANT_HEALTH, "instant_health"));
		// Instant Damage
		register(createBasic(MobEffects.INSTANT_DAMAGE, "instant_damage"));
		// Jump Boost
		register(createBasic(MobEffects.JUMP_BOOST, "jump_boost"));
		// Nausea
		register(createBasic(MobEffects.NAUSEA, "nausea"));
		// Regeneration
		register(createBasic(MobEffects.REGENERATION, "regeneration"));
		// Resistance
		register(createBasic(MobEffects.RESISTANCE, "resistance"));
		// Fire Resistance
		register(createBasic(MobEffects.FIRE_RESISTANCE, "fire_resistance"));
		// Water Breathing
		register(createBasic(MobEffects.WATER_BREATHING, "water_breathing"));
		// Invisibility
		register(createBasic(MobEffects.INVISIBILITY, "invisibility"));
		// Bindness
		register(createBasic(MobEffects.BLINDNESS, "blindness"));
		// Night Vision
		register(createBasic(MobEffects.HUNGER, "hunger"));
		// Weakness
		register(createBasic(MobEffects.WEAKNESS, "weakness"));
		// Poison
		register(createBasic(MobEffects.POISON, "poison"));
		// Wither
		register(createBasic(MobEffects.WITHER, "wither"));
		// Health Boost
		register(createBasic(MobEffects.HEALTH_BOOST, "health_boost"));
		// Absorption
		register(createBasic(MobEffects.ABSORPTION, "absorption"));
		// Saturation
		register(createBasic(MobEffects.SATURATION, "saturation"));
		// Glowing
		register(createBasic(MobEffects.GLOWING, "glowing"));
		// Levitation
		register(createBasic(MobEffects.LEVITATION, "levitation"));
		// Luck
		register(createBasic(MobEffects.HUNGER, "luck"));
		// Unluck
		register(createBasic(MobEffects.HUNGER, "unluck"));
	}
	
	/**
	 * This will return the pill effect...
	 * @param int index
	 * @return IDPillEffect
	 */
	public static IDPillEffect get(int index) {
		return effects.get(index);
	}
	
	/**
	 * Use this to register an effect. This might be used for other modders to create custom 
	 * effects. 
	 * @param effect
	 */
	public static void register(IDPillEffect effect) {
		effects.add(effect);
	}
	
	public static int getMaxSize() {
		return effects.size();
	}
}
