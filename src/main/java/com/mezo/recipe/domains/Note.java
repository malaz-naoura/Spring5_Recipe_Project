package com.mezo.recipe.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import lombok.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Note extends BaseEntity{

    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNotes;

}
