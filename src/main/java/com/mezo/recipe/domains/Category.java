package com.mezo.recipe.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category extends BaseEntity {


    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;


}
