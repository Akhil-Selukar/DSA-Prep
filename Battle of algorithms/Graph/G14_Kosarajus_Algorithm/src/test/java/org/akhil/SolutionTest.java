package org.akhil;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    // Helper method to convert the result (List<List<Integer>>) into a canonical
    // format (Set<Set<Integer>>) for order-independent comparison.
    private Set<Set<Integer>> toCanonicalSet(List<List<Integer>> sccs) {
        Set<Set<Integer>> canonicalSet = new HashSet<>();
        for (List<Integer> scc : sccs) {
            // Sort the list of nodes for consistent order before converting to set
            scc.sort(Integer::compareTo);
            canonicalSet.add(new HashSet<>(scc));
        }
        return canonicalSet;
    }

    Solution solution = new Solution();

    // --- Test Cases ---

    @Test
    void testSingleNode() {
        // Graph: 0
        int numNodes = 1;
        List<List<Integer>> adj = Arrays.asList(Collections.emptyList());

        List<List<Integer>> result = solution.kosaraju(numNodes, adj);
        Set<Set<Integer>> expected = Set.of(Set.of(0));

        assertEquals(expected, toCanonicalSet(result));
    }

    @Test
    void testLinearDAG() {
        // Graph: 0 -> 1 -> 2
        int numNodes = 3;
        List<List<Integer>> adj = Arrays.asList(
                Arrays.asList(1), // 0 -> 1
                Arrays.asList(2), // 1 -> 2
                Collections.emptyList() // 2
        );

        // Each node is its own SCC
        List<List<Integer>> result = solution.kosaraju(numNodes, adj);
        Set<Set<Integer>> expected = Set.of(Set.of(0), Set.of(1), Set.of(2));

        assertEquals(expected, toCanonicalSet(result));
    }

    @Test
    void testSingleLargeCycle() {
        // Graph: 0 -> 1 -> 2 -> 0 (single SCC)
        int numNodes = 3;
        List<List<Integer>> adj = Arrays.asList(
                Arrays.asList(1), // 0 -> 1
                Arrays.asList(2), // 1 -> 2
                Arrays.asList(0)  // 2 -> 0
        );

        List<List<Integer>> result = solution.kosaraju(numNodes, adj);
        Set<Set<Integer>> expected = Set.of(Set.of(0, 1, 2));

        assertEquals(expected, toCanonicalSet(result));
    }

    @Test
    void testMultipleDisconnectedCycles() {
        // Cycle 1: 0 -> 1 -> 0
        // Cycle 2: 2 -> 3 -> 2
        int numNodes = 4;
        List<List<Integer>> adj = Arrays.asList(
                Arrays.asList(1), // 0 -> 1
                Arrays.asList(0), // 1 -> 0
                Arrays.asList(3), // 2 -> 3
                Arrays.asList(2)  // 3 -> 2
        );

        List<List<Integer>> result = solution.kosaraju(numNodes, adj);
        Set<Set<Integer>> expected = Set.of(Set.of(0, 1), Set.of(2, 3));

        assertEquals(expected, toCanonicalSet(result));
    }

    @Test
    void testStandardExampleGraph() {
        // Graph from CLRS or common examples:
        // 0->1, 1->2, 2->0 (SCC1: 0, 1, 2)
        // 2->3, 3->4, 4->3 (SCC2: 3, 4)
        // 4->5, 5->6, 6->7, 7->5 (SCC3: 5, 6, 7)
        int numNodes = 8;
        List<List<Integer>> adj = Arrays.asList(
                Arrays.asList(1),        // 0 -> 1
                Arrays.asList(2),        // 1 -> 2
                Arrays.asList(0, 3),     // 2 -> 0, 2 -> 3
                Arrays.asList(4),        // 3 -> 4
                Arrays.asList(3, 5),     // 4 -> 3, 4 -> 5
                Arrays.asList(6),        // 5 -> 6
                Arrays.asList(7),        // 6 -> 7
                Arrays.asList(5)         // 7 -> 5
        );

        List<List<Integer>> result = solution.kosaraju(numNodes, adj);

        Set<Set<Integer>> expected = Set.of(
                Set.of(0, 1, 2),
                Set.of(3, 4),
                Set.of(5, 6, 7)
        );

        assertEquals(expected, toCanonicalSet(result));
    }

    @Test
    void testInterConnectedComponents() {
        // SCC 1: {0, 1} (0->1, 1->0)
        // SCC 2: {2, 3} (2->3, 3->2)
        // Link: 1 -> 2
        int numNodes = 4;
        List<List<Integer>> adj = Arrays.asList(
                Arrays.asList(1), // 0 -> 1
                Arrays.asList(0, 2), // 1 -> 0, 1 -> 2
                Arrays.asList(3), // 2 -> 3
                Arrays.asList(2)  // 3 -> 2
        );

        // SCCs are still {0, 1} and {2, 3}. The edge 1->2 is a component-to-component edge.
        List<List<Integer>> result = solution.kosaraju(numNodes, adj);
        Set<Set<Integer>> expected = Set.of(Set.of(0, 1), Set.of(2, 3));

        assertEquals(expected, toCanonicalSet(result));
    }

}