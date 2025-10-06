package org.akhil;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SegmentTreeTest {
    // Test case 1: Basic construction and full range query
    @Test
    void testConstructionAndFullQuery() {
        int[] arr = {1, 3, 5, 7, 9}; // Total Sum = 25
        SegmentTree st = new SegmentTree(arr);

        // Full range sum query
        assertEquals(25, st.query(0, 4), "Test 1 Failed: Full range sum should be 25.");
    }

    // Test case 2: Partial range queries
    @Test
    void testPartialQueries() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(arr);

        // [1, 3] -> 3 + 5 + 7 = 15
        assertEquals(15, st.query(1, 3), "Test 2 Failed: Query [1, 3] should be 15.");

        // [4, 5] -> 9 + 11 = 20
        assertEquals(20, st.query(4, 5), "Test 2 Failed: Query [4, 5] should be 20.");

        // [0, 0] -> 1 (Single element query)
        assertEquals(1, st.query(0, 0), "Test 2 Failed: Query [0, 0] should be 1.");
    }

    // Test case 3: Update operation and subsequent query checks
    @Test
    void testUpdate() {
        int[] arr = {10, 20, 30, 40}; // Total Sum = 100
        SegmentTree st = new SegmentTree(arr);

        assertEquals(100, st.query(0, 3), "Test 3 Failed: Initial sum should be 100.");

        // Update index 1 (value 20) to 5
        // New array: {10, 5, 30, 40}. New total sum = 85
        st.update(1, 5);

        // Check full range after update
        assertEquals(85, st.query(0, 3), "Test 3 Failed: Full sum after update should be 85.");

        // Check partial range affected by update [0, 1] -> 10 + 5 = 15
        assertEquals(15, st.query(0, 1), "Test 3 Failed: Partial sum [0, 1] after update should be 15.");

        // Check partial range not affected by update [2, 3] -> 30 + 40 = 70
        assertEquals(70, st.query(2, 3), "Test 3 Failed: Partial sum [2, 3] should be 70.");
    }

    // Test case 4: Edge cases (Single element array)
    @Test
    void testSingleElementArray() {
        int[] arr = {42};
        SegmentTree st = new SegmentTree(arr);

        assertEquals(42, st.query(0, 0), "Test 4 Failed: Single element query.");

        // Update the single element
        st.update(0, 99);
        assertEquals(99, st.query(0, 0), "Test 4 Failed: Update on single element.");
    }

    // Test case 5: Invalid queries and updates (Should handle boundary checks outside the tree)
    @Test
    void testInvalidQueries() {
        int[] arr = {1, 2, 3};
        SegmentTree st = new SegmentTree(arr);

        // Assuming your code throws an exception or handles the out-of-bounds index gracefully/incorrectly.
        // Since your current code doesn't have explicit boundary checks in the public methods:
        // We will test for a case that is valid in the query range

        // Querying an index out of bounds (0..2)
        // If the query is [0, 3], it should ideally throw an exception, but your implementation might run into a NullPointerException
        // or unexpected behavior. Since the input array is length 3, valid range is [0, 2].
        assertThrows(NullPointerException.class, () -> st.query(0, 3), "Invalid query range [0, 3] should fail (NPE/Error expected).");

        // Test update outside bounds (Assuming similar failure)
        assertThrows(NullPointerException.class, () -> st.update(3, 100), "Invalid update index 3 should fail (NPE/Error expected).");
    }
}