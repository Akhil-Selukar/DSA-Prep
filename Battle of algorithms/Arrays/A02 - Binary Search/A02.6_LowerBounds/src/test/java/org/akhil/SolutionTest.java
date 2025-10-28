package org.akhil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();
    
    // =========================================================================
    // 1. Tests with Duplicates (Core Functionality)
    // =========================================================================
    @Test
    void test_targetWithDuplicates_internal() {
        // Lower bound for 5 is index 2 (the first occurrence of 5)
        int[] arr = {1, 3, 5, 5, 5, 7, 9};
        int target = 5;
        // Indices: 0, 1, 2, 3, 4, 5, 6
        // Values:  1, 3, 5, 5, 5, 7, 9
        // Expected: 2
        assertEquals(2, solution.lowerBounds(arr, target),
                "Lower bound for target 5 should be the index of the first 5 (index 2).");
    }

    @Test
    void test_targetWithDuplicates_firstElement() {
        // Lower bound for 1 is index 0 (the first occurrence of 1)
        int[] arr = {1, 1, 1, 5, 7, 9};
        int target = 1;
        // Indices: 0, 1, 2, 3, 4, 5
        // Values:  1, 1, 1, 5, 7, 9
        // Expected: 0
        assertEquals(0, solution.lowerBounds(arr, target),
                "Lower bound for target 1 should be the index 0.");
    }

    @Test
    void test_targetNotPresent_findsNextElement() {
        // Lower bound for 4 is index 2 (the first element >= 4, which is 5)
        int[] arr = {1, 3, 5, 5, 5, 7, 9};
        int target = 4;
        // Indices: 0, 1, 2, 3, 4, 5, 6
        // Values:  1, 3, 5, 5, 5, 7, 9
        // Expected: 2
        assertEquals(2, solution.lowerBounds(arr, target),
                "Lower bound for target 4 should be the index of the first 5 (index 2).");
    }

    // =========================================================================
    // 2. Boundary and Edge Cases
    // =========================================================================

    @Test
    void test_targetSmallerThanAllElements() {
        // Lower bound for 0 is index 0 (value 1)
        int[] arr = {1, 3, 5, 7, 9};
        int target = 0;
        // Expected: 0
        assertEquals(0, solution.lowerBounds(arr, target),
                "Target smaller than all elements should return index 0.");
    }

    @Test
    void test_targetLargerThanAllElements() {
        // Lower bound for 10 is index 5 (arr.length)
        int[] arr = {1, 3, 5, 7, 9};
        int target = 10;
        // Expected: 5
        assertEquals(5, solution.lowerBounds(arr, target),
                "Target larger than all elements should return arr.length (5).");
    }

    @Test
    void test_singleElementArray_greaterOrEqual() {
        // Lower bound for 5 is index 0
        int[] arr = {5};
        int target = 5;
        // Expected: 0
        assertEquals(0, solution.lowerBounds(arr, target),
                "Single element == target should return index 0.");
    }

    @Test
    void test_singleElementArray_lessThan() {
        // Lower bound for 6 is index 1 (arr.length)
        int[] arr = {5};
        int target = 6;
        // Expected: 1
        assertEquals(1, solution.lowerBounds(arr, target),
                "Single element < target should return arr.length (1).");
    }

    // =========================================================================
    // 3. Empty and Null Input
    // =========================================================================

    @Test
    void test_emptyArray() {
        // Lower bound for 5 in an empty array
        int[] arr = {};
        int target = 5;
        // Expected: 0
        assertEquals(0, solution.lowerBounds(arr, target),
                "Empty array should return 0.");
    }

    @Test
    void test_nullArray() {
        // Lower bound for 5 in a null array
        int[] arr = null;
        int target = 5;
        // Expected: 0
        assertEquals(0, solution.lowerBounds(arr, target),
                "Null array should return 0.");
    }
}