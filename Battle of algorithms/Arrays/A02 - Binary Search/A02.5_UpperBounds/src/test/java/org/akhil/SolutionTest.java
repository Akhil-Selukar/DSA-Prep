package org.akhil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test_targetWithDuplicates_internal() {
        // Upper bound for 5 is index 6 (value 7)
        int[] arr = {1, 3, 5, 5, 5, 5, 7, 9};
        int target = 5;
        // Indices: 0, 1, 2, 3, 4, 5, 6, 7
        // Values:  1, 3, 5, 5, 5, 5, 7, 9
        // Expected: 6
        assertEquals(6, solution.upperBounds(arr, target),
                "Upper bound for target 5 should be the index of the first 7 (index 6).");
    }

    @Test
    void test_targetWithDuplicates_firstElement() {
        // Upper bound for 1 is index 3 (value 5)
        int[] arr = {1, 1, 1, 5, 7, 9};
        int target = 1;
        // Indices: 0, 1, 2, 3, 4, 5
        // Values:  1, 1, 1, 5, 7, 9
        // Expected: 3
        assertEquals(3, solution.upperBounds(arr, target),
                "Upper bound for target 1 should be the index of the first 5 (index 3).");
    }

    @Test
    void test_targetNotPresent_betweenElements() {
        // Upper bound for 4 is index 6 (value 7)
        int[] arr = {1, 3, 5, 5, 5, 6, 7, 9};
        int target = 4;
        // Indices: 0, 1, 2, 3, 4, 5, 6, 7
        // Values:  1, 3, 5, 5, 5, 6, 7, 9
        // Expected: 2 (Index of the first 5)
        assertEquals(2, solution.upperBounds(arr, target),
                "Upper bound for target 4 should be the index of the first 5 (index 2).");
    }

    // =========================================================================
    // 2. Boundary and Edge Cases
    // =========================================================================

    @Test
    void test_targetSmallerThanAllElements() {
        // Upper bound for 0 is index 0 (value 1)
        int[] arr = {1, 3, 5, 7, 9};
        int target = 0;
        // Expected: 0
        assertEquals(0, solution.upperBounds(arr, target),
                "Target smaller than all elements should return index 0.");
    }

    @Test
    void test_targetLargerThanAllElements() {
        // Upper bound for 10 is index 5 (arr.length)
        int[] arr = {1, 3, 5, 7, 9};
        int target = 10;
        // Expected: 5
        assertEquals(5, solution.upperBounds(arr, target),
                "Target larger than all elements should return arr.length (5).");
    }

    @Test
    void test_singleElementArray_greater() {
        // Upper bound for 4 is index 0 (value 5)
        int[] arr = {5};
        int target = 4;
        // Expected: 0
        assertEquals(0, solution.upperBounds(arr, target),
                "Single element > target should return index 0.");
    }

    @Test
    void test_singleElementArray_equal() {
        // Upper bound for 5 is index 1 (arr.length)
        int[] arr = {5};
        int target = 5;
        // Expected: 1
        assertEquals(1, solution.upperBounds(arr, target),
                "Single element == target should return arr.length (1).");
    }

    @Test
    void test_singleElementArray_less() {
        // Upper bound for 6 is index 1 (arr.length)
        int[] arr = {5};
        int target = 6;
        // Expected: 1
        assertEquals(1, solution.upperBounds(arr, target),
                "Single element < target should return arr.length (1).");
    }

    // =========================================================================
    // 3. Empty and Null Input
    // =========================================================================

    @Test
    void test_emptyArray() {
        // Upper bound for 5 in an empty array
        int[] arr = {};
        int target = 5;
        // Expected: 0
        assertEquals(0, solution.upperBounds(arr, target),
                "Empty array should return 0.");
    }

    @Test
    void test_nullArray() {
        // Upper bound for 5 in a null array
        int[] arr = null;
        int target = 5;
        // Expected: 0
        assertEquals(0, solution.upperBounds(arr, target),
                "Null array should return 0.");
    }
}