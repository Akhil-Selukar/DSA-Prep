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

    @Test
    @DisplayName("Should return correct index when target is present in the middle")
    void testTargetInMiddle() {
        int[] arr = {10, 20, 30, 40, 50, 60, 70};
        int target = 40;
        assertEquals(3, solution.binarySearch(arr, target), "Target 40 should be at index 3");
    }

    @Test
    @DisplayName("Should return correct index when target is the first element")
    void testTargetAtBeginning() {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 10;
        assertEquals(0, solution.binarySearch(arr, target), "Target 10 should be at index 0");
    }

    @Test
    @DisplayName("Should return correct index when target is the last element")
    void testTargetAtEnd() {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 50;
        assertEquals(4, solution.binarySearch(arr, target), "Target 50 should be at index 4");
    }

    @Test
    @DisplayName("Should return -1 when target is not present in the array")
    void testTargetNotFound() {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 100;
        assertEquals(-1, solution.binarySearch(arr, target), "Target 100 should not be found");
    }

    @Test
    @DisplayName("Should return -1 for an empty array")
    void testEmptyArray() {
        int[] arr = {};
        int target = 5;
        assertEquals(-1, solution.binarySearch(arr, target), "Should return -1 for an empty array");
    }

    @Test
    @DisplayName("Should handle an array with a single element - target found")
    void testSingleElementArrayFound() {
        int[] arr = {5};
        int target = 5;
        assertEquals(0, solution.binarySearch(arr, target), "Target 5 should be at index 0 in single element array");
    }

    @Test
    @DisplayName("Should handle an array with a single element - target not found")
    void testSingleElementArrayNotFound() {
        int[] arr = {5};
        int target = 10;
        assertEquals(-1, solution.binarySearch(arr, target), "Target 10 should not be found in single element array");
    }

    @Test
    @DisplayName("Should handle duplicate elements - return index of one occurrence (not necessarily first or last)")
    void testDuplicateElements() {
        int[] arr = {10, 20, 20, 30, 40, 50};
        int target = 20;
        // Binary search might return any valid index for duplicates.
        // So, we just check if it's either 1 or 2.
        int result = solution.binarySearch(arr, target);
        assertTrue(result == 1 || result == 2, "Should return either index 1 or 2 for target 20");
    }

    @Test
    @DisplayName("Should handle negative numbers in the array")
    void testNegativeNumbers() {
        int[] arr = {-10, -5, 0, 5, 10};
        int target = -5;
        assertEquals(1, solution.binarySearch(arr, target), "Target -5 should be at index 1");
    }

    @Test
    @DisplayName("Should handle zero as target")
    void testZeroTarget() {
        int[] arr = {-5, -1, 0, 1, 5};
        int target = 0;
        assertEquals(2, solution.binarySearch(arr, target), "Target 0 should be at index 2");
    }

    @Test
    @DisplayName("Should handle array with even number of elements")
    void testEvenLengthArray() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        assertEquals(2, solution.binarySearch(arr, 3), "Target 3 should be at index 2");
        assertEquals(5, solution.binarySearch(arr, 6), "Target 6 should be at index 5");
        assertEquals(-1, solution.binarySearch(arr, 7), "Target 7 should not be found");
    }

    @Test
    @DisplayName("Should handle array with odd number of elements")
    void testOddLengthArray() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(2, solution.binarySearch(arr, 3), "Target 3 should be at index 2");
        assertEquals(4, solution.binarySearch(arr, 5), "Target 5 should be at index 4");
        assertEquals(-1, solution.binarySearch(arr, 6), "Target 6 should not be found");
    }

    @Test
    @DisplayName("Should handle null array gracefully")
    void testNullArray() {
        int[] arr = null;
        int target = 10;
        assertEquals(-1, solution.binarySearch(arr, target), "Should return -1 for a null array");
    }

}