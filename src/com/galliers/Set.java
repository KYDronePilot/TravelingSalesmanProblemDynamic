package com.galliers;

public class Set {
    private char[] elements;
    private int n;

    Set(char[] elements, int n) {
        this.elements = elements;
        this.n = n;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        for (int i = 0; i < n - 1; i++) {
            builder.append("v").append(elements[i]).append(", ");;
        }
        builder.append("v").append(elements[n - 1]).append("}");
        return builder.toString();
    }
}
