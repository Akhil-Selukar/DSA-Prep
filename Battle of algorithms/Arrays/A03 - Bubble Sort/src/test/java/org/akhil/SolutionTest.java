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
    @DisplayName("Should sort a small array of positive integers")
    void testSmallPositiveArray() {
        int[] input = {5, 1, 4, 2, 8};
        int[] expected = {1, 2, 4, 5, 8};
        assertArrayEquals(expected, solution.bubbleSort(input), "Small positive array should be sorted correctly");
    }

    @Test
    @DisplayName("Should sort an array with negative integers")
    void testNegativeIntegersArray() {
        int[] input = {-5, -1, -4, -2, -8};
        int[] expected = {-8, -5, -4, -2, -1};
        assertArrayEquals(expected, solution.bubbleSort(input), "Array with negative integers should be sorted correctly");
    }

    @Test
    @DisplayName("Should sort an array with mixed positive and negative integers and zero")
    void testMixedIntegersArray() {
        int[] input = {0, -5, 3, -2, 1, 8};
        int[] expected = {-5, -2, 0, 1, 3, 8};
        assertArrayEquals(expected, solution.bubbleSort(input), "Array with mixed integers should be sorted correctly");
    }

    // --- Edge Cases ---

    @Test
    @DisplayName("Should handle an empty array")
    void testEmptyArray() {
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, solution.bubbleSort(input), "Empty array should remain empty");
    }

    @Test
    @DisplayName("Should handle a null array gracefully")
    void testNullArray() {
        int[] input = null;
        assertNull(solution.bubbleSort(input), "Null array should return null");
    }

    @Test
    @DisplayName("Should handle an array with a single element")
    void testSingleElementArray() {
        int[] input = {42};
        int[] expected = {42};
        assertArrayEquals(expected, solution.bubbleSort(input), "Single element array should remain unchanged");
    }

    @Test
    @DisplayName("Should handle an already sorted array")
    void testAlreadySortedArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, solution.bubbleSort(input), "Already sorted array should remain unchanged");
    }

    @Test
    @DisplayName("Should handle a reverse sorted array")
    void testReverseSortedArray() {
        int[] input = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, solution.bubbleSort(input), "Reverse sorted array should be sorted correctly");
    }

    @Test
    @DisplayName("Should handle an array with duplicate elements")
    void testArrayWithDuplicates() {
        int[] input = {5, 1, 4, 2, 8, 1, 5};
        int[] expected = {1, 1, 2, 4, 5, 5, 8};
        assertArrayEquals(expected, solution.bubbleSort(input), "Array with duplicates should be sorted correctly");
    }

    @Test
    @DisplayName("Should handle an array with all identical elements")
    void testAllIdenticalElements() {
        int[] input = {7, 7, 7, 7, 7};
        int[] expected = {7, 7, 7, 7, 7};
        assertArrayEquals(expected, solution.bubbleSort(input), "Array with all identical elements should remain unchanged");
    }

    // --- Performance/Larger Array (though Bubble Sort is slow) ---

    @Test
    @DisplayName("Should sort a moderately sized array")
    void testModeratelySizedArray() {
        int[] input = {99, 12, 5, 88, 34, 1, 67, 23, 78, 45, 6, 0, 100};
        int[] expected = {0, 1, 5, 6, 12, 23, 34, 45, 67, 78, 88, 99, 100};
        assertArrayEquals(expected, solution.bubbleSort(input), "Moderately sized array should be sorted correctly");
    }
}