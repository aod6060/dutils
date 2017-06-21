package com.derf.utils.items;

import com.derf.utils.util.DUtility;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DItemFoodGironApple extends DItemFood {

	public DItemFoodGironApple(String name, int amount, float saturation, boolean isWolfFood) {
		super(name, amount, saturation, isWolfFood);
		this.setHasSubtypes(true);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean hasEffect(ItemStack stack) {
		return super.hasEffect(stack) || stack.getMetadata() > 0;
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return stack.getMetadata() == 0 ? EnumRarity.RARE : EnumRarity.EPIC;
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote) {
			
			if(stack.getMetadata() > 0) {
				player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 6000, 4));
				player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 6000, 4));
				player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 4));
				player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 6000, 4));
			} else {
				player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 3000, 3));
				player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 3000, 3));
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs item, NonNullList<ItemStack> tab) {
		if(DUtility.isInCreativeTab(item, this)) {
			tab.add(new ItemStack(this));
			tab.add(new ItemStack(this, 1, 1));
		}
	}
	
}
