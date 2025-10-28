package org.akhil;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    // Helper method to create the adjacency list structure
    private List<List<Pair>> createGraph(int numNodes, int[][] edgeList) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edgeList) {
            // edge is {source, destination, weight}
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }
        return graph;
    }
    
    Solution solution = new Solution();

    // =========================================================================
    // Test Cases
    // =========================================================================

    @Test
    void test_SimplePath() {
        int numNodes = 3;
        // 0 --(10)--> 1 --(5)--> 2
        int[][] edges = {{0, 1, 10}, {1, 2, 5}};
        List<List<Pair>> graph = createGraph(numNodes, edges);

        int[] distances = solution.dijkstra(graph, 0);

        // Expected distances: 0 to 0 is 0, 0 to 1 is 10, 0 to 2 is 15
        assertArrayEquals(new int[]{0, 10, 15}, distances, "Simple linear path check failed.");
    }

    @Test
    void test_MultiplePaths() {
        int numNodes = 4;
        // 0 --(10)--> 1
        // 0 --(1)--> 2 --(1)--> 3
        // 1 --(1)--> 3
        int[][] edges = {{0, 1, 10}, {0, 2, 1}, {2, 3, 1}, {1, 3, 1}};
        List<List<Pair>> graph = createGraph(numNodes, edges);

        int[] distances = solution.dijkstra(graph, 0);

        // Shortest path to 3 is via 2: 0 -> 2 -> 3 (weight 1 + 1 = 2)
        assertArrayEquals(new int[]{0, 10, 1, 2}, distances, "Multiple path selection failed.");
    }

    @Test
    void test_UnreachableNode() {
        int numNodes = 4;
        // Component 1: 0 --(1)--> 1
        // Component 2: 2 --(1)--> 3 (Unreachable from 0)
        int[][] edges = {{0, 1, 1}};
        List<List<Pair>> graph = createGraph(numNodes, edges);

        int[] distances = solution.dijkstra(graph, 0);

        // Nodes 2 and 3 should be (int)1e9
        assertEquals(0, distances[0]);
        assertEquals(1, distances[1]);
        assertEquals((int)1e9, distances[2], "Unreachable node 2 check failed.");
        assertEquals((int)1e9, distances[3], "Unreachable node 3 check failed.");
    }

    @Test
    void test_GraphWithCycle() {
        int numNodes = 3;
        // Cycle: 0 --(10)--> 1 --(1)--> 2 --(1)--> 0 (Cycle doesn't help as weights are positive)
        int[][] edges = {{0, 1, 10}, {1, 2, 1}, {2, 0, 1}};
        List<List<Pair>> graph = createGraph(numNodes, edges);

        int[] distances = solution.dijkstra(graph, 0);

        // Expected: 0->0 (0), 0->1 (10), 0->2 (11)
        assertArrayEquals(new int[]{0, 10, 11}, distances, "Cycle check failed.");
    }

    @Test
    void test_StartNodeIsDestination() {
        int numNodes = 5;
        // 0 -> 1 -> 2 -> 3 -> 4
        int[][] edges = {{0, 1, 1}, {1, 2, 1}, {2, 3, 1}, {3, 4, 1}};
        List<List<Pair>> graph = createGraph(numNodes, edges);

        int[] distances = solution.dijkstra(graph, 3);

        // Expected: 3->3 (0), 3->4 (1)
        assertEquals((int)1e9, distances[0], "0 should be unreachable from 3.");
        assertEquals((int)1e9, distances[1], "1 should be unreachable from 3.");
        assertEquals((int)1e9, distances[2], "2 should be unreachable from 3.");
        assertEquals(0, distances[3], "Start node distance must be 0.");
        assertEquals(1, distances[4], "3 to 4 distance should be 1.");
    }

    @Test
    void test_LargeWeightedGraph() {
        int numNodes = 7;
        // Example Graph (V=7, E=11)
        int[][] edges = {
                {0, 1, 2}, {0, 2, 6},
                {1, 3, 5},
                {2, 3, 8},
                {3, 5, 15}, {3, 4, 10},
                {4, 5, 6}, {4, 6, 2},
                {5, 6, 6},
                {1, 4, 2} // Shorter path from 1 to 4
        };
        List<List<Pair>> graph = createGraph(numNodes, edges);

        int[] distances = solution.dijkstra(graph, 0);

        // Expected shortest paths from 0:
        // 0 -> 0: 0
        // 0 -> 1: 2
        // 0 -> 2: 6
        // 0 -> 3: via 1: 2+5 = 7 (via 2: 6+8=14)
        // 0 -> 4: via 1: 2+2 = 4
        // 0 -> 5: via 4: 4+6 = 10 (via 3: 7+15=22)
        // 0 -> 6: via 4: 4+2 = 6 (via 5: 10+6=16)

        int[] expected = {0, 2, 6, 7, 4, 10, 6};
        assertArrayEquals(expected, distances, "Complex graph shortest path test failed.");
    }

    @Test
    void test_OnlyOneNode() {
        int numNodes = 1;
        int[][] edges = {};
        List<List<Pair>> graph = createGraph(numNodes, edges);

        int[] distances = solution.dijkstra(graph, 0);

        assertArrayEquals(new int[]{0}, distances, "Single node graph test failed.");
    }

}