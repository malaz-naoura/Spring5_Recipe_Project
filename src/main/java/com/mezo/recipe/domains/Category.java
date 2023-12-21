package com.mezo.recipe.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class Category extends BaseEntity {

    private String descriptions;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;
}
