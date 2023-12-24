package com.mezo.recipe.bootstrap;

import com.mezo.recipe.domains.*;
import com.mezo.recipe.repositories.CategoryRepo;
import com.mezo.recipe.repositories.RecipeRepo;
import com.mezo.recipe.repositories.UnitOfMeasureRepo;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class dataloader implements CommandLineRunner {

    UnitOfMeasureRepo unitOfMeasureRepo;
    CategoryRepo categoryRepo;
    RecipeRepo recipeRepo;

    public dataloader(UnitOfMeasureRepo unitOfMeasureRepo, CategoryRepo categoryRepo, RecipeRepo recipeRepo) {
        this.unitOfMeasureRepo = unitOfMeasureRepo;
        this.categoryRepo = categoryRepo;
        this.recipeRepo = recipeRepo;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        loadData();
        log.debug("Data is loaded");
    }

    void loadData(){
        UnitOfMeasure teaspoon= unitOfMeasureRepo.findByDescription("Teaspoon").get();
        Category amricanCategory=categoryRepo.findByDescription("American").get();

        Recipe spicyGrilledChickenTacos=new Recipe();
        spicyGrilledChickenTacos.setCookTime(15);
        spicyGrilledChickenTacos.setPrepTime(20);
        spicyGrilledChickenTacos.addCategory(amricanCategory);
        spicyGrilledChickenTacos.setDifficulty(Difficulty.EASY);
        spicyGrilledChickenTacos.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        spicyGrilledChickenTacos.setDescription("Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.");
        spicyGrilledChickenTacos.setDirections("Prepare the grill:\n" +
                "Prepare either a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "Make the marinade and coat the chicken:\n" +
                "In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.");

        // Ingredients
        Ingredient cumin=new Ingredient();
        cumin.setDescription("cumin");
        cumin.setAmount(BigDecimal.valueOf(1));
        cumin.setUnitOfMeasure(teaspoon);

        // Notes
        Note note=new Note();
        note.setRecipeNotes("NUTRITION FACTS (PER SERVING) 655 CALORIES 44g FAT 32g CARBS 41g PROTEINs");

        spicyGrilledChickenTacos.addIngredient(cumin);
        spicyGrilledChickenTacos.setNote(note);

        recipeRepo.save(spicyGrilledChickenTacos);
    }
}
