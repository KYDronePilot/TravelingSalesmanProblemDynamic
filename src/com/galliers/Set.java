package com.galliers;


/**
 * A set representation for a dynamic programming solution to the
 * traveling salesman problem.
 *
 * @author Michael Galliers
 */
public class Set {
    private int[] vertices;
    private int n;

    /**
     * Build set from array of vertices.
     *
     * @param vertices The array of vertices given.
     * @param n        The number of vertices (set elements).
     */
    Set(int[] vertices, int n) {
        this.vertices = vertices;
        this.n = n;
    }

    /**
     * Converts a set to standard set notation and prints it out.
     *
     * @return String formatted version of set.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        for (int i = 0; i < n - 1; i++) {
            builder.append("v").append(vertices[i]).append(", ");;
        }
        builder.append("v").append(vertices[n - 1]).append("}");
        return builder.toString();
    }

    /**
     * Check if this and other set are the same.
     *
     * @param other The other set
     * @return True if same, false if not.
     */
    public boolean equals(Set other) {
        // Not same if sizes do not match.
        if (n != other.n)
            return false;
        // Check by elements.
        for (int i = 0; i < n; i++)
            if (vertices[i] != other.vertices[i])
                return false;
        return true;
    }
}
