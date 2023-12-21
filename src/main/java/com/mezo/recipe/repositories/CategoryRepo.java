package com.mezo.recipe.repositories;

import com.mezo.recipe.domains.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category,Long> {
}
