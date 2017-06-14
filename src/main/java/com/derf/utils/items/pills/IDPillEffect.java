package com.derf.utils.items.pills;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public interface IDPillEffect {
	
	void onPillEffect(EntityPlayer player, ItemStack stack);
	
	int getDuration();
	
	int getLevel();
	
	Potion getEffect();
}
