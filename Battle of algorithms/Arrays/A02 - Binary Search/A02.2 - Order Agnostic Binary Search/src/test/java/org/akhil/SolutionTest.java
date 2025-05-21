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

    // --- Ascending Order Tests ---

    @Test
    @DisplayName("Ascending: Should return correct index when target is present in the middle")
    void testAscendingTargetInMiddle() {
        int[] arr = {10, 20, 30, 40, 50, 60, 70};
        int target = 40;
        assertEquals(3, solution.binarySearch(arr, target), "Ascending: Target 40 should be at index 3");
    }

    @Test
    @DisplayName("Ascending: Should return correct index when target is the first element")
    void testAscendingTargetAtBeginning() {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 10;
        assertEquals(0, solution.binarySearch(arr, target), "Ascending: Target 10 should be at index 0");
    }

    @Test
    @DisplayName("Ascending: Should return correct index when target is the last element")
    void testAscendingTargetAtEnd() {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 50;
        assertEquals(4, solution.binarySearch(arr, target), "Ascending: Target 50 should be at index 4");
    }

    @Test
    @DisplayName("Ascending: Should return -1 when target is not present")
    void testAscendingTargetNotFound() {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 100;
        assertEquals(-1, solution.binarySearch(arr, target), "Ascending: Target 100 should not be found");
    }

    // --- Descending Order Tests ---

    @Test
    @DisplayName("Descending: Should return correct index when target is present in the middle")
    void testDescendingTargetInMiddle() {
        int[] arr = {70, 60, 50, 40, 30, 20, 10};
        int target = 40;
        assertEquals(3, solution.binarySearch(arr, target), "Descending: Target 40 should be at index 3");
    }

    @Test
    @DisplayName("Descending: Should return correct index when target is the first element")
    void testDescendingTargetAtBeginning() {
        int[] arr = {50, 40, 30, 20, 10};
        int target = 50;
        assertEquals(0, solution.binarySearch(arr, target), "Descending: Target 50 should be at index 0");
    }

    @Test
    @DisplayName("Descending: Should return correct index when target is the last element")
    void testDescendingTargetAtEnd() {
        int[] arr = {50, 40, 30, 20, 10};
        int target = 10;
        assertEquals(4, solution.binarySearch(arr, target), "Descending: Target 10 should be at index 4");
    }

    @Test
    @DisplayName("Descending: Should return -1 when target is not present")
    void testDescendingTargetNotFound() {
        int[] arr = {50, 40, 30, 20, 10};
        int target = 5;
        assertEquals(-1, solution.binarySearch(arr, target), "Descending: Target 5 should not be found");
    }

    // --- Common Edge Cases for Both Orders ---

    @Test
    @DisplayName("Should return -1 for an empty array")
    void testEmptyArray() {
        int[] arr = {};
        int target = 5;
        assertEquals(-1, solution.binarySearch(arr, target), "Should return -1 for an empty array");
    }

    @Test
    @DisplayName("Should handle an array with a single element (Ascending) - target found")
    void testSingleElementArrayAscendingFound() {
        int[] arr = {5};
        int target = 5;
        assertEquals(0, solution.binarySearch(arr, target), "Single element (Asc): Target 5 should be at index 0");
    }

    @Test
    @DisplayName("Should handle an array with a single element (Ascending) - target not found")
    void testSingleElementArrayAscendingNotFound() {
        int[] arr = {5};
        int target = 10;
        assertEquals(-1, solution.binarySearch(arr, target), "Single element (Asc): Target 10 should not be found");
    }

    @Test
    @DisplayName("Should handle an array with a single element (Descending) - target found")
    void testSingleElementArrayDescendingFound() {
        int[] arr = {5}; // A single element array is both ascending and descending
        int target = 5;
        assertEquals(0, solution.binarySearch(arr, target), "Single element (Desc): Target 5 should be at index 0");
    }

    @Test
    @DisplayName("Should handle an array with a single element (Descending) - target not found")
    void testSingleElementArrayDescendingNotFound() {
        int[] arr = {5}; // A single element array is both ascending and descending
        int target = 10;
        assertEquals(-1, solution.binarySearch(arr, target), "Single element (Desc): Target 10 should not be found");
    }


    @Test
    @DisplayName("Should handle duplicate elements (Ascending) - return index of one occurrence")
    void testAscendingDuplicateElements() {
        int[] arr = {10, 20, 20, 30, 40, 50};
        int target = 20;
        int result = solution.binarySearch(arr, target);
        assertTrue(result == 1 || result == 2, "Ascending: Should return either index 1 or 2 for target 20");
    }

    @Test
    @DisplayName("Should handle duplicate elements (Descending) - return index of one occurrence")
    void testDescendingDuplicateElements() {
        int[] arr = {50, 40, 30, 30, 20, 10};
        int target = 30;
        int result = solution.binarySearch(arr, target);
        assertTrue(result == 2 || result == 3, "Descending: Should return either index 2 or 3 for target 30");
    }

    @Test
    @DisplayName("Should handle negative numbers in the array (Ascending)")
    void testAscendingNegativeNumbers() {
        int[] arr = {-10, -5, 0, 5, 10};
        int target = -5;
        assertEquals(1, solution.binarySearch(arr, target), "Ascending: Target -5 should be at index 1");
    }

    @Test
    @DisplayName("Should handle negative numbers in the array (Descending)")
    void testDescendingNegativeNumbers() {
        int[] arr = {10, 5, 0, -5, -10};
        int target = -5;
        assertEquals(3, solution.binarySearch(arr, target), "Descending: Target -5 should be at index 3");
    }

    @Test
    @DisplayName("Should handle zero as target (Ascending)")
    void testAscendingZeroTarget() {
        int[] arr = {-5, -1, 0, 1, 5};
        int target = 0;
        assertEquals(2, solution.binarySearch(arr, target), "Ascending: Target 0 should be at index 2");
    }

    @Test
    @DisplayName("Should handle zero as target (Descending)")
    void testDescendingZeroTarget() {
        int[] arr = {5, 1, 0, -1, -5};
        int target = 0;
        assertEquals(2, solution.binarySearch(arr, target), "Descending: Target 0 should be at index 2");
    }

    @Test
    @DisplayName("Should handle null array gracefully")
    void testNullArray() {
        int[] arr = null;
        int target = 10;
        assertEquals(-1, solution.binarySearch(arr, target), "Should return -1 for a null array");
    }

}