package org.akhil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;
    // Define a reasonable maximum range for counting sort tests
    // A very large range (e.g., 10^9) would cause OutOfMemoryError for the count array
    private static final int TEST_MAX_VALUE = 1000;
    private static final int TEST_MIN_VALUE = -500;
    private static final int TEST_RANGE_SIZE = TEST_MAX_VALUE - TEST_MIN_VALUE + 1;


    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Test sorting an empty integer array")
    void testSortEmptyIntArray() {
        int[] arr = {};
        solution.countSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    @DisplayName("Test sorting a single-element integer array")
    void testSortSingleElementIntArray() {
        int[] arr = {5};
        solution.countSort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    @DisplayName("Test sorting an already sorted integer array")
    void testSortAlreadySortedIntArray() {
        int[] arr = {1, 2, 3, 4, 5};
        solution.countSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    @DisplayName("Test sorting a reverse sorted integer array")
    void testSortReverseSortedIntArray() {
        int[] arr = {5, 4, 3, 2, 1};
        solution.countSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    @DisplayName("Test sorting an integer array with duplicate elements")
    void testSortIntArrayWithDuplicates() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        solution.countSort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 5, 5, 6, 9}, arr);
    }

    @Test
    @DisplayName("Test sorting an integer array with all zeros")
    void testSortAllZerosIntArray() {
        int[] arr = {0, 0, 0, 0, 0};
        solution.countSort(arr);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, arr);
    }


    @Test
    @DisplayName("Test sorting a large array with numbers from a small range")
    void testSortLargeArrayWithSmallRange() {
        int arraySize = 100000;
        int[] arr = new int[arraySize];
        Random rand = new Random();
        for (int i = 0; i < arraySize; i++) {
            arr[i] = rand.nextInt(10); // Numbers between 0 and 9
        }

        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        solution.countSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    @DisplayName("Test sorting a null integer array (should handle gracefully)")
    void testSortNullIntArray() {
        int[] arr = null;
        assertDoesNotThrow(() -> solution.countSort(arr)); // Assert that no exception is thrown
    }

}