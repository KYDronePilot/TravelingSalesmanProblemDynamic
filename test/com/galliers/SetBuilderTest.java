package com.galliers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetBuilderTest {
    private SetBuilder setBuilder;


    @BeforeEach
    void setUp() {
        setBuilder = new SetBuilder(new int[]{1, 2}, 2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void generateSubsetsTest() {
        Set[] subsets = setBuilder.generateSubsets();
        // Assert each of the subsets was generated properly.
        assertEquals(subsets[0].toString(), "{}");
        assertEquals(subsets[1].toString(), "{v2}");
        assertEquals(subsets[2].toString(), "{v1}");
        assertEquals(subsets[3].toString(), "{v1, v2}");
    }
}