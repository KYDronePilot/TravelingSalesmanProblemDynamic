package com.galliers;

import static org.junit.jupiter.api.Assertions.*;

class SetBuilderTest {
    SetBuilder set_builder;

    SetBuilderTest() {
        int[] vertices = new int[] {1, 2, 3, 4};
        set_builder = new SetBuilder(vertices, 4);
    }


}