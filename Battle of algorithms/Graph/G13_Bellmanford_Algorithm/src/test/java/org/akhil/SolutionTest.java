package org.akhil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private static final int INF = (int)1e9;
    Solution solution = new Solution();

    // --- Test Cases ---

    @Test
    void testSimpleGraph() {
        // 0 -> 1 (4), 0 -> 2 (2), 1 -> 3 (5), 2 -> 3 (2)
        int numNodes = 4;
        int[][] edges = {{0, 1, 4}, {0, 2, 2}, {1, 3, 5}, {2, 3, 2}};

        // Expected distances from node 0: [0, 4, 2, 4] (via 0->2->3)
        int[] expected = {0, 4, 2, 4};
        int[] result = solution.bellmanFord(numNodes, edges, 0);

        assertArrayEquals(expected, result);
    }

    @Test
    void testGraphWithNegativeWeights() {
        // 0 -> 1 (5), 1 -> 2 (-2), 2 -> 3 (3), 0 -> 3 (10)
        int numNodes = 4;
        int[][] edges = {{0, 1, 5}, {1, 2, -2}, {2, 3, 3}, {0, 3, 10}};

        // Path 0->1->2->3: 5 + (-2) + 3 = 6
        int[] expected = {0, 5, 3, 6};
        int[] result = solution.bellmanFord(numNodes, edges, 0);

        assertArrayEquals(expected, result);
    }

    @Test
    void testShortestPathThroughNegativeEdge() {
        // 0 -> 1 (5), 0 -> 2 (4), 1 -> 3 (1), 2 -> 3 (-5)
        int numNodes = 4;
        int[][] edges = {{0, 1, 5}, {0, 2, 4}, {1, 3, 1}, {2, 3, -5}};

        // Path 0->2->3: 4 + (-5) = -1 (shorter than 0->1->3: 6)
        int[] expected = {0, 5, 4, -1};
        int[] result = solution.bellmanFord(numNodes, edges, 0);

        assertArrayEquals(expected, result);
    }

    @Test
    void testNegativeCycleDetection() {
        // 0 -> 1 (1), 1 -> 2 (-1), 2 -> 0 (-1) -> Cycle 1 + (-1) + (-1) = -1
        int numNodes = 3;
        int[][] edges = {{0, 1, 1}, {1, 2, -1}, {2, 0, -1}};

        // All nodes in the cycle should be marked as NEGATIVE_CYCLE
        int[] expected = {-1};
        int[] result = solution.bellmanFord(numNodes, edges, 0);

        assertArrayEquals(expected, result);
    }

    @Test
    void testNegativeCyclePropagation() {
        // Cycle: 1 -> 2 (-1), 2 -> 1 (-1) -> Cycle -2
        // Path to cycle: 0 -> 1 (5)
        // Path from cycle: 2 -> 3 (10)
        int numNodes = 4;
        int[][] edges = {{0, 1, 5}, {1, 2, -1}, {2, 1, -1}, {2, 3, 10}};

        // Node 0: Start node (0)
        // Node 1 & 2: Inside cycle (NEGATIVE_CYCLE)
        // Node 3: Reachable from cycle (NEGATIVE_CYCLE)
        int[] expected = {-1};
        int[] result = solution.bellmanFord(numNodes, edges, 0);

        assertArrayEquals(expected, result);
    }

    @Test
    void testUnreachableNodes() {
        // 0 -> 1 (1)
        // Node 2 is isolated
        int numNodes = 3;
        int[][] edges = {{0, 1, 1}};

        // Node 2 should be INF
        int[] expected = {0, 1, INF};
        int[] result = solution.bellmanFord(numNodes, edges, 0);

        assertArrayEquals(expected, result);
    }

    @Test
    void testDisconnectedComponentWithNegativeCycle() {
        // Component 1 (from 0): 0 -> 1 (1)
        // Component 2 (negative cycle): 2 -> 3 (-1), 3 -> 2 (-1)
        int numNodes = 4;
        int[][] edges = {{0, 1, 1}, {2, 3, -1}, {3, 2, -1}};

        // Nodes 0, 1 are standard paths. Nodes 2, 3 are unreachable and should be INF.
        int[] expected = {0, 1, INF, INF};
        int[] result = solution.bellmanFord(numNodes, edges, 0);

        assertArrayEquals(expected, result);
    }
}