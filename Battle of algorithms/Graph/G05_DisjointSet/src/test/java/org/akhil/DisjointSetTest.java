package org.akhil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisjointSetTest {
    // =========================================================================
    // Initialization Tests
    // =========================================================================

    @Test
    void test_Initialization_CorrectSizeAndSets() {
        DisjointSet ds = new DisjointSet(5); // Elements 0, 1, 2, 3, 4
        assertEquals(5, ds.getTotalComponents(), "Initially, the number of sets should equal the number of elements.");

        // Verify each element is its own root
        for (int i = 0; i < 5; i++) {
            assertEquals(i, ds.findParent(i), "Initially, each element should be the root of its own set.");
        }
    }

    @Test
    void test_Initialization_SingleElement() {
        DisjointSet ds = new DisjointSet(1);
        assertEquals(1, ds.getTotalComponents());
        assertEquals(0, ds.findParent(0));
    }

    @Test
    void test_Initialization_InvalidSizeThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new DisjointSet(0);
        }, "Initializing with size 0 should throw IllegalArgumentException.");
    }

    // =========================================================================
    // Union Operation Tests
    // =========================================================================

    @Test
    void test_Union_BasicMerge() {
        DisjointSet ds = new DisjointSet(5);

        assertTrue(ds.union(1, 2), "Union of 1 and 2 should succeed.");
        assertEquals(4, ds.getTotalComponents(), "After one union, 4 sets should remain.");
        assertTrue(ds.isConnected(1, 2), "1 and 2 should be isConnected.");
        assertFalse(ds.isConnected(1, 3), "1 and 3 should not be isConnected yet.");

        assertTrue(ds.union(3, 4), "Union of 3 and 4 should succeed.");
        assertEquals(3, ds.getTotalComponents(), "After two unions, 3 sets should remain.");

        assertTrue(ds.union(1, 4), "Union across components (1 and 4) should succeed.");
        assertEquals(2, ds.getTotalComponents(), "After three unions, 2 sets (0 and the rest) should remain.");

        assertTrue(ds.isConnected(2, 3), "All elements 1, 2, 3, 4 should now be isConnected.");
    }

    @Test
    void test_Union_AlreadyConnected() {
        DisjointSet ds = new DisjointSet(5);
        ds.union(1, 2);
        ds.union(2, 3);

        // Try to union 1 and 3, which are already isConnected
        assertFalse(ds.union(1, 3), "Union of already isConnected elements should return false.");
        assertEquals(3, ds.getTotalComponents(), "Number of sets should not change if union failed.");
    }

    // =========================================================================
    // Find and isConnected Tests (Implicitly tests Path Compression)
    // =========================================================================

    @Test
    void test_Find_PathCompression_AfterMultipleUnions() {
        DisjointSet ds = new DisjointSet(6);

        // Union structure (simulating union by rank/size): 0->1->2, 3->4->5
        ds.union(0, 1); // Set 0/1
        ds.union(2, 3); // Set 2/3
        ds.union(4, 5); // Set 4/5

        // Union the sets to create a deeper structure
        ds.union(1, 3); // Merges Set 0/1 and Set 2/3
        ds.union(3, 5); // Merges the resulting set with Set 4/5

        // At this point, all elements 0-5 should be in one set.
        int root = ds.findParent(0);

        // Find operation on a deep node (e.g., 5) should compress the path
        int root5 = ds.findParent(5);

        assertEquals(root, root5, "All elements should have the same root after all unions.");
        assertEquals(1, ds.getTotalComponents(), "Only one set should remain.");

        // Test connection check
        assertTrue(ds.isConnected(0, 5), "0 and 5 must be isConnected.");
        assertTrue(ds.isConnected(2, 4), "2 and 4 must be isConnected.");

        // Re-find should be faster due to path compression
        int root1_after_compression = ds.findParent(1);
        assertEquals(root, root1_after_compression, "Path compression should be effective on subsequent finds.");
    }

    // =========================================================================
    // Disconnected Components Test
    // =========================================================================

    @Test
    void test_DisconnectedComponents() {
        DisjointSet ds = new DisjointSet(8);

        // Component 1: 0-1-2
        ds.union(0, 1);
        ds.union(1, 2);

        // Component 2: 3-4
        ds.union(3, 4);

        // Component 3: 5-6-7
        ds.union(5, 6);
        ds.union(6, 7);

        // 3 components remain (0/1/2, 3/4, 5/6/7) + one solitary element (none in this 8-node example)
        assertEquals(3, ds.getTotalComponents(), "Three distinct components should remain: {0,1,2}, {3,4}, {5,6,7}.");

        assertTrue(ds.isConnected(0, 2), "0 and 2 should be isConnected.");
        assertFalse(ds.isConnected(2, 3), "2 and 3 should not be isConnected.");

        // Final union to merge all
        ds.union(2, 3);
        ds.union(4, 7);

        assertEquals(1, ds.getTotalComponents(), "After merging all, only one set should remain.");
        assertTrue(ds.isConnected(0, 7), "All elements must be isConnected.");
    }
}