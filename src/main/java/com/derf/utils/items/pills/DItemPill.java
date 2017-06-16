package com.derf.utils.items.pills;

import com.derf.utils.items.DItem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


/*
 * Effect type: Potions
 * Duration: how long a the effect will last
 * Potency: How powerful the effect will be.
 * 
 * Special Case for Cure - This will cure a player with any affect... Similar to drinking milk...
 */
public class DItemPill extends DItem {

	public DItemPill(String name) {
		super(name);
		this.setHasSubtypes(true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs itemIn, NonNullList<ItemStack> tab) {		
		if(this.func_194125_a(itemIn)) {
			for(int i = 0; i < DPillEffectsFactory.getMaxSize(); i++) {
				tab.add(new ItemStack(this, 1, i));
			}
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		// TODO Auto-generated method stub
		//return super.getUnlocalizedName(stack);
		return this.getUnlocalizedName() + "." + DPillEffectsFactory.get(stack.getMetadata()).getName();
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(
			World world, 
			EntityPlayer player, 
			EnumHand hand) {
		
		if(!world.isRemote) {
			ItemStack stack = player.getHeldItemMainhand();
			int meta = stack.getMetadata();
			IDPillEffect effect = DPillEffectsFactory.get(meta);
			effect.onPillEffect(player);
			world.playSound(
					(EntityPlayer)null, 
					player.posX, 
					player.posY, 
					player.posZ, 
					SoundEvents.ENTITY_PLAYER_BURP, 
					SoundCategory.PLAYERS, 
					0.5F, 
					world.rand.nextFloat() * 0.1F + 0.9F);
			stack.shrink(1);
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}
	
	
}
