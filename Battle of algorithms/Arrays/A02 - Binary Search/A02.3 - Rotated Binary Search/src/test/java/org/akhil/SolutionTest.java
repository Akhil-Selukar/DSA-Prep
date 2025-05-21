package org.akhil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    // --- Basic Scenarios ---

    @Test
    @DisplayName("Should find target in right part of rotated array")
    void testTargetInRightRotatedPart() {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        assertEquals(4, solution.binarySearch(arr, target), "Target 0 should be at index 4");
    }

    @Test
    @DisplayName("Should find target in left part of rotated array")
    void testTargetInLeftRotatedPart() {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 6;
        assertEquals(2, solution.binarySearch(arr, target), "Target 6 should be at index 2");
    }

    @Test
    @DisplayName("Should find target at the pivot point")
    void testTargetAtPivot() {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 7; // This is the largest element before the "wrap-around"
        assertEquals(3, solution.binarySearch(arr, target), "Target 7 should be at index 3");
    }

    @Test
    @DisplayName("Should return -1 when target not found in rotated array")
    void testTargetNotFoundInRotatedArray() {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        assertEquals(-1, solution.binarySearch(arr, target), "Target 3 should not be found");
    }

    // --- Edge Cases ---

    @Test
    @DisplayName("Should handle no rotation (standard sorted array)")
    void testNoRotation() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        int target = 3;
        assertEquals(3, solution.binarySearch(arr, target), "Target 3 should be at index 3 in an unrotated array");
    }

    @Test
    @DisplayName("Should handle single element array - found")
    void testSingleElementArrayFound() {
        int[] arr = {5};
        int target = 5;
        assertEquals(0, solution.binarySearch(arr, target), "Target 5 should be at index 0 in single element array");
    }

    @Test
    @DisplayName("Should handle single element array - not found")
    void testSingleElementArrayNotFound() {
        int[] arr = {5};
        int target = 10;
        assertEquals(-1, solution.binarySearch(arr, target), "Target 10 should not be found in single element array");
    }

    @Test
    @DisplayName("Should handle an empty array")
    void testEmptyArray() {
        int[] arr = {};
        int target = 5;
        assertEquals(-1, solution.binarySearch(arr, target), "Should return -1 for an empty array");
    }

    @Test
    @DisplayName("Should handle null array gracefully")
    void testNullArray() {
        int[] arr = null;
        int target = 10;
        assertEquals(-1, solution.binarySearch(arr, target), "Should return -1 for a null array");
    }

    @Test
    @DisplayName("Should handle array rotated by 1 position (target found at end)")
    void testRotatedByOneFoundEnd() {
        int[] arr = {3, 1, 2};
        int target = 2;
        assertEquals(2, solution.binarySearch(arr, target), "Target 2 should be at index 2 in rotated by 1 array");
    }

    @Test
    @DisplayName("Should handle array rotated by 1 position (target found at beginning)")
    void testRotatedByOneFoundBeginning() {
        int[] arr = {3, 1, 2};
        int target = 3;
        assertEquals(0, solution.binarySearch(arr, target), "Target 3 should be at index 0 in rotated by 1 array");
    }

    @Test
    @DisplayName("Should handle array with only two elements (ascending)")
    void testTwoElementsAscending() {
        int[] arr = {1, 2};
        assertEquals(0, solution.binarySearch(arr, 1), "Target 1 should be at index 0");
        assertEquals(1, solution.binarySearch(arr, 2), "Target 2 should be at index 1");
        assertEquals(-1, solution.binarySearch(arr, 3), "Target 3 should not be found");
    }

    @Test
    @DisplayName("Should handle array with only two elements (rotated)")
    void testTwoElementsRotated() {
        int[] arr = {2, 1}; // Rotated from [1,2]
        assertEquals(0, solution.binarySearch(arr, 2), "Target 2 should be at index 0");
        assertEquals(1, solution.binarySearch(arr, 1), "Target 1 should be at index 1");
        assertEquals(-1, solution.binarySearch(arr, 3), "Target 3 should not be found");
    }

    // --- Tests with Duplicates (More Complex Scenario) ---
    @Test
    @DisplayName("Should handle duplicates when target is found (case 1)")
    void testDuplicatesFoundCase1() {
        int[] arr = {3, 3, 1, 2, 3}; // Rotated with duplicates
        int target = 1;
        assertEquals(2, solution.binarySearch(arr, target), "Target 1 should be at index 2 (duplicates)");
    }

    @Test
    @DisplayName("Should handle duplicates when target is found (case 2)")
    void testDuplicatesFoundCase2() {
        int[] arr = {3, 1, 2, 3, 3, 3};
        int target = 2;
        assertEquals(2, solution.binarySearch(arr, target), "Target 2 should be at index 2 (duplicates)");
    }

    @Test
    @DisplayName("Should handle duplicates when target is found (case 3 - multiple targets)")
    void testDuplicatesFoundCase3() {
        int[] arr = {1, 1, 1, 1, 0, 1};
        int target = 0;
        assertEquals(4, solution.binarySearch(arr, target), "Target 0 should be at index 4 (duplicates)");
    }

    @Test
    @DisplayName("Should handle duplicates when target is found (case 4 - target is one of the duplicates)")
    void testDuplicatesFoundCase4() {
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 0, 1};
        int target = 1;
        // The algorithm returns any valid index of 1.
        assertTrue(solution.binarySearch(arr, target) != -1, "Target 1 should be found");
    }

    @Test
    @DisplayName("Should handle duplicates when target is not found")
    void testDuplicatesNotFound() {
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 0, 1};
        int target = 2;
        assertEquals(-1, solution.binarySearch(arr, target), "Target 2 should not be found (duplicates)");
    }

    @Test
    @DisplayName("Should handle array with all same elements - found")
    void testAllSameElementsFound() {
        int[] arr = {5, 5, 5, 5, 5};
        int target = 5;
        assertTrue(solution.binarySearch(arr, target) != -1, "Target 5 should be found in all same elements array");
    }

    @Test
    @DisplayName("Should handle array with all same elements - not found")
    void testAllSameElementsNotFound() {
        int[] arr = {5, 5, 5, 5, 5};
        int target = 10;
        assertEquals(-1, solution.binarySearch(arr, target), "Target 10 should not be found in all same elements array");
    }

}