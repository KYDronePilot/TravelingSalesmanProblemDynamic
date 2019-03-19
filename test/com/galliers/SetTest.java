package com.galliers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetTest {
    private Set set_1, set_2, set_3;

    @BeforeEach
    void setUp() {
        int n1 = 4;
        int n2 = 4;
        int n3 = 3;
        int[] vertices_1 = new int[]{1, 2, 3, 4};
        int[] vertices_2 = new int[]{1, 2, 3, 4};
        int[] vertices_3 = new int[]{1, 2, 3};
        set_1 = new Set(vertices_1, n1);
        set_2 = new Set(vertices_2, n2);
        set_3 = new Set(vertices_3, n3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void toStringTest() {
        String val1 = set_1.toString();
        String val2 = set_2.toString();
        String val3 = set_3.toString();
        // Same since values are the same.
        assertEquals(val1, val2);
        // Should be how sets are printed out.
        assertEquals(val1, "{v1, v2, v3, v4}");
        assertEquals(val3, "{v1, v2, v3}");
    }

    @Test
    void equalsTest() {
        // First two should be equal, last should not.
        assertEquals(set_1, set_2);
        assertNotEquals(set_2, set_3);
    }

    @Test
    void subtractTest() {
        // Test two subtractions.
        Set subtracted_1 = set_1.subtract(set_3);
        Set equality_1 = new Set(new int[]{4}, 1);
        Set subtracted_2 = set_3.subtract(set_2);
        Set equality_2 = new Set(new int[]{}, 0);
        // Assert the correct responses.
        assertEquals(subtracted_1, equality_1);
        assertEquals(subtracted_2, equality_2);
    }
}