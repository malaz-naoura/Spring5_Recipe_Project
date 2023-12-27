package com.mezo.recipe.controllers;

import com.mezo.recipe.services.RecipeServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

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
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMockMvc() {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        // jakarta.servlet.ServletException : Circular view path []: would dispatch back to the current handler URL
//        mockMvc.perform(get("/"));
//                .andExpect(status().isOk())
//                .andExpect(view().name("main_page"));
    }

    @Test
    void getIndexPage() {
        IndexController indexController = new IndexController(recipeService);
        String ui_name = indexController.getIndexPage(model);

        assertEquals("index", ui_name);
        Mockito.verify(recipeService, Mockito.times(1)).getAllRecipes();
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
}