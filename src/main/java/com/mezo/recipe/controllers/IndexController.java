package com.mezo.recipe.controllers;

import com.mezo.recipe.domains.Category;
import com.mezo.recipe.domains.UnitOfMeasure;
import com.mezo.recipe.repositories.CategoryRepo;
import com.mezo.recipe.repositories.UnitOfMeasureRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    CategoryRepo categoryRepo;
    UnitOfMeasureRepo unitOfMeasureRepo;

    public IndexController(CategoryRepo categoryRepo, UnitOfMeasureRepo unitOfMeasureRepo) {
        this.categoryRepo = categoryRepo;
        this.unitOfMeasureRepo = unitOfMeasureRepo;
    }

    @RequestMapping({"", "/", "/index", "/index/"})
    String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepo.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepo.findByDescription("Cup");

        categoryOptional.ifPresent(category -> System.out.println(category.getId()));
        unitOfMeasureOptional.ifPresent(unitOfMeasure -> System.out.println(unitOfMeasure.getId()));

        return "index";
    }

}
