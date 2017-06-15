package com.derf.utils.crafting;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import com.derf.utils.DLogger;
import com.derf.utils.util.DHolder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;

/**
 * This will wrap up the new recipe system...
 * 
 * Deprecated for the new recipe system from forge...
 * @author Fred
 *
 */
@Deprecated
public class DCraftingManager {
	
	private static Map<String, DHolder<String, IRecipe>> craftingRegistry = new HashMap<String, DHolder<String, IRecipe>>();
	
	public static void registerRecipes(String modid) {
		load(modid);
		register();
	}
	
	private static void register() {
		Collection<DHolder<String, IRecipe>> list = craftingRegistry.values();
		
		for(DHolder<String, IRecipe> holder : list) {
			// Register all recipes with Minecraft...
			//CraftingManager.func_193379_a(holder.getValue1(), holder.getValue2());
			
			
		}
	}

	private static void load(String modid) {
		// Uses file system...
		FileSystem fileSystem = null;
		// Create Builder
		GsonBuilder builder = new GsonBuilder();
		// Use Pretty Printing
		builder = builder.setPrettyPrinting();
		// Disable Html Escape keys, we don't need them...
		builder = builder.disableHtmlEscaping();
		// Create Gson Object
		Gson gson = builder.create();
		// Test url
		URL url = DCraftingManager.class.getResource("/assets/assetroot");
		
		String recipesPath = "/assets/"+modid+"/recipes";
		
		try {
			if(url != null) {
				
				URI uri = url.toURI();
				
				Path path = null;
				
				String scheme = uri.getScheme();
				
				if(scheme.equals("file")) {
					path = Paths.get(DCraftingManager.class.getResource(recipesPath).toURI());
				} else {
					if(!scheme.equals("jar")) {
						return;
					}
					fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap());
					path = fileSystem.getPath(recipesPath);
				}
				
				Iterator<Path> paths = Files.walk(path).iterator();
				
				iteratePaths(gson, paths, path);
			}
		} catch(URISyntaxException | IOException e) {
			DLogger.getLogger().error(e.getMessage());
		}
	}
	
	private static void iteratePaths(Gson gson, Iterator<Path> paths, Path path) {
		
		int i = 0;
		
		while(paths.hasNext()) {
			
			Path absolutePath = paths.next();
			
			String fileExt = FilenameUtils.getExtension(absolutePath.toString());
			
			if(fileExt.equals("json")) {
				Path relPath = path.relativize(absolutePath);
				
				String name = FilenameUtils.removeExtension(relPath.toString().replaceAll("\\\\", "/"));
				
				ResourceLocation nameResource = new ResourceLocation(name);
				
				
				BufferedReader reader = null;
				
				++i;
				
				try {
					try {
						reader = Files.newBufferedReader(absolutePath);
						IRecipe recipe = parseJson(JsonUtils.func_193839_a(gson, reader, JsonObject.class));
						set(name, recipe);
					} catch(JsonParseException e) {
						DLogger.getLogger().error("Json Parser Error: " + relPath.toString() + ": \"" + e.getMessage() + "\"");
						continue;
					} catch (IOException e) {
						DLogger.getLogger().error("IOException??? File can't load: " + e.getMessage());
						continue;
					}
				} finally {
					IOUtils.closeQuietly(reader);
				}
			}
		}
	}

	private static void set(String name, IRecipe recipe) {
		//CraftingManager.func_193379_a(name, recipe);
		craftingRegistry.put(name, new DHolder<String, IRecipe>(name, recipe));
	}
	
	private static DHolder<String, IRecipe> get(String name) {
		return craftingRegistry.get(name);
	}
	
	private static IRecipe parseJson(JsonObject object) throws JsonSyntaxException {
		String typeValue = JsonUtils.getString(object, "type");
		
		if(typeValue.equals("crafting_shaped")) {
			return ShapedRecipes.func_193362_a(object);
		} else if(typeValue.equals("crafting_shapeless")) {
			return ShapelessRecipes.func_193363_a(object);
		} else {
			throw new JsonSyntaxException("This recipe type is invalid or unsupported: '" + typeValue + "'");
		}
	}
}
