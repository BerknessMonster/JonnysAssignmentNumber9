package com.coderscampus.JonnyAssignment9.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.JonnyAssignment9.domain.Recipe;
import com.coderscampus.JonnyAssignment9.service.FileIntake;

@RestController
public class RecipeController {
	
	@Autowired
	private FileIntake FileIntake; 

	@GetMapping("/all-recipes")
	public List<Recipe> getAllRecipes() throws IOException { 
		List<Recipe> recipes = FileIntake.readFile();

		return recipes;

	}

	@GetMapping("/vegan")
	public List<Recipe> returnVegan() throws IOException {
		List<Recipe> recipes_vegan = FileIntake.readFile()
				.stream()
				.filter(vegan -> vegan.getVegan() == true)
				.collect(Collectors.toList());

		return recipes_vegan;

	}

	@GetMapping("/vegan_and_gluten_free")
	public List<Recipe> returnVeganAndGlutenFree() throws IOException {
		List<Recipe> veganAndGluten = FileIntake.readFile()
				.stream()
				.filter(element -> element.getVegan() == true && element
				.getGlutenFree() == true)
				.collect(Collectors.toList());

		return veganAndGluten;

	}

	@GetMapping("/vegetarian")
	public List<Recipe> returnVegetarian() throws IOException {
		List<Recipe> vegetarian = FileIntake.readFile()
				.stream()
				.filter(element -> element.getVegetarian() == true)
			    .collect(Collectors.toList());

		return vegetarian;

	}

	@GetMapping("/gluten_free")
	public List<Recipe> returnGlutenFree() throws IOException {
		List<Recipe> glutenFree = FileIntake.readFile()
				.stream()
				.filter(element -> element
				.getGlutenFree() == true)
				.collect(Collectors.toList());

		return glutenFree;

	}
}
