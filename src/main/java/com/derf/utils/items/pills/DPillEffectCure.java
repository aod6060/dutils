package com.derf.utils.items.pills;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

/**
 * This is a special case were this pill will cure an entity of
 * all potion effects. Act like milk...
 * @author Fred
 *
 */
public class DPillEffectCure implements IDPillEffect {

	@Override
	public void onPillEffect(EntityPlayer player, ItemStack stack) {
		player.curePotionEffects(stack);
	}

	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Potion getEffect() {
		// TODO Auto-generated method stub
		return null;
	}

}
