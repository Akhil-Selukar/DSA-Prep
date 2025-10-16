package org.akhil;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private List<List<Integer>> createGraph(int numNodes, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(numNodes);

        // Initialize all nodes (important for graphs with isolated nodes)
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Check bounds for source node u
            if (u >= 0 && u < numNodes) {
                graph.get(u).add(v);
            }
        }
        return graph;
    }

    private static Solution solution;
    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }
    // =========================================================================
    // 1. Basic Path Traversal Tests
    // =========================================================================

    @Test
    void test_linearPath() {
        // Graph: 0 -> 1 -> 2 -> 3
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
        List<List<Integer>> graph = createGraph(4, edges);

        List<Integer> expected = Arrays.asList(0, 1, 2, 3);
        List<Integer> actual = solution.DFSTraversal( 0, graph);

        assertEquals(expected, actual, "DFS on a simple linear path should follow the sequence.");
    }

    @Test
    void test_treeStructure() {
        // Simple tree (5 nodes total, 0 is isolated): 1 -> {2, 3}, 2 -> {4}
        // Neighbors for 1: [2, 3]. Neighbors for 2: [4].
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}};
        List<List<Integer>> graph = createGraph(5, edges);

        // Expected Path: 1 -> 2 -> 4 -> backtrack to 3
        List<Integer> expected = Arrays.asList(1, 2, 4, 3);
        List<Integer> actual = solution.DFSTraversal(1, graph);

        assertEquals(expected, actual, "DFS should explore depth first (1->2->4, then backtrack to 3).");
    }

    // =========================================================================
    // 2. Cycle and Visited Logic Tests
    // =========================================================================

    @Test
    void test_simpleCycle() {
        // Graph: 0 -> 1 -> 2 -> 0
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        List<List<Integer>> graph = createGraph(3, edges);

        List<Integer> expected = Arrays.asList(0, 1, 2);
        List<Integer> actual = solution.DFSTraversal(0, graph);

        assertEquals(expected, actual, "DFS must correctly handle cycles by using the 'visited' status.");
    }

    @Test
    void test_complexCyclicGraph() {
        // Graph (4 nodes): 0 -> {1, 2}, 1 -> {2, 3}, 2 -> {3}, 3 -> {0}
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {2, 3}, {3, 0}};
        List<List<Integer>> graph = createGraph(4, edges);

        // Path: 0 -> 1 (new) -> 2 (new) -> 3 (new) -> (neighbor 0 is visited) -> backtrack
        List<Integer> expected = Arrays.asList(0, 1, 2, 3);
        List<Integer> actual = solution.DFSTraversal(0, graph);

        assertEquals(expected, actual, "DFS must visit all nodes exactly once in the reachable component.");
    }

    // =========================================================================
    // 3. Disconnected Component Tests
    // =========================================================================

    @Test
    void test_disconnectedGraph_startComponent() {
        // Component 1: 0 -> 1. Component 2: 2 -> 3. (4 nodes total)
        int[][] edges = {{0, 1}, {2, 3}};
        List<List<Integer>> graph = createGraph(4, edges);

        // Starting at 0 should only find the component {0, 1}.
        List<Integer> expected = Arrays.asList(0, 1);
        List<Integer> actual = solution.DFSTraversal(0, graph);

        assertEquals(expected, actual, "DFS should stop after traversing the component of the start node.");
        assertTrue(!actual.contains(2) && !actual.contains(3), "Should not visit nodes in disconnected component.");
    }

    // =========================================================================
    // 4. Edge Case Tests
    // =========================================================================

    @Test
    void test_isolatedStartNode() {
        // Graph with 3 nodes defined (0, 1, 2), but no edges
        int[][] edges = {};
        List<List<Integer>> graph = createGraph(3, edges);

        List<Integer> expected = Arrays.asList(0);
        List<Integer> actual = solution.DFSTraversal(0, graph);

        assertEquals(expected, actual, "DFS on an isolated start node should return only the start node.");
    }

    @Test
    void test_startNodeOutOfBounds() {
        // Graph has 4 nodes (0, 1, 2, 3). Start node is 4 (out of bounds).
        int[][] edges = {{0, 1}};
        List<List<Integer>> graph = createGraph(4, edges);

        List<Integer> expected = Collections.emptyList();
        List<Integer> actual = solution.DFSTraversal(4, graph);

        assertEquals(expected, actual, "DFS starting from a node outside [0, numNodes-1] should return an empty list.");
    }

    @Test
    void test_nullGraph() {
        // Null graph input
        List<Integer> expected = Collections.emptyList();
        List<Integer> actual = solution.DFSTraversal(0, null);

        assertEquals(expected, actual, "DFS with a null graph map should return an empty list.");
    }

    @Test
    void test_emptyGraph() {
        // Empty graph (numNodes = 0)
        List<List<Integer>> graph = createGraph(0, new int[][]{});
        List<Integer> expected = Collections.emptyList();
        List<Integer> actual = solution.DFSTraversal(0, graph);

        assertEquals(expected, actual, "DFS with an empty graph should return an empty list.");
    }
}