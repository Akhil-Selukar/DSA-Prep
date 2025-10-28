package org.akhil;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    // Helper method to create the undirected graph adjacency list for Prim's
    // Since MST is for undirected graphs, we add edges in both directions.
    private List<List<int[]>> createUndirectedGraph(int numNodes, int[][] edgeList) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edgeList) {
            // edge is {nodeA, nodeB, weight}
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]}); // Add reverse edge for undirected
        }
        return graph;
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
        int[][] edges = {{0, 1, 1}, {1, 2, 2}, {2, 3, 3}};
        List<List<int[]>> graph = createUndirectedGraph(numNodes, edges);

        int expectedMST = 1 + 2 + 3; // 6
        int actualMST = solution.minimumSpanningTree(graph);

        assertEquals(expectedMST, actualMST, "Simple tree MST weight failed.");
    }

    @Test
    void test_GraphWithCycle_PrioritizeMinWeight() {
        int numNodes = 5;
        // Cycle 0-1-2-0 weights: (10, 5, 2)
        // Expected MST should include the cheaper edges.
        int[][] edges = {
                {0, 1, 10},
                {1, 2, 5},
                {2, 0, 2}, // Cheapest edge in the cycle
                {0, 3, 1}, // Connects to a branch
                {3, 4, 20}
        };
        List<List<int[]>> graph = createUndirectedGraph(numNodes, edges);

        // Expected MST Edges: (0, 3, 1), (2, 0, 2), (1, 2, 5), (3, 4, 20) 
        // Total MST Weight: 1 + 2 + 5 + 20 = 28
        int expectedMST = 28;
        int actualMST = solution.minimumSpanningTree(graph);

        assertEquals(expectedMST, actualMST, "Cycle graph MST weight failed. Should pick min-weight edges.");
    }

    @Test
    void test_KruskalExampleGraph() {
        // Standard textbook example for MST (often used for Kruskal's, but works for Prim's too)
        int numNodes = 7;
        int[][] edges = {
                {0, 1, 7}, {0, 3, 5},
                {1, 2, 8}, {1, 3, 9}, {1, 4, 7},
                {2, 4, 5}, {2, 5, 12},
                {3, 4, 15}, {3, 6, 6},
                {4, 5, 8}, {4, 6, 11},
                {5, 6, 9}
        };
        List<List<int[]>> graph = createUndirectedGraph(numNodes, edges);

        // Expected MST Edges: (0,3,5), (3,6,6), (0,1,7), (1,4,7), (4,2,5), (4,5,8)
        // Total MST Weight: 5 + 6 + 7 + 7 + 5 + 8 = 38
        int expectedMST = 38;
        int actualMST = solution.minimumSpanningTree(graph);

        assertEquals(expectedMST, actualMST, "Complex MST calculation failed.");
    }

    @Test
    void test_DisconnectedGraph() {
        int numNodes = 4;
        // Component 1: 0-(1)-1
        // Component 2: 2-(10)-3 (Unconnected to Component 1)
        int[][] edges = {{0, 1, 1}, {2, 3, 10}};
        List<List<int[]>> graph = createUndirectedGraph(numNodes, edges);

        // Expected result for a disconnected graph is Long.MAX_VALUE (or a defined failure value)
        int expectedMST = 0;
        int actualMST = solution.minimumSpanningTree(graph);

        assertEquals(expectedMST, actualMST, "Disconnected graph should return failure value.");
    }

    @Test
    void test_OnlyOneNode() {
        int numNodes = 1;
        int[][] edges = {};
        List<List<int[]>> graph = createUndirectedGraph(numNodes, edges);

        int expectedMST = 0;
        int actualMST = solution.minimumSpanningTree(graph);

        assertEquals(expectedMST, actualMST, "Single node graph MST weight must be 0.");
    }

    @Test
    void test_EmptyGraph() {
        int numNodes = 0;
        int[][] edges = {};
        List<List<int[]>> graph = createUndirectedGraph(numNodes, edges);

        int expectedMST = 0;
        int actualMST = solution.minimumSpanningTree(graph);

        assertEquals(expectedMST, actualMST, "Empty graph MST weight must be 0.");
    }

}