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
		// Speed 1
		register(createBasic(MobEffects.SPEED, "speed"));
		// Slowness 2
		register(createBasic(MobEffects.SLOWNESS, "slowness"));
		// Haste 3
		register(createBasic(MobEffects.HASTE, "haste"));
		// Mining Fatigue 4
		register(createBasic(MobEffects.MINING_FATIGUE, "mining_fatigue"));
		// strength 5
		register(createBasic(MobEffects.STRENGTH, "strength"));
		// Instant Health 6
		//register(createBasic(MobEffects.INSTANT_HEALTH, "instant_health"));
		register(createBasic(MobEffects.INSTANT_HEALTH, 1, 0, "instant_health"));
		// Instant Damage 7
		register(createBasic(MobEffects.INSTANT_DAMAGE, 1, 0, "instant_damage"));
		// Jump Boost 8
		register(createBasic(MobEffects.JUMP_BOOST, "jump_boost"));
		// Nausea 9
		register(createBasic(MobEffects.NAUSEA, "nausea"));
		// Regeneration 10
		register(createBasic(MobEffects.REGENERATION, "regeneration"));
		// Resistance 11
		register(createBasic(MobEffects.RESISTANCE, "resistance"));
		// Fire Resistance 12
		register(createBasic(MobEffects.FIRE_RESISTANCE, "fire_resistance"));
		// Water Breathing 13
		register(createBasic(MobEffects.WATER_BREATHING, "water_breathing"));
		// Invisibility 14
		register(createBasic(MobEffects.INVISIBILITY, "invisibility"));
		// Bindness 15
		register(createBasic(MobEffects.BLINDNESS, "blindness"));
		// Night Vision 16
		register(createBasic(MobEffects.HUNGER, "hunger"));
		// Weakness 17
		register(createBasic(MobEffects.WEAKNESS, "weakness"));
		// Poison 18
		register(createBasic(MobEffects.POISON, "poison"));
		// Wither 19
		register(createBasic(MobEffects.WITHER, "wither"));
		// Health Boost 20
		register(createBasic(MobEffects.HEALTH_BOOST, "health_boost"));
		// Absorption 21
		register(createBasic(MobEffects.ABSORPTION, "absorption"));
		// Saturation 22
		register(createBasic(MobEffects.SATURATION, "saturation"));
		// Glowing 23
		register(createBasic(MobEffects.GLOWING, "glowing"));
		// Levitation 24
		register(createBasic(MobEffects.LEVITATION, "levitation"));
		// Luck 25
		register(createBasic(MobEffects.LUCK, "luck"));
		// Unluck 26
		register(createBasic(MobEffects.UNLUCK, "unluck"));
		
		// Handle Curative Effects
		// Handle Main Effects
		// Handle Instant Effect aka: instant_health and instant_damage
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
