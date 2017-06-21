package com.derf.utils.items.pills;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.compress.utils.IOUtils;

import com.derf.utils.DLoader;
import com.derf.utils.DLogger;
import com.derf.utils.util.DGenericBean3;

public class DPillRecipeGenerator {
	
	public static final String PATH = "../src/main/resources/assets/dutils/recipes";
	
	public static void generate() {
		List<IPillRecipeBuilder> recipeBuilders = createRecipeBuilder();
		recipeBuilders.forEach(DPillRecipeGenerator::handleBuilder);
	}
	
	public static List<PillRecipe> loadGeneratorData(String resource) {
		List<PillRecipe> recipes = new ArrayList<PillRecipe>();
		
		FileSystem fileSys = null;
		
		URL url = DPillRecipeGenerator.class.getResource("/assets/test.txt");
		
		if(url != null) {
			try {
				URI uri = url.toURI();
				
				Path path = null;
				
				String sch = uri.getScheme();
				
				if(sch.equals("file")) {
					path = Paths.get(DPillRecipeGenerator.class.getResource("/assets/"+DLoader.modid+"/recipes/generate").toURI());
				} else {
					if(!sch.equals("jar")) {
						DLogger.getLogger().error("Error: Scheme not supported, " + uri);
						return recipes;
					}
					
					fileSys = FileSystems.newFileSystem(uri, Collections.emptyMap());
					
					path = fileSys.getPath("/assets/"+DLoader.modid+"/recipes/generate");
				}
				
				
				handleFileLoading(recipes, resource, path);
				
			} catch (URISyntaxException | IOException e) {
				DLogger.getLogger().error("Error: Exception thrown by PillGenerator#loadGeneratorData, " + e.getMessage());
			} finally {
				IOUtils.closeQuietly(fileSys);
			}
		}
		
		return recipes;
	}
	
	private static void handleFileLoading(List<PillRecipe> recipes, String resource, Path path) {
		try(Stream<String> stream = Files.lines(Paths.get(path.toString() + "/" + resource + ".txt"))) {
			stream.forEach(str -> handleFileLine(recipes, str));
		} catch (IOException e) {
			DLogger.getLogger().error("Error: Exception thrown by PillGenerator#handleFileLoading, " + e.getMessage());
		}
	}

	private static void handleFileLine(List<PillRecipe> recipes, String str) {
		String[] args = str.split(" ");
		int input = Integer.parseInt(args[0]);
		int output = Integer.parseInt(args[1]);
		String name = args[2];
		recipes.add(new PillRecipe(input, output, name));
	}

	private static void handleBuilder(IPillRecipeBuilder builder) {
		builder.build();
	}

	private static List<IPillRecipeBuilder> createRecipeBuilder() {
		return Arrays.asList(
				new PillRecipeBuilder("teir2", "minecraft:iron_ingot"),
				new PillRecipeBuilder("teir3", "minecraft:gold_ingot")
		); // Create an empty recipe for now...
	}

	public static void outputJson(PrintWriter out, int input, int output, String name, String additionalIng) {
		out.println("{");
		out.println("\t\"type\": \"minecraft:crafting_shapeless\",");
		out.println("\t\"ingredients\": [");
		out.println("\t\t{ \"item\": \""+additionalIng+"\" },");
		out.println("\t\t{ \"item\": \"dutils:pill\", \"data\": "+input+"}");
		out.println("\t],");
		out.println("\t\"result\": { \"item\": \"dutils:pill\", \"data\": "+output+"}");
		out.println("}");
	}
	
	// Interface that helps with create recipe functions 
	private static interface IPillRecipeFunction {
		void handlePillRecipeGeneration(PillRecipe recipe);
	}
	
	private static interface IPillRecipeBuilder {
		List<PillRecipe> createList();
		void recipeHandler(PillRecipe recipe);
		void build();
	}
	
	
	private static class PillRecipeBuilder implements IPillRecipeBuilder {
		
		private String resName;
		private String addIng;
		
		public PillRecipeBuilder() {}
		
		public PillRecipeBuilder(String resName, String addIng) {
			this.resName = resName;
			this.addIng = addIng;
		}
		
		@Override
		public List<PillRecipe> createList() {
			return DPillRecipeGenerator.loadGeneratorData(this.resName);
		}

		@Override
		public void recipeHandler(PillRecipe recipe) {
			int input = recipe.getInput();
			int output = recipe.getOutput();
			String name = recipe.getName();
			try {
				PrintWriter out = new PrintWriter(PATH+"/pill_"+name+"_"+resName+".json");
				DPillRecipeGenerator.outputJson(out, input, output, name, this.addIng);
				out.close();
			} catch (FileNotFoundException e) {
				DLogger.getLogger().error("Error: " + e.getMessage());
			}
		}

		@Override
		public void build() {
			List<PillRecipe> recipes = this.createList();
			recipes.forEach(this::recipeHandler);
		}
		
	}
	
	private static class PillRecipe extends DGenericBean3<Integer, Integer, String> {
		
		public PillRecipe() { super(); }
		
		public PillRecipe(int input, int output, String name) {
			super(input, output, name);
		}
		
		public int getInput() {
			return this.getValue1();
		}
		
		public int getOutput() {
			return this.getValue2();
		}
		
		public String getName() {
			return this.getValue3();
		}
	}
}
