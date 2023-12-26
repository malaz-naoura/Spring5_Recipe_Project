package com.mezo.recipe.domains;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;
    @BeforeEach
    void setUp() {
        category=new Category();
    }

    @Test
    void getId() {
        Long id=41L;

        category.setId(id);

        assertEquals(id,category.getId());
    }
}