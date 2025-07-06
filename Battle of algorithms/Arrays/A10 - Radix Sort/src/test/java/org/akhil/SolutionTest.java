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
    private static final int MAX_RANDOM_VALUE = 99999; // Max 5 digits for general test

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Test sorting an empty integer array")
    void testSortEmptyIntArray() throws IllegalArgumentException {
        int[] arr = {};
        solution.radixSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    @DisplayName("Test sorting a single-element integer array")
    void testSortSingleElementIntArray() throws IllegalArgumentException {
        int[] arr = {5};
        solution.radixSort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    @DisplayName("Test sorting an already sorted integer array")
    void testSortAlreadySortedIntArray() throws IllegalArgumentException {
        int[] arr = {1, 2, 3, 4, 5};
        solution.radixSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    @DisplayName("Test sorting a reverse sorted integer array")
    void testSortReverseSortedIntArray() throws IllegalArgumentException {
        int[] arr = {5, 4, 3, 2, 1};
        solution.radixSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    @DisplayName("Test sorting an integer array with duplicate elements")
    void testSortIntArrayWithDuplicates() throws IllegalArgumentException {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        solution.radixSort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 5, 5, 6, 9}, arr);
    }

    @Test
    @DisplayName("Test sorting an integer array with mixed number of digits")
    void testSortMixedDigitNumbers() throws IllegalArgumentException {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        solution.radixSort(arr);
        assertArrayEquals(new int[]{2, 24, 45, 66, 75, 90, 170, 802}, arr);
    }

    @Test
    @DisplayName("Test sorting an integer array with all zeros")
    void testSortAllZerosIntArray() throws IllegalArgumentException {
        int[] arr = {0, 0, 0, 0, 0};
        solution.radixSort(arr);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, arr);
    }

    @Test
    @DisplayName("Test sorting an integer array with numbers having leading zeros (conceptually)")
    void testSortNumbersWithSameLength() throws IllegalArgumentException {
        int[] arr = {329, 457, 657, 839, 436, 720, 355};
        solution.radixSort(arr);
        assertArrayEquals(new int[]{329, 355, 436, 457, 657, 720, 839}, arr);
    }

    @Test
    @DisplayName("Test sorting a large random integer array within max value limits")
    void testSortLargeRandomIntArray() throws IllegalArgumentException {
        int[] arr = new int[LARGE_ARRAY_SIZE];
        Random rand = new Random();
        for (int i = 0; i < LARGE_ARRAY_SIZE; i++) {
            arr[i] = rand.nextInt(MAX_RANDOM_VALUE + 1); // Values from 0 to MAX_RANDOM_VALUE
        }

        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected); // Use Java's built-in sort for comparison

        solution.radixSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    @DisplayName("Test sorting a large random integer array with many duplicates")
    void testSortLargeArrayWithManyDuplicates() throws IllegalArgumentException {
        int[] arr = new int[LARGE_ARRAY_SIZE];
        Random rand = new Random();
        for (int i = 0; i < LARGE_ARRAY_SIZE; i++) {
            arr[i] = rand.nextInt(10); // Limited range (0-9) to create many duplicates
        }

        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        solution.radixSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    @DisplayName("Test sorting a null integer array (should handle gracefully)")
    void testSortNullIntArray() {
        int[] arr = null;
        assertDoesNotThrow(() -> solution.radixSort(arr)); // Assert that no exception is thrown
    }

    // --- Tests for Radix Sort limitations/assumptions ---

    @Test
    @DisplayName("Test array with negative numbers (expect IllegalArgumentException)")
    void testSortIntArrayWithNegatives() {
        int[] arr = {-5, 0, -2, 8, 1};
        assertThrows(IllegalArgumentException.class, () -> solution.radixSort(arr),
                "Radix Sort implementation should throw IllegalArgumentException for negative numbers.");
    }

}