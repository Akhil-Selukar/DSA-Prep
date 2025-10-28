package org.akhil;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();
    
    @Test
    void testTreeGraphIsBipartite() {
        // Graph: 0-1, 1-2, 2-3 (a simple path, which is always bipartite)
        int numNodes = 4;
        List<List<Integer>> adj = Arrays.asList(
                Arrays.asList(1),               // 0: [1]
                Arrays.asList(0, 2),            // 1: [0, 2]
                Arrays.asList(1, 3),            // 2: [1, 3]
                Arrays.asList(2)                // 3: [2]
        );
        assertTrue(solution.isBipartite(adj));
    }

    @Test
    void testEvenCycleIsBipartite() {
        // Graph: 0-1, 1-2, 2-3, 3-0 (a 4-cycle)
        int numNodes = 4;
        List<List<Integer>> adj = Arrays.asList(
                Arrays.asList(1, 3),            // 0: [1, 3]
                Arrays.asList(0, 2),            // 1: [0, 2]
                Arrays.asList(1, 3),            // 2: [1, 3]
                Arrays.asList(0, 2)             // 3: [0, 2]
        );
        assertTrue(solution.isBipartite(adj));
    }

    @Test
    void testTwoDisconnectedBipartiteComponents() {
        // Component 1: 0-1
        // Component 2: 2-3
        int numNodes = 4;
        List<List<Integer>> adj = Arrays.asList(
                Arrays.asList(1),               // 0: [1]
                Arrays.asList(0),               // 1: [0]
                Arrays.asList(3),               // 2: [3]
                Arrays.asList(2)                // 3: [2]
        );
        assertTrue(solution.isBipartite(adj));
    }

    @Test
    void testSingleNodeIsBipartite() {
        // Graph: 0
        int numNodes = 1;
        List<List<Integer>> adj = Collections.singletonList(
                Collections.emptyList()
        );
        assertTrue(solution.isBipartite(adj));
    }

    @Test
    void testEmptyGraphIsBipartite() {
        // Graph with 5 nodes and no edges
        int numNodes = 5;
        List<List<Integer>> adj = Arrays.asList(
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList()
        );
        assertTrue(solution.isBipartite(adj));
    }

    // --- Non-Bipartite (Odd Cycle) Cases ---

    @Test
    void testThreeCycleIsNotBipartite() {
        // Graph: 0-1, 1-2, 2-0 (a triangle)
        int numNodes = 3;
        List<List<Integer>> adj = Arrays.asList(
                Arrays.asList(1, 2),            // 0: [1, 2]
                Arrays.asList(0, 2),            // 1: [0, 2]
                Arrays.asList(0, 1)             // 2: [0, 1]
        );
        assertFalse(solution.isBipartite(adj));
    }

    @Test
    void testFiveCycleIsNotBipartite() {
        // Graph: 0-1, 1-2, 2-3, 3-4, 4-0 (a 5-cycle)
        int numNodes = 5;
        List<List<Integer>> adj = Arrays.asList(
                Arrays.asList(1, 4),            // 0: [1, 4]
                Arrays.asList(0, 2),            // 1: [0, 2]
                Arrays.asList(1, 3),            // 2: [1, 3]
                Arrays.asList(2, 4),            // 3: [2, 4]
                Arrays.asList(3, 0)             // 4: [3, 0]
        );
        assertFalse(solution.isBipartite(adj));
    }

    @Test
    void testGraphWithOddCycleAndEvenCycle() {
        // Odd Cycle (0-1-2-0) connected to Even Cycle (3-4-5-6-3)
        // Since it contains an odd cycle, it should be non-bipartite.
        int numNodes = 7;
        List<List<Integer>> adj = Arrays.asList(
                Arrays.asList(1, 2),            // 0: [1, 2]
                Arrays.asList(0, 2, 3),         // 1: [0, 2, 3] (Bridge 1->3)
                Arrays.asList(0, 1),            // 2: [0, 1]
                Arrays.asList(1, 4, 6),         // 3: [1, 4, 6]
                Arrays.asList(3, 5),            // 4: [3, 5]
                Arrays.asList(4, 6),            // 5: [4, 6]
                Arrays.asList(3, 5)             // 6: [3, 5]
        );
        assertFalse(solution.isBipartite(adj));
    }

    @Test
    void testOddLengthPathWithSelfLoopIsNotBipartite() {
        // A self-loop on node 1 is essentially a 1-cycle (odd length).
        int numNodes = 2;
        List<List<Integer>> adj = Arrays.asList(
                Arrays.asList(1),               // 0: [1]
                Arrays.asList(0, 1)             // 1: [0, 1] (Self-loop)
        );
        assertFalse(solution.isBipartite(adj));
    }

}