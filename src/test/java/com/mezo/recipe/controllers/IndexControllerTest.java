package com.mezo.recipe.controllers;

import com.mezo.recipe.services.RecipeServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IndexControllerTest {
    AutoCloseable autoCloseable;

    @Mock
    RecipeServiceImpl recipeService;

    @Mock
    Model model;

    @Mock
    IndexController indexController;

    @BeforeEach
    void setUp() {
        autoCloseable=MockitoAnnotations.openMocks(this);
    }

    @Test
    void getIndexPage() {
        IndexController indexController = new IndexController(recipeService);
        String ui_name = indexController.getIndexPage(model);

        assertEquals("index", ui_name);
        Mockito.verify(recipeService,Mockito.times(1)).getAllRecipes();
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
}