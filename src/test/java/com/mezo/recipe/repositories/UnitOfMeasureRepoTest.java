package com.mezo.recipe.repositories;

import com.mezo.recipe.domains.UnitOfMeasure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepoTest {

    UnitOfMeasureRepo unitOfMeasureRepo;

    @Autowired  // required here but I don't know why
    public UnitOfMeasureRepoTest(UnitOfMeasureRepo unitOfMeasureRepo) {
        this.unitOfMeasureRepo = unitOfMeasureRepo;
    }

    @Test
    void findByDescription() {
        UnitOfMeasure unitOfMeasure = unitOfMeasureRepo.findByDescription("Cup").get();
        Assertions.assertEquals("Cup", unitOfMeasure.getDescription());
    }
}