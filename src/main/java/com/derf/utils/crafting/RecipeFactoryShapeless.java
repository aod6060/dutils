package com.derf.utils.crafting;

import com.google.gson.JsonObject;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;

@Deprecated
public class RecipeFactoryShapeless implements IRecipeFactory {

	@Override
	public IRecipe parse(JsonContext context, JsonObject json) {
		// TODO Auto-generated method stub
		return ShapelessRecipes.func_193363_a(json);
	}

}
