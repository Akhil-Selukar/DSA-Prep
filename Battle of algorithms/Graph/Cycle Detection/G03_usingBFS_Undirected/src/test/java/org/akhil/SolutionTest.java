package org.akhil;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private List<List<Integer>> createGraph(int numNodes, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(numNodes);

        // Initialize all nodes
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
    
    Solution solution = new Solution();

    // =========================================================================
    // 1. Cycle Detection Tests (Returns true)
    // =========================================================================

    @Test
    void test_simpleCycle_3Nodes() {
        // Undirected Graph: 0--1--2--0 (A triangle)
        int[][] edges = {
                {0, 1}, {1, 0},
                {1, 2}, {2, 1},
                {2, 0}, {0, 2}
        };
        List<List<Integer>> graph = createGraph(3, edges);

        assertTrue(solution.detectCycle(graph), "A 3-node cycle (triangle) should be detected.");
    }

    @Test
    void test_cycle_4Nodes_Square() {
        // Undirected Graph: 0--1--2--3--0 (A square)
        int[][] edges = {
                {0, 1}, {1, 0},
                {1, 2}, {2, 1},
                {2, 3}, {3, 2},
                {3, 0}, {0, 3}
        };
        List<List<Integer>> graph = createGraph(4, edges);

        assertTrue(solution.detectCycle(graph), "A 4-node cycle should be detected.");
    }

    @Test
    void test_cycleInDisconnectedGraph() {
        // Component 1: 0--1--2--0 (Cycle). Component 2: 3--4 (No Cycle)
        int[][] edges = {
                {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 0}, {0, 2}, // Cycle Component
                {3, 4}, {4, 3} // Path Component
        };
        List<List<Integer>> graph = createGraph(5, edges);

        assertTrue(solution.detectCycle(graph), "Should detect a cycle even if a disconnected component is a tree.");
    }

    @Test
    void test_selfLoop() {
        // Undirected Graph: 0--1 and 2 has a self-loop (2--2)
        int[][] edges = {
                {0, 1}, {1, 0},
                {2, 2} // Self-loop
        };
        List<List<Integer>> graph = createGraph(3, edges);

        assertTrue(solution.detectCycle(graph), "A self-loop should be detected as a cycle.");
    }

    // =========================================================================
    // 2. Non-Cycle Detection Tests (Returns false)
    // =========================================================================

    @Test
    void test_noCycle_LinearPath() {
        // Undirected Graph: 0--1--2--3 (A path, no cycle)
        int[][] edges = {
                {0, 1}, {1, 0},
                {1, 2}, {2, 1},
                {2, 3}, {3, 2}
        };
        List<List<Integer>> graph = createGraph(4, edges);

        assertFalse(solution.detectCycle(graph), "A linear path should not register as a cycle.");
    }

    @Test
    void test_noCycle_Tree() {
        // Undirected Graph (Tree structure): 0--1, 0--2, 1--3
        int[][] edges = {
                {0, 1}, {1, 0},
                {0, 2}, {2, 0},
                {1, 3}, {3, 1}
        };
        List<List<Integer>> graph = createGraph(4, edges);

        assertFalse(solution.detectCycle(graph), "A tree structure should not contain a cycle.");
    }

    @Test
    void test_noCycle_DisconnectedTree() {
        // Component 1: 0--1. Component 2: 2--3
        int[][] edges = {
                {0, 1}, {1, 0},
                {2, 3}, {3, 2}
        };
        List<List<Integer>> graph = createGraph(4, edges);

        assertFalse(solution.detectCycle(graph), "Disconnected components that are trees should not contain a cycle.");
    }

    // =========================================================================
    // 3. Edge Case Tests
    // =========================================================================

    @Test
    void test_isolatedNodes() {
        // 5 nodes, 0 edges (A forest of 5 isolated nodes)
        int[][] edges = {};
        List<List<Integer>> graph = createGraph(5, edges);

        assertFalse(solution.detectCycle(graph), "A graph with only isolated nodes should not have a cycle.");
    }

    @Test
    void test_emptyGraph() {
        int[][] edges = {};
        List<List<Integer>> graph = createGraph(0, edges);

        assertFalse(solution.detectCycle(graph), "An empty graph should not have a cycle.");
    }

    @Test
    void test_nullGraph() {
        assertFalse(solution.detectCycle(null), "A null graph should return false.");
    }

}