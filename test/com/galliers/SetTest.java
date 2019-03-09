package com.galliers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetTest {
    private Set set_1, set_2, set_3;
    private int[] vertices_1, vertices_2, vertices_3;
    private int n1, n2, n3;

    @BeforeEach
    void setUp() {
        n1 = 4;
        n2 = 4;
        n3 = 3;
        vertices_1 = new int[] {1, 2, 3, 4};
        vertices_2 = new int[] {1, 2, 3, 4};
        vertices_3 = new int[] {1, 2, 3};
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
    void equals() {
        // First two should be equal, last should not.
        assertTrue(set_1.equals(set_2));
        assertFalse(set_2.equals(set_3));
    }
}