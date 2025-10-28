package org.akhil;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    /**
     * Helper method to verify if a given order is a valid topological sort.
     * It ensures that for every edge (u -> v), u appears before v in the order.
     * @param numNodes The total number of nodes.
     * @param adj The adjacency list of the graph.
     * @param order The list to validate.
     * @return true if the order is valid, false otherwise.
     */
    private boolean isTopologicalOrderValid(int numNodes, List<List<Integer>> adj, List<Integer> order) {
        // 1. Check if all nodes are present and the size is correct
        if (order.size() != numNodes) {
            return false;
        }

        // 2. Map node to its index (position) in the sorted order
        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < order.size(); i++) {
            position.put(order.get(i), i);
        }

        // 3. Verify all edges (u -> v)
        for (int u = 0; u < numNodes; u++) {
            for (int v : adj.get(u)) {
                // If u appears AFTER v in the order, the order is invalid.
                if (position.get(u) >= position.get(v)) {
                    System.err.println("Invalid edge: " + u + " -> " + v +
                            ". Position of " + u + " (" + position.get(u) +
                            ") is not less than position of " + v + " (" + position.get(v) + ")");
                    return false;
                }
            }
        }
        return true;
    }

    // Helper to create an adjacency list
    private List<List<Integer>> createAdjList(int numNodes, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        return adj;
    }

    Solution solution = new Solution();

    // =========================================================================
    // Test Cases
    // =========================================================================

    @Test
    void test_SimpleLinearGraph() {
        int numNodes = 4;
        // Edges: 0 -> 1, 1 -> 2, 2 -> 3
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
        List<List<Integer>> adj = createAdjList(numNodes, edges);

        List<Integer> result = solution.topologicalSort(adj);

        assertEquals(numNodes, result.size(), "Result size should match number of nodes.");
        assertTrue(isTopologicalOrderValid(numNodes, adj, result), "The order must be topologically valid.");
        // Specific check for linear graph
        assertEquals(Arrays.asList(0, 1, 2, 3), result, "Linear graph should have only one valid order.");
    }

    @Test
    void test_GraphWithMultipleValidOrders() {
        int numNodes = 6;
        // Edges: 5->2, 5->0, 4->0, 4->1, 2->3, 3->1
        int[][] edges = {{5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};
        List<List<Integer>> adj = createAdjList(numNodes, edges);

        List<Integer> result = solution.topologicalSort(adj);

        assertEquals(numNodes, result.size(), "Result size should match number of nodes.");
        assertTrue(isTopologicalOrderValid(numNodes, adj, result), "The resulting order must be topologically valid.");

        // Example valid orders: [4, 5, 0, 2, 3, 1] or [5, 4, 2, 3, 0, 1]
        // Check core constraints: 5 before 2/0, 4 before 0/1, 2 before 3, 3 before 1.
        assertTrue(result.indexOf(5) < result.indexOf(2));
        assertTrue(result.indexOf(4) < result.indexOf(1));
    }

    @Test
    void test_GraphWithOnlyOneNode() {
        int numNodes = 1;
        int[][] edges = {};
        List<List<Integer>> adj = createAdjList(numNodes, edges);

        List<Integer> result = solution.topologicalSort(adj);

        assertEquals(1, result.size());
        assertEquals(Arrays.asList(0), result);
    }

    @Test
    void test_EmptyGraph() {
        int numNodes = 0;
        int[][] edges = {};
        List<List<Integer>> adj = createAdjList(numNodes, edges);

        List<Integer> result = solution.topologicalSort(adj);

        assertTrue(result.isEmpty(), "Result should be empty for an empty graph.");
    }

    @Test
    void test_DisconnectedComponents() {
        int numNodes = 7;
        // Component 1: 0 -> 1 -> 2
        // Component 2: 3 -> 4
        // Component 3: 5 (isolated)
        // Component 4: 6 (isolated)
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        List<List<Integer>> adj = createAdjList(numNodes, edges);

        List<Integer> result = solution.topologicalSort(adj);

        assertEquals(numNodes, result.size(), "Result size must include all nodes, even isolated ones.");
        assertTrue(isTopologicalOrderValid(numNodes, adj, result), "The resulting order must be topologically valid.");

        // Check core constraints for each component
        assertTrue(result.indexOf(0) < result.indexOf(1));
        assertTrue(result.indexOf(1) < result.indexOf(2));
        assertTrue(result.indexOf(3) < result.indexOf(4));
    }
}