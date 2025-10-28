package org.akhil;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    // Helper method to create the list of edges for Kruskal's
    private List<int[]> createEdgeList(int[][] edgeData) {
        List<int[]> edges = new ArrayList<>();
        for (int[] data : edgeData) {
            // edgeData is {nodeA, nodeB, weight}
            // Kruskal's works on undirected graphs, so order doesn't matter,
            // but the input should list the edge only once for simplicity.
            edges.add(new int[]{data[0], data[1], data[2]});
        }
        return edges;
    }

    Solution solution = new Solution();

    // =========================================================================
    // Test Cases
    // =========================================================================

    @Test
    void test_SimpleTree() {
        int numNodes = 4;
        // A graph that is already a tree
        // 0-(1)-1, 1-(2)-2, 2-(3)-3
        int[][] edgeData = {{0, 1, 1}, {1, 2, 2}, {2, 3, 3}};
        List<int[]> allEdges = createEdgeList(edgeData);

        int expectedMST = 1 + 2 + 3; // 6
        int actualMST = solution.kruskalsAlgo(allEdges, numNodes);

        assertEquals(expectedMST, actualMST, "Simple tree MST weight failed.");
    }

    @Test
    void test_GraphWithCycle_PrioritizeMinWeight() {
        int numNodes = 5;
        // Cycle 0-1-2-0 weights: (10, 5, 2). Kruskal's should pick 2 and 5, reject 10.
        int[][] edgeData = {
                {0, 1, 10},
                {1, 2, 5},
                {2, 0, 2}, // Cheapest edge in the cycle
                {0, 3, 1}, // Connects to a branch
                {3, 4, 20}
        };
        List<int[]> allEdges = createEdgeList(edgeData);

        // MST Edges (picked in order of weight): (0, 3, 1), (2, 0, 2), (1, 2, 5), (3, 4, 20)
        // Total MST Weight: 1 + 2 + 5 + 20 = 28
        int expectedMST = 28;
        int actualMST = solution.kruskalsAlgo(allEdges, numNodes);

        assertEquals(expectedMST, actualMST, "Cycle graph MST weight failed. Cycle rejection via DSU failed.");
    }

    @Test
    void test_KruskalExampleGraph() {
        // Standard textbook example for MST
        int numNodes = 7;
        int[][] edgeData = {
                {0, 1, 7}, {0, 3, 5},
                {1, 2, 8}, {1, 3, 9}, {1, 4, 7},
                {2, 4, 5}, {2, 5, 12},
                {3, 4, 15}, {3, 6, 6},
                {4, 5, 8}, {4, 6, 11},
                {5, 6, 9}
        };
        List<int[]> allEdges = createEdgeList(edgeData);

        // Expected MST weight is 38
        // Edges picked: (0,3,5), (3,6,6), (0,1,7), (1,4,7), (4,2,5 - ERROR, should be 2,4,5), (4,5,8)
        // Correct MST Edges: (0,3,5), (3,6,6), (0,1,7), (1,4,7 - ERROR, should be 1,4,7 or 0,1,7), (2,4,5), (4,5,8)
        // Correct MST Weight: 5 (0-3) + 6 (3-6) + 7 (0-1) + 7 (1-4) + 5 (2-4) + 8 (4-5) = 38
        int expectedMST = 38;
        int actualMST = solution.kruskalsAlgo(allEdges, numNodes);

        assertEquals(expectedMST, actualMST, "Complex graph MST calculation failed.");
    }

    @Test
    void test_DisconnectedGraph() {
        int numNodes = 4;
        // Component 1: 0-(1)-1
        // Component 2: 2-(10)-3 (Unconnected to Component 1)
        int[][] edgeData = {{0, 1, 1}, {2, 3, 10}};
        List<int[]> allEdges = createEdgeList(edgeData);

        // Only 2 edges will be included in the MST (0-1 and 2-3). Since numNodes=4, we need 3 edges.
        // Expected result for a disconnected graph is Long.MAX_VALUE
        int expectedMST = Integer.MAX_VALUE;
        int actualMST = solution.kruskalsAlgo(allEdges, numNodes);

        assertEquals(expectedMST, actualMST, "Disconnected graph should return failure value (Long.MAX_VALUE).");
    }

    @Test
    void test_GraphWithSelfLoopsAndParallelEdges() {
        int numNodes = 3;
        // Parallel Edges (0, 1, 5) and (0, 1, 10). Only the cheapest (5) should be used.
        // Self-Loop (1, 1, 1) should be ignored or not included.
        int[][] edgeData = {
                {0, 1, 10},
                {0, 1, 5},
                {1, 2, 2},
                {1, 1, 100} // Self loop - won't be unioned successfully
        };
        List<int[]> allEdges = createEdgeList(edgeData);

        // MST Edges: (1, 2, 2), (0, 1, 5)
        // Total MST Weight: 2 + 5 = 7
        int expectedMST = 7;
        int actualMST = solution.kruskalsAlgo(allEdges, numNodes);

        assertEquals(expectedMST, actualMST, "Parallel edges and self-loops check failed.");
    }

    @Test
    void test_OnlyOneNode() {
        int numNodes = 1;
        int[][] edgeData = {};
        List<int[]> allEdges = createEdgeList(edgeData);

        int expectedMST = 0;
        int actualMST = solution.kruskalsAlgo(allEdges, numNodes);

        assertEquals(expectedMST, actualMST, "Single node graph MST weight must be 0.");
    }

    @Test
    void test_EmptyGraph() {
        int numNodes = 0;
        int[][] edgeData = {};
        List<int[]> allEdges = createEdgeList(edgeData);

        int expectedMST = 0;
        int actualMST = solution.kruskalsAlgo(allEdges, numNodes);

        assertEquals(expectedMST, actualMST, "Empty graph MST weight must be 0.");
    }

}