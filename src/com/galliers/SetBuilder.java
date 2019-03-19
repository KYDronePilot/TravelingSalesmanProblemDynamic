package com.galliers;


import java.util.Arrays;
import java.util.Comparator;

/**
 * For managing the generation of all subsets of vertices.
 *
 * @author Michael Galliers
 */
class SetBuilder {
    private static int subset_i;
    private int[] vertices;
    private int n;

    /**
     * Initially set the vertices and the number of them.
     *
     * @param vertices The vertices for this particular problem.
     * @param n        The number of vertices.
     */
    SetBuilder(int[] vertices, int n) {
        this.vertices = vertices;
        this.n = n;
        subset_i = 0;
    }

    /**
     * Generate all subsets of vertices.
     *
     * @return Array of all subsets of the vertices.
     */
    Set[] generateSubsets() {
        // Number of subsets.
        int sub_sets_n = (int) Math.pow(2, n);
        Set[] sub_sets = new Set[sub_sets_n];
        char[] B = new char[n];
        generateSubsets(B, n, sub_sets);
        // Sort subsets by number of elements non-decreasing.
        Arrays.sort(sub_sets, Comparator.comparingInt(Set::getN));
        return sub_sets;
    }

    /**
     * Generate all subsets of vertices recursively.
     *
     * @param B        Binary char array for generating all possible subsets.
     * @param n        The number of elements remaining.
     * @param sub_sets Array to store generated subsets.
     */
    private void generateSubsets(char[] B, int n, Set[] sub_sets) {
        if (n < 1) {
            // Convert binary array to a set.
            Set new_set = translateBinary(B);
            sub_sets[subset_i++] = new_set;
        } else {
            // Let binary array position be either a zero or one, recursively diminishing.
            B[this.n - n] = '0';
            generateSubsets(B, n - 1, sub_sets);
            B[this.n - n] = '1';
            generateSubsets(B, n - 1, sub_sets);
        }
    }

    /**
     * Translate a binary array into a set.
     *
     * @param B The binary array.
     * @return The resulting set.
     */
    private Set translateBinary(char[] B) {
        int i, j = 0, cnt = 0;
        // Get number of elements.
        for (i = 0; i < n; i++)
            if (B[i] == '1')
                cnt++;
        // Get vertices of new set.
        int[] vertices = new int[cnt];
        for (i = 0; i < n; i++) {
            if (B[i] == '1')
                vertices[j++] = this.vertices[i];
        }
        // Create set.
        return new Set(vertices, cnt);
    }
}
