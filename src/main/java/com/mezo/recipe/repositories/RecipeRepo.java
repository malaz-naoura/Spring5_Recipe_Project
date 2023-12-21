package com.mezo.recipe.repositories;

import com.mezo.recipe.domains.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepo extends CrudRepository<Recipe, Long> {
}
