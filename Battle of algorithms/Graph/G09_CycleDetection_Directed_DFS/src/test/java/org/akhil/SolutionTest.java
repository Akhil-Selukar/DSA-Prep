package org.akhil;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    // Topological Sort Test Cases
    // =========================================================================

    @Test
    void test_SimpleLinearGraph() {
        int numNodes = 4;
        // Edges: 0 -> 1, 1 -> 2, 2 -> 3
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
        List<List<Integer>> adj = createAdjList(numNodes, edges);

        boolean result = solution.isCyclic(adj);

        assertFalse(result, "Cycle is not present.");
    }

    @Test
    void test_GraphWithMultipleValidOrders() {
        int numNodes = 6;
        // Edges: 5->2, 5->0, 4->0, 4->1, 2->3, 3->1
        int[][] edges = {{5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};
        List<List<Integer>> adj = createAdjList(numNodes, edges);

        boolean result = solution.isCyclic(adj);

        assertFalse(result, "Cycle is not present");
    }

    @Test
    void test_GraphWithOnlyOneNode() {
        int numNodes = 1;
        int[][] edges = {};
        List<List<Integer>> adj = createAdjList(numNodes, edges);

        boolean result = solution.isCyclic(adj);

        assertFalse(result, "Cycle is not present");
    }

    @Test
    void test_EmptyGraph() {
        int numNodes = 0;
        int[][] edges = {};
        List<List<Integer>> adj = createAdjList(numNodes, edges);

        boolean result = solution.isCyclic(adj);

        assertFalse(result, "Cycle is not present");
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

        boolean result = solution.isCyclic(adj);

        assertFalse(result, "Cycle is not present");
    }

    @Test
    void test_GraphWithCycle() {
        int numNodes = 3;
        // Edges: 0 -> 1, 1 -> 2, 2 -> 0 (Cycle: 0-1-2-0)
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        List<List<Integer>> adj = createAdjList(numNodes, edges);

        boolean result = solution.isCyclic(adj);

        assertTrue(result, "Cycle is present");
    }

    @Test
    void test_ComplexGraphWithSelfLoopCycle() {
        int numNodes = 4;
        // Edges: 0 -> 1, 1 -> 1 (self loop cycle), 2 -> 3
        int[][] edges = {{0, 1}, {1, 1}, {2, 3}};
        List<List<Integer>> adj = createAdjList(numNodes, edges);

        boolean result = solution.isCyclic(adj);

        assertTrue(result, "Cycle is present");
    }

    // =========================================================================
    // Directed Cycle Detection Tests
    // =========================================================================

    @Test
    void test_AcyclicGraph_ShouldNotDetectCycle() {
        int numNodes = 5;
        // Edges: 0 -> 1, 0 -> 2, 1 -> 3, 2 -> 3, 3 -> 4 (Simple DAG)
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4}};
        List<List<Integer>> adj = createAdjList(numNodes, edges);

        assertFalse(solution.isCyclic(adj), "Cycle is not present");
    }

    @Test
    void test_SimpleCycle_ShouldDetect() {
        int numNodes = 3;
        // Edges: 0 -> 1, 1 -> 2, 2 -> 0 (Cycle: 0-1-2-0)
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        List<List<Integer>> adj = createAdjList(numNodes, edges);

        assertTrue(solution.isCyclic(adj), "Cycle is present");
    }

    @Test
    void test_SelfLoopCycle_ShouldDetect() {
        int numNodes = 3;
        // Edges: 0 -> 1, 1 -> 1 (self loop cycle)
        int[][] edges = {{0, 1}, {1, 1}};
        List<List<Integer>> adj = createAdjList(numNodes, edges);

        assertTrue(solution.isCyclic(adj), "Cycle is present");
    }

    @Test
    void test_DisconnectedGraph_WithOneCycle() {
        int numNodes = 6;
        // Component 1 (Cycle): 0 -> 1, 1 -> 0
        // Component 2 (DAG): 2 -> 3 -> 4
        // Component 3 (Isolated): 5
        int[][] edges = {{0, 1}, {1, 0}, {2, 3}, {3, 4}};
        List<List<Integer>> adj = createAdjList(numNodes, edges);

        assertTrue(solution.isCyclic(adj), "Cycle is present");
    }

    @Test
    void test_ComplexCycleInLargeGraph() {
        int numNodes = 7;
        // Edges: 0->1, 1->2, 2->3, 3->4, 4->5, 5->6 (Linear)
        // Cycle: 6->3 (Back edge creates a cycle 3-4-5-6-3)
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 3}};
        List<List<Integer>> adj = createAdjList(numNodes, edges);

        assertTrue(solution.isCyclic(adj), "Cycle is present");
    }
}