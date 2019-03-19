package com.galliers;


import java.util.HashMap;

public class Main {
    /**
     * Solve the TSP problem using a dynamic programming approach.
     *
     * @param W The adjacency matrix of distances between vertices.
     * @param n The dimension of the adjacency matrix.
     * @return The shortest distance that can be obtained.
     */
    private static double tspDynamic(double[][] W, int n) {
        // Initialize D and P tables.
        HashMap<Set, Double>[] D = new HashMap[n];
        HashMap<Set, Integer>[] P = new HashMap[n];
        for (int i = 0; i < n; i++) {
            D[i] = new HashMap<>();
            P[i] = new HashMap<>();
        }
        // Get vertices.
        int[] vertices = new int[n - 1];
        for (int i = 0; i < n - 1; i++)
            vertices[i] = i + 2;
        Set set = new Set(vertices, n - 1);
        // Generate all subsets, excluding first element.
        SetBuilder set_builder = new SetBuilder(vertices, n - 1);
        Set[] subsets = set_builder.generateSubsets();
        int subset_n = (int) Math.pow(2, n - 1);
        // Handle each subset at a time.
        for (int i = 1; i < subset_n; i++) {
            // The subset we will be working with.
            Set subset = subsets[i];
            // Get the first choices for the distances table.
            Set first_choices;
            if (i < subset_n - 1)
                // If not last, use cities - v1 - subset.
                first_choices = set.subtract(subset);
            else
                // Else, if last, use {v1}.
                first_choices = new Set(new int[]{1}, 1);
            // Try each of those first choices.
            for (int j = 0; j < first_choices.getN(); j++) {
                // The vertex we will be working with.
                int vertex = first_choices.getVertex(j);
                // Minimum distance and k value.
                double min_dist = Double.POSITIVE_INFINITY;
                int min_k_choice = subset.getVertex(0);
                // Get the minimum distance.
                for (int k = 0; k < subset.getN(); k++) {
                    // The k-choice being worked with.
                    int k_choice = subset.getVertex(k);
                    // All other vertices except for the k-choice.
                    Set other_vertices = subset.subtract(new Set(new int[]{k_choice}, 1));
                    // Base case if there are no other vertices.
                    if (other_vertices.isEmpty())
                        D[k_choice - 1].put(other_vertices, W[k_choice - 1][0]);
                    double dist = W[vertex - 1][k_choice - 1] + D[k_choice - 1].get(other_vertices);
                    // If distance is less than the minimum, update the minimum.
                    if (dist < min_dist) {
                        min_dist = dist;
                        min_k_choice = k_choice;
                    }
                }
                // Set the minimum distances and K-value.
                D[vertex - 1].put(subset, min_dist);
                P[vertex - 1].put(subset, min_k_choice);
            }
        }
        // Print out the D and P arrays.
        printD(D, n, subsets);
        printP(P, n, subsets);
        // Print out the optimal path.
        printPath(P, set);
        return D[0].get(set);
    }

    /**
     * Print out the complete path.
     *
     * @param P   The P array from the problem.
     * @param set The set of elements to choose from.
     */
    private static void printPath(HashMap<Set, Integer>[] P, Set set) {
        System.out.print("Best Path: {");
        int vertex = 1;
        while (!set.isEmpty()) {
            System.out.printf("v%d, ", vertex);
            vertex = P[vertex - 1].get(set);
            set = set.subtract(new Set(new int[]{vertex}, 1));
        }
        // Handle last vertex.
        System.out.printf("v%d}", vertex);
        System.out.println();
    }

    /**
     * Print out the D table.
     * @param D       The D table.
     * @param n       The dimension of that table.
     * @param subsets Array of subsets for this problem.
     */
    private static void printD(HashMap<Set, Double>[] D, int n, Set[] subsets) {
        int length = (int) Math.pow(2, n - 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < length; j++) {
                System.out.printf("%10.1f, ", D[i].get(subsets[j]));
            }
            System.out.println();
        }
    }

    /**
     * Print out the P table.
     * @param D       The P table.
     * @param n       The dimension of that table.
     * @param subsets Array of subsets for this problem.
     */
    private static void printP(HashMap<Set, Integer>[] D, int n, Set[] subsets) {
        int length = (int) Math.pow(2, n - 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < length; j++) {
                System.out.printf("%5d, ", D[i].get(subsets[j]));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] W1 = {
                {0, 1, Double.POSITIVE_INFINITY, 1, 5},
                {9, 0, 3, 2, Double.POSITIVE_INFINITY},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0, 4, Double.POSITIVE_INFINITY},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 2, 0, 3},
                {3, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0}
        };
        double[][] W2 = {
                {0, 2, 9, Double.POSITIVE_INFINITY},
                {1, 0, 6, 4},
                {Double.POSITIVE_INFINITY, 7, 0, 8},
                {6, 3, Double.POSITIVE_INFINITY, 0}
        };
        HashMap[] D = new HashMap[]{new HashMap()};
        HashMap[] P = new HashMap[]{new HashMap()};
        int n = 4;
        System.out.println(tspDynamic(W2, n));
    }
}
