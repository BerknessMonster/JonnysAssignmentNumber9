package com.coderscampus.JonnyAssignment9.service;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.coderscampus.JonnyAssignment9.domain.Recipe;

@Service
public class FileIntake {
	public List<Recipe> readFile() throws IOException {
	
		Reader recipeReader = new FileReader("Recipe.txt");
		Iterable<CSVRecord> records = CSVFormat.DEFAULT
				.withFirstRecordAsHeader()
				.withIgnoreSurroundingSpaces()
				.withEscape('\\')
				.parse(recipeReader);
		List<Recipe> allRecipes = new ArrayList<>();
		
		for (CSVRecord record : records) {
			Recipe recipe = new Recipe();
			
			recipe.setCookingMinutes(Integer.parseInt(record.get("Cooking Minutes")));
			recipe.setDairyFree(Boolean.parseBoolean(record.get("Dairy Free")));
			recipe.setGlutenFree(Boolean.parseBoolean(record.get("Gluten Free")));
			recipe.setInstructions(record.get("Instructions"));
			recipe.setPreparationMinutes(Double.parseDouble(record.get("Preparation Minutes")));
			recipe.setPricePerServing(Double.parseDouble(record.get("Price Per Serving")));
			recipe.setReadyInMinutes( Integer.parseInt(record.get("Ready In Minutes")));
			recipe.setServings(Integer.parseInt(record.get("Servings")));
			recipe.setSpoonacularScore(Double.parseDouble(record.get("Spoonacular Score")));
			recipe.setTitle(record.get("Title"));
			recipe.setVegan(Boolean.parseBoolean(record.get("Vegan")));
			recipe.setVegetarian(Boolean.parseBoolean(record.get("Vegetarian")));
			
			
			allRecipes.add(recipe);
		    System.out.println(recipe.toString());
		    System.out.println(recipe);
		   
		}
		return allRecipes;
		
		        
}

}
