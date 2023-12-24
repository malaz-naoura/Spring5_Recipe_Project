package com.mezo.recipe.controllers;

import com.mezo.recipe.domains.Category;
import com.mezo.recipe.domains.UnitOfMeasure;
import com.mezo.recipe.repositories.CategoryRepo;
import com.mezo.recipe.repositories.UnitOfMeasureRepo;
import com.mezo.recipe.services.RecipeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    CategoryRepo categoryRepo;
    UnitOfMeasureRepo unitOfMeasureRepo;
    RecipeServiceImpl recipeServiceImpl;

    public IndexController(CategoryRepo categoryRepo, UnitOfMeasureRepo unitOfMeasureRepo, RecipeServiceImpl recipeServiceImpl) {
        this.categoryRepo = categoryRepo;
        this.unitOfMeasureRepo = unitOfMeasureRepo;
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @RequestMapping({"", "/", "/index", "/index/"})
    String getIndexPage(Model model) {
        log.debug("Index page is loaded");
        Optional<Category> categoryOptional = categoryRepo.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepo.findByDescription("Cup");

//        categoryOptional.ifPresent(category -> System.out.println(category.getId()));
//        unitOfMeasureOptional.ifPresent(unitOfMeasure -> System.out.println(unitOfMeasure.getId()));

        ArrayList recipes = recipeServiceImpl.getAllRecipes();
        model.addAttribute("recipes",recipes);
        return "index";
    }

}
