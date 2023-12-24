package com.mezo.recipe.domains;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class UnitOfMeasure extends BaseEntity {
    private String description;
}
