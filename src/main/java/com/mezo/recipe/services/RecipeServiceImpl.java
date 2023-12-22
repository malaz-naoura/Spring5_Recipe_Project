package com.mezo.recipe.services;

import com.mezo.recipe.domains.Recipe;
import com.mezo.recipe.repositories.RecipeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RecipeServiceImpl implements RecipeService {

    RecipeRepo recipeRepo;

    public RecipeServiceImpl(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    public ArrayList<Recipe> getAllRecipes(){
        return (ArrayList<Recipe>) recipeRepo.findAll();
    }
}
