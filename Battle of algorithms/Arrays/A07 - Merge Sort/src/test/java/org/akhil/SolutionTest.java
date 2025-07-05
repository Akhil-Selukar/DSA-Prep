package org.akhil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution;
    private static final int LARGE_ARRAY_SIZE = 10000;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Test sorting an empty integer array")
    void testSortEmptyIntArray() {
        int[] arr = {};
        solution.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    @DisplayName("Test sorting a single-element integer array")
    void testSortSingleElementIntArray() {
        int[] arr = {5};
        solution.sort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    @DisplayName("Test sorting an already sorted integer array")
    void testSortAlreadySortedIntArray() {
        int[] arr = {1, 2, 3, 4, 5};
        solution.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    @DisplayName("Test sorting a reverse sorted integer array")
    void testSortReverseSortedIntArray() {
        int[] arr = {5, 4, 3, 2, 1};
        solution.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    @DisplayName("Test sorting an integer array with duplicate elements")
    void testSortIntArrayWithDuplicates() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        solution.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 5, 5, 6, 9}, arr);
    }

    @Test
    @DisplayName("Test sorting an integer array with negative numbers")
    void testSortIntArrayWithNegatives() {
        int[] arr = {-5, 0, -2, 8, 1};
        solution.sort(arr);
        assertArrayEquals(new int[]{-5, -2, 0, 1, 8}, arr);
    }

    @Test
    @DisplayName("Test sorting a mixed integer array (positive, negative, zero)")
    void testSortMixedIntArray() {
        int[] arr = {7, -3, 0, 10, -1, 5};
        solution.sort(arr);
        assertArrayEquals(new int[]{-3, -1, 0, 5, 7, 10}, arr);
    }

    @Test
    @DisplayName("Test sorting an integer array with odd number of elements")
    void testSortOddLengthIntArray() {
        int[] arr = {5, 2, 8, 1, 9};
        solution.sort(arr);
        assertArrayEquals(new int[]{1, 2, 5, 8, 9}, arr);
    }

    @Test
    @DisplayName("Test sorting an integer array with even number of elements")
    void testSortEvenLengthIntArray() {
        int[] arr = {6, 2, 8, 1, 9, 3};
        solution.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 6, 8, 9}, arr);
    }

    @Test
    @DisplayName("Test sorting an array where all elements are the same")
    void testSortAllSameElements() {
        int[] arr = {7, 7, 7, 7, 7};
        solution.sort(arr);
        assertArrayEquals(new int[]{7, 7, 7, 7, 7}, arr);
    }

    @Test
    @DisplayName("Test sorting a large random integer array for performance and correctness")
    void testSortLargeRandomIntArray() {
        int[] arr = new int[LARGE_ARRAY_SIZE];
        Random rand = new Random();
        for (int i = 0; i < LARGE_ARRAY_SIZE; i++) {
            arr[i] = rand.nextInt(LARGE_ARRAY_SIZE * 2) - LARGE_ARRAY_SIZE; // Values from -LARGE_ARRAY_SIZE to LARGE_ARRAY_SIZE-1
        }

        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected); // Use Java's built-in sort for comparison

        solution.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    @DisplayName("Test sorting a null integer array (should handle gracefully)")
    void testSortNullIntArray() {
        int[] arr = null;
        assertDoesNotThrow(() -> solution.sort(arr)); // Assert that no exception is thrown
    }
}