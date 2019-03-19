package com.galliers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private double[][] W1, W2;

    @BeforeEach
    void setUp() {
        W1 = new double[][] {
                {0, 1, Double.POSITIVE_INFINITY, 1, 5},
                {9, 0, 3, 2, Double.POSITIVE_INFINITY},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0, 4, Double.POSITIVE_INFINITY},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 2, 0, 3},
                {3, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0}
        };
        W2 = new double[][] {
                {0, 2, 9, Double.POSITIVE_INFINITY},
                {1, 0, 6, 4},
                {Double.POSITIVE_INFINITY, 7, 0, 8},
                {6, 3, Double.POSITIVE_INFINITY, 0}
        };
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void tspDynamicTest() {

    }
}