package com.mezo.recipe.controllers;

import com.mezo.recipe.services.RecipeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Slf4j
@Controller
public class IndexController {

    RecipeServiceImpl recipeServiceImpl;

    public IndexController(RecipeServiceImpl recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @RequestMapping({"", "/", "/index", "/index/"})
    String getIndexPage(Model model) {
        log.debug("Index page is loaded");

        ArrayList recipes = recipeServiceImpl.getAllRecipes();
        model.addAttribute("recipes",recipes);
        return "index";
    }

}
