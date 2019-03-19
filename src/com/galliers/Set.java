package com.galliers;


import java.util.HashSet;

/**
 * A set representation for a dynamic programming solution to the traveling salesman problem.
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
     * Get the value of n.
     *
     * @return The value of n.
     */
    int getN() {
        return n;
    }

    /**
     * Get the vertex at index i.
     * @param i The index being used.
     * @return The vertex at that index.
     */
    int getVertex(int i) {
        return vertices[i];
    }

    /**
     * Converts a set to standard set notation and prints it out.
     *
     * @return String formatted version of set.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        for (int i = 0; i < n - 1; i++)
            builder.append("v").append(vertices[i]).append(", ");
        if (n >= 1)
            builder.append("v").append(vertices[n - 1]);
        builder.append("}");
        return builder.toString();
    }

    /**
     * Check if this and other set are the same.
     *
     * @param o The other set
     * @return True if same, false if not.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Set))
            return false;
        Set set = (Set) o;
        // Not same if sizes do not match.
        if (n != set.n)
            return false;
        // Turn both into hash sets.
        HashSet<Integer> this_set = new HashSet<>();
        HashSet<Integer> other_set = new HashSet<>();
        for (int i = 0; i < n; i++)
            this_set.add(vertices[i]);
        for (int i = 0; i < set.n; i++)
            other_set.add(set.vertices[i]);
        // Check if other contains all elements of this set.
        for (int i = 0; i < n; i++)
            if (!other_set.contains(vertices[i]))
                return false;
        // Check if this set contains all elements of other set.
        for (int i = 0; i < set.n; i++)
            if (!this_set.contains(set.vertices[i]))
                return false;
        return true;
    }

    /**
     * Generate hash code based on the elements and size, not their order.
     *
     * @return Hash code for this object.
     */
    @Override
    public int hashCode() {
        // Add up element hash codes.
        int total = 0;
        for (int i = 0; i < n; i++)
            total += vertices[i] * 31 + 7;
        return total * n;
    }

    /**
     * Perform set subtraction on this and other sets.
     *
     * @param other The other set.
     * @return New resultant set.
     */
    Set subtract(Set other) {
        // Put other set elements in a hash table for quick lookup.
        HashSet<Integer> other_set = new HashSet<>();
        for (int i = 0; i < other.n; i++) {
            other_set.add(other.vertices[i]);
        }
        // Create new array of vertices.
        int[] new_vertices = new int[n];
        int new_n = 0;
        for (int i = 0; i < n; i++) {
            if (!other_set.contains(vertices[i]))
                new_vertices[new_n++] = vertices[i];
        }
        return new Set(new_vertices, new_n);
    }

    /**
     * Whether or not the set is the empty set.
     *
     * @return True if empty, false if not.
     */
    boolean isEmpty() {
        return n == 0;
    }
}
