package org.akhil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Should return correct index when target is present in the middle")
    void testTargetInMiddle() {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 30;
        assertEquals(2, solution.linearSearch(arr, target), "Target 30 should be at index 2");
    }

    @Test
    @DisplayName("Should return correct index when target is the first element")
    void testTargetAtBeginning() {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 10;
        assertEquals(0, solution.linearSearch(arr, target), "Target 10 should be at index 0");
    }

    @Test
    @DisplayName("Should return correct index when target is the last element")
    void testTargetAtEnd() {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 50;
        assertEquals(4, solution.linearSearch(arr, target), "Target 50 should be at index 4");
    }

    @Test
    @DisplayName("Should return -1 when target is not present in the array")
    void testTargetNotFound() {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 100;
        assertEquals(-1, solution.linearSearch(arr, target), "Target 100 should not be found");
    }

    @Test
    @DisplayName("Should return -1 for an empty array")
    void testEmptyArray() {
        int[] arr = {};
        int target = 5;
        assertEquals(-1, solution.linearSearch(arr, target), "Should return -1 for an empty array");
    }

    @Test
    @DisplayName("Should handle an array with a single element - target found")
    void testSingleElementArrayFound() {
        int[] arr = {5};
        int target = 5;
        assertEquals(0, solution.linearSearch(arr, target), "Target 5 should be at index 0 in single element array");
    }

    @Test
    @DisplayName("Should handle an array with a single element - target not found")
    void testSingleElementArrayNotFound() {
        int[] arr = {5};
        int target = 10;
        assertEquals(-1, solution.linearSearch(arr, target), "Target 10 should not be found in single element array");
    }

    @Test
    @DisplayName("Should handle duplicate elements - return first occurrence")
    void testDuplicateElements() {
        int[] arr = {10, 20, 30, 20, 50};
        int target = 20;
        assertEquals(1, solution.linearSearch(arr, target), "Should return the index of the first occurrence (index 1)");
    }

    @Test
    @DisplayName("Should handle negative numbers in the array")
    void testNegativeNumbers() {
        int[] arr = {-10, 0, -5, 20};
        int target = -5;
        assertEquals(2, solution.linearSearch(arr, target), "Target -5 should be at index 2");
    }

    @Test
    @DisplayName("Should handle zero as target")
    void testZeroTarget() {
        int[] arr = {1, 5, 0, 9};
        int target = 0;
        assertEquals(2, solution.linearSearch(arr, target), "Target 0 should be at index 2");
    }

    @Test
    @DisplayName("Should handle null array gracefully")
    void testNullArray() {
        int[] arr = null;
        int target = 10;
        assertEquals(-1, solution.linearSearch(arr, target), "Should return -1 for a null array");
    }
}