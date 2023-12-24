package com.mezo.recipe.domains;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe extends BaseEntity {

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private String source;
    private String url;
    @Lob
    private String directions;
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Note note;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "recipe")
    private Set<Ingredient> ingredients=new HashSet<>();

    @ManyToMany
    @JoinTable(name ="MM_Recipe_Category",
     joinColumns = @JoinColumn(name="Recipe_id"),
    inverseJoinColumns = @JoinColumn(name="Category_id"))
    private Set<Category>categories=new HashSet<>();


    public void setNote(Note note) {
        note.setRecipe(this);
        this.note = note;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
    }


    public void addCategory(Category category) {
        this.categories.add(category);
    }
}
