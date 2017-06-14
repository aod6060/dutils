package com.derf.utils.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class DBlockMeta {
	
	public static DBlockMeta DEFAULT = new DBlockMeta();
	
	private Material material = Material.ROCK;
	
	private float hardness = 1.0f;
	
	private float resistance = 1.0f;
	
	private float lightLevel = 0.0f;
	
	private String toolClass = "pickaxe";
	
	private int toolLevel = 0;
	
	private SoundType soundType = SoundType.STONE;
	
	public DBlockMeta() {}
	
	public DBlockMeta(
			Material material,
			float hardness,
			float resistance,
			float lightLevel,
			String toolClass,
			int toolLevel,
			SoundType soundType
	) {
		this.material = material;
		this.hardness = hardness;
		this.resistance = resistance;
		this.lightLevel = lightLevel;
		this.toolClass = toolClass;
		this.toolLevel = toolLevel;
		this.soundType = soundType;
	}

	public Material getMaterial() {
		return material;
	}

	public float getHardness() {
		return hardness;
	}

	public float getResistance() {
		return resistance;
	}

	public float getLightLevel() {
		return lightLevel;
	}

	public String getToolClass() {
		return toolClass;
	}

	public int getToolLevel() {
		return toolLevel;
	}

	public SoundType getSoundType() {
		return soundType;
	}
	
	
}
