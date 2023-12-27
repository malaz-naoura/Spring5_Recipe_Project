package com.mezo.recipe.services;

import com.mezo.recipe.repositories.RecipeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepo recipeRepo;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    void getAllRecipes() {
//        recipeService=new RecipeServiceImpl(recipeRepo);
//
//        Recipe recipe=new Recipe();
//        recipeRepo.save(recipe);
//
//        ArrayList<Recipe> recipes= recipeService.getAllRecipes();
//
//        System.out.println(recipes.size());
//        assertEquals(recipes.size(),1);


    }
}