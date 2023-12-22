package com.mezo.recipe.domains;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Note getNote() {
        return note;
    }

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
