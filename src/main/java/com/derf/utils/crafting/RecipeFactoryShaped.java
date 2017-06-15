package com.derf.utils.crafting;

import com.google.gson.JsonObject;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;

@Deprecated
public class RecipeFactoryShaped implements IRecipeFactory {

	@Override
	public IRecipe parse(JsonContext context, JsonObject json) {
		// TODO Auto-generated method stub
		return ShapedRecipes.func_193362_a(json);
	}

}
