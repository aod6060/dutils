package com.derf.utils.items.pills;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.derf.utils.DLogger;
import com.derf.utils.util.DGenericBean2;

import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;

/**
 * This is the PillEffect Factory for create pill effects
 * @author Fred
 *
 */
public final class DPillEffectsFactory {
	/*
	private static final int MIN_DURATION = 3600;
	private static final int MIN_POTENCY = 0;
	*/
	
	private static int IDs = 1;
	
	private static boolean isGenerateIDs = false;
	
	private static List<IDPillEffect> effects = new ArrayList<IDPillEffect>();
	
	
	private static IDPillEffect createCure() {
		return new DPillEffectCure();
	}
	
	private static IDPillEffect createBasic(Potion potion, int duration, int potency, String name) {
		return new DPillEffectBasic(potion, duration, potency, name);
	}
	
	/**
	 * This will init the PillEffects... Don't call this method use register...
	 */
	public static void init() {
		
		
		effects.clear();
		
		// Handle Curative Effects
		register(createCure());
		// Handle Main Effect
		List<DGenericBean2<Potion, String>> effects1 = new ArrayList<DGenericBean2<Potion, String>>();
		
		effects1.clear();
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.SPEED, "speed"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.SLOWNESS, "slowness"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.HASTE, "haste"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.MINING_FATIGUE, "mining_fatigue"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.STRENGTH, "strength"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.JUMP_BOOST, "jump_boost"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.NAUSEA, "nausea"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.REGENERATION, "regeneration"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.RESISTANCE, "resistance"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.FIRE_RESISTANCE, "fire_resistance"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.WATER_BREATHING, "water_breathing"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.INVISIBILITY, "invisibility"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.BLINDNESS, "blindness"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.NIGHT_VISION, "night_vision"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.HUNGER, "hunger"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.WEAKNESS, "weakness"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.POISON, "poison"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.WITHER, "wither"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.HEALTH_BOOST, "health_boost"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.ABSORPTION, "absorption"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.SATURATION, "saturation"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.GLOWING, "glowing"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.LEVITATION, "levitation"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.LUCK, "luck"));
		effects1.add(new DGenericBean2<Potion, String>(MobEffects.UNLUCK, "unluck"));
		// Handle Instant Effect aka: instant_health and instant_damage
		List<DGenericBean2<Potion, String>> effects2 = new ArrayList<DGenericBean2<Potion, String>>();
		effects2.clear();
		effects2.add(new DGenericBean2(MobEffects.INSTANT_DAMAGE, "instant_damage"));
		effects2.add(new DGenericBean2(MobEffects.INSTANT_HEALTH, "instant_health"));
		// Create Teirs
		List<Teirs> teirs = new ArrayList<Teirs>();
		teirs.clear();
		Teirs.clear();
		teirs.add(Teirs.create()); // 1
		teirs.add(Teirs.create()); // 2
		teirs.add(Teirs.create()); // 3
		teirs.add(Teirs.create()); // 4
		teirs.add(Teirs.create()); // 5
		
		// Handle Regular Pills
		for(Teirs teir : teirs) {
			for(DGenericBean2<Potion, String> bean : effects1) {
				register(createBasic(bean.getValue1(), teir.getDuration(), teir.getPotency(), bean.getValue2()));
			}
		}
		
		// Handle Instant Pills
		for(Teirs teir : teirs) {
			for(DGenericBean2<Potion, String> bean : effects2) {
				register(createBasic(bean.getValue1(), 1, teir.getPotency(), bean.getValue2()));
			}
		}
		
		
		
		if(isGenerateIDs) {
			try {
				PrintWriter out = new PrintWriter("pill_ids.txt");
				IDs = 1;
				
				// Handle Regular Pills
				for(Teirs teir : teirs) {
					for(DGenericBean2<Potion, String> bean : effects1) {
						//register(createBasic(bean.getValue1(), teir.getDuration(), teir.getPotency(), bean.getValue2()));
						
						out.println("// " + bean.getValue2() + " teir " + (teir.getPotency() + 1));
						out.println(" { \"item\": \"dutils:pill\", \"data\": "+IDs+" }");
						out.println();
						++IDs;
					}
				}
				
				// Handle Instant Pills
				for(Teirs teir : teirs) {
					for(DGenericBean2<Potion, String> bean : effects2) {
						//register(createBasic(bean.getValue1(), 1, teir.getPotency(), bean.getValue2()));
						
						out.println("// " + bean.getValue2() + " teir " + (teir.getPotency() + 1));
						out.println(" { \"item\": \"dutils:pill\", \"data\": "+IDs+" }");
						out.println();
						++IDs;
						
					}
				}
				
				out.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
			}
		}
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
	
	
	// Make an inner class that acts as a table for effects...
	// Make an inner class that holds teirs for the items...
	
	
	private static class Teirs {
		
		private static int number = 0;
		
		private int duration = 0;
		
		private int potency = 0;
		
		public Teirs() {}
		
		// Don't init outside of this class
		private Teirs(int duration, int potency) {
			this.duration = duration;
			this.potency = potency;
		}
		
		public int getDuration() {
			return duration;
		}

		public int getPotency() {
			return potency;
		}
		
		public static Teirs create() {
			int duration = 3600 + 3600 * number;
			int potency = number;
			++number;
			
			DLogger.getLogger().info("Duration: "+duration+", Potency: "+potency+", Number: "+number);
			Teirs teirs = new Teirs(duration, potency);
			return teirs;
		}
		
		public static void clear() {
			number = 0;
		}
	}
}
