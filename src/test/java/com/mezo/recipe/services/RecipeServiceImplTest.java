package com.mezo.recipe.services;

import com.mezo.recipe.domains.Recipe;
import com.mezo.recipe.repositories.RecipeRepo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeServiceImplTest {

    AutoCloseable autoCloseable;

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepo recipeRepo;

    @BeforeEach
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);

    }

    @Test
    void getAllRecipes() {
        recipeService=new RecipeServiceImpl(recipeRepo);

        Recipe recipe=new Recipe();
        Set<Recipe> recipesData=new HashSet<>();
        recipesData.add(recipe);

        Mockito.when(recipeService.getAllRecipes()).thenReturn(new ArrayList<>(recipesData));
        ArrayList<Recipe> recipes= recipeService.getAllRecipes();

        assertEquals(recipes.size(),1);
    }
    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

}