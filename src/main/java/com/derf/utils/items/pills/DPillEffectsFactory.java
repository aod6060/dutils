package com.derf.utils.items.pills;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.derf.utils.DLogger;
import com.derf.utils.DRegistry;
import com.derf.utils.items.DItems;
import com.derf.utils.util.DGenericBean2;

import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;

/**
 * This is the PillEffect Factory for create pill effects
 * @author Fred
 *
 */
public final class DPillEffectsFactory {
	private static int IDs = 1;
	
	private static boolean isGenerateIDs = false;
	
	// Check to see if I want to generate recipes 2 - 5
	private static boolean isGenerateRecipes = true;
	
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
		List<DGenericBean2<Potion, String>> effects1 = createEffects1List();
		// Handle Instant Effect aka: instant_health and instant_damage
		List<DGenericBean2<Potion, String>> effects2 = createEffects2List();
		// Create Teirs
		Teirs.clear();
		List<Teirs> teirs = createTeirList();
		// Handle Regular Pills
		teirs.forEach(teir -> handleBeans(teir, effects1));
		// Handle Instant Pills
		teirs.forEach(teir -> handleBeansInstant(teir, effects2));
		
		// Handle Generated ID to file...
		if(isGenerateIDs) {
			try {
				PrintWriter out = new PrintWriter("pill_ids.txt");
				IDs = 1;
				// Handle Regular Pills
				teirs.forEach(teir -> handleFileOutput(teir, out, effects1));
				// Handle Instant Pills
				teirs.forEach(teir -> handleFileOutput(teir, out, effects2));
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		// Handle Generator for recipes...
		if(isGenerateRecipes) {
			DPillRecipeGenerator.generate();
		}
	}
	
	private static List<Teirs> createTeirList() {
		return Arrays.asList(
				Teirs.create(),
				Teirs.create(),
				Teirs.create(),
				Teirs.create(),
				Teirs.create()
		);
	}

	private static List<DGenericBean2<Potion, String>> createEffects2List() {
		return Arrays.asList(
			new DGenericBean2(MobEffects.INSTANT_DAMAGE, "instant_damage"),
			new DGenericBean2(MobEffects.INSTANT_HEALTH, "instant_health")
		);
	}

	private static List<DGenericBean2<Potion, String>> createEffects1List() {
		return Arrays.asList(
				new DGenericBean2<Potion, String>(MobEffects.SPEED, "speed"), // 1
				new DGenericBean2<Potion, String>(MobEffects.SLOWNESS, "slowness"), // 2
				new DGenericBean2<Potion, String>(MobEffects.HASTE, "haste"), // 3
				new DGenericBean2<Potion, String>(MobEffects.MINING_FATIGUE, "mining_fatigue"),// 4
				new DGenericBean2<Potion, String>(MobEffects.STRENGTH, "strength"),// 5
				new DGenericBean2<Potion, String>(MobEffects.JUMP_BOOST, "jump_boost"),// 6
				new DGenericBean2<Potion, String>(MobEffects.NAUSEA, "nausea"),// 7
				new DGenericBean2<Potion, String>(MobEffects.REGENERATION, "regeneration"),// 8
				new DGenericBean2<Potion, String>(MobEffects.RESISTANCE, "resistance"),// 9
				new DGenericBean2<Potion, String>(MobEffects.FIRE_RESISTANCE, "fire_resistance"),// 10
				new DGenericBean2<Potion, String>(MobEffects.WATER_BREATHING, "water_breathing"),// 11
				new DGenericBean2<Potion, String>(MobEffects.INVISIBILITY, "invisibility"),// 12
				new DGenericBean2<Potion, String>(MobEffects.BLINDNESS, "blindness"),// 13
				new DGenericBean2<Potion, String>(MobEffects.NIGHT_VISION, "night_vision"),// 14
				new DGenericBean2<Potion, String>(MobEffects.HUNGER, "hunger"),// 15
				new DGenericBean2<Potion, String>(MobEffects.WEAKNESS, "weakness"),// 16
				new DGenericBean2<Potion, String>(MobEffects.POISON, "poison"),// 17
				new DGenericBean2<Potion, String>(MobEffects.WITHER, "wither"),// 18
				new DGenericBean2<Potion, String>(MobEffects.HEALTH_BOOST, "health_boost"),// 19
				new DGenericBean2<Potion, String>(MobEffects.ABSORPTION, "absorption"),// 20
				new DGenericBean2<Potion, String>(MobEffects.SATURATION, "saturation"),// 21
				new DGenericBean2<Potion, String>(MobEffects.GLOWING, "glowing"),// 22
				new DGenericBean2<Potion, String>(MobEffects.LEVITATION, "levitation"),// 23
				new DGenericBean2<Potion, String>(MobEffects.LUCK, "luck"),// 24
				new DGenericBean2<Potion, String>(MobEffects.UNLUCK, "unluck") // 25
		);
	}
	
	private static void handleFileOutput(Teirs teir, PrintWriter out, List<DGenericBean2<Potion, String>> effects) {
		effects.forEach(effect -> handlePrintToFile(teir, out, effect));
	}

	private static void handlePrintToFile(Teirs teir, PrintWriter out, DGenericBean2<Potion, String> effect) {
		out.println("// " + effect.getValue2() + " teir " + (teir.getPotency() + 1));
		out.println(" { \"item\": \"dutils:pill\", \"data\": "+IDs+" }");
		out.println();
		++IDs;
	}

	private static void handleBeansInstant(Teirs teir, List<DGenericBean2<Potion, String>> effects) {
		effects.forEach(bean -> register(createBasic(bean.getValue1(), 1, teir.getPotency(), bean.getValue2())));
	}

	private static void handleBeans(Teirs teir, List<DGenericBean2<Potion, String>> effects) {
		effects.forEach(bean -> register(createBasic(bean.getValue1(), teir.getDuration(), teir.getPotency(), bean.getValue2())));
	}

	public static void registerRenderer() {
		IDs = 0;
		effects.forEach(e -> {
			DRegistry.registerRenderer(DItems.PILLS, IDs, "pill/"+e.getName());
			++IDs;
		});
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
