package org.akhil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Test sorting an empty integer array")
    void testSortEmptyIntArray() {
        int[] arr = {};
        solution.insertionSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    @DisplayName("Test sorting a single-element integer array")
    void testSortSingleElementIntArray() {
        int[] arr = {5};
        solution.insertionSort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    @DisplayName("Test sorting an already sorted integer array")
    void testSortAlreadySortedIntArray() {
        int[] arr = {1, 2, 3, 4, 5};
        solution.insertionSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    @DisplayName("Test sorting a reverse sorted integer array")
    void testSortReverseSortedIntArray() {
        int[] arr = {5, 4, 3, 2, 1};
        solution.insertionSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    @DisplayName("Test sorting an integer array with duplicate elements")
    void testSortIntArrayWithDuplicates() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        solution.insertionSort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 5, 5, 6, 9}, arr);
    }

    @Test
    @DisplayName("Test sorting an integer array with negative numbers")
    void testSortIntArrayWithNegatives() {
        int[] arr = {-5, 0, -2, 8, 1};
        solution.insertionSort(arr);
        assertArrayEquals(new int[]{-5, -2, 0, 1, 8}, arr);
    }

    @Test
    @DisplayName("Test sorting a mixed integer array (positive, negative, zero)")
    void testSortMixedIntArray() {
        int[] arr = {7, -3, 0, 10, -1, 5};
        solution.insertionSort(arr);
        assertArrayEquals(new int[]{-3, -1, 0, 5, 7, 10}, arr);
    }

    @Test
    @DisplayName("Test sorting a large random integer array")
    void testSortLargeRandomIntArray() {
        int[] arr = {48, 93, 22, 11, 76, 5, 89, 34, 60, 2, 7, 55, 99, 18, 42, 70, 3, 81, 27, 65};
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected); // Use Java's built-in sort for comparison

        solution.insertionSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    @DisplayName("Test sorting an integer array with all zeros")
    void testSortAllZerosIntArray() {
        int[] arr = {0, 0, 0, 0, 0};
        solution.insertionSort(arr);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, arr);
    }

    @Test
    @DisplayName("Test sorting a null integer array (should handle gracefully and not throw exception)")
    void testSortNullIntArray() {
        int[] arr = null;
        assertDoesNotThrow(() -> solution.insertionSort(arr)); // Assert that no exception is thrown
    }
}