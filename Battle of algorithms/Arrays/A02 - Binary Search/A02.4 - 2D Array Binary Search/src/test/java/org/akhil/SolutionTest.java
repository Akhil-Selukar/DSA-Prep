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

    // --- Target Found Scenarios ---

    @Test
    @DisplayName("Should find target in the middle of the matrix and return its coordinates")
    void testTargetInMiddle() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 11;
        assertArrayEquals(new int[]{1, 1}, solution.binarySearch(matrix, target), "Target 11 should be at [1, 1]");
    }

    @Test
    @DisplayName("Should find target at the top-left corner and return its coordinates")
    void testTargetAtTopLeft() {
        int[][] matrix = {
                {1, 3, 5},
                {10, 11, 12}
        };
        int target = 1;
        assertArrayEquals(new int[]{0, 0}, solution.binarySearch(matrix, target), "Target 1 should be at [0, 0]");
    }

    @Test
    @DisplayName("Should find target at the top-right corner and return its coordinates")
    void testTargetAtTopRight() {
        int[][] matrix = {
                {1, 3, 5},
                {10, 11, 12}
        };
        int target = 5;
        assertArrayEquals(new int[]{0, 2}, solution.binarySearch(matrix, target), "Target 5 should be at [0, 2]");
    }

    @Test
    @DisplayName("Should find target at the bottom-left corner and return its coordinates")
    void testTargetAtBottomLeft() {
        int[][] matrix = {
                {1, 3, 5},
                {10, 11, 12}
        };
        int target = 10;
        assertArrayEquals(new int[]{1, 0}, solution.binarySearch(matrix, target), "Target 10 should be at [1, 0]");
    }

    @Test
    @DisplayName("Should find target at the bottom-right corner and return its coordinates")
    void testTargetAtBottomRight() {
        int[][] matrix = {
                {1, 3, 5},
                {10, 11, 12}
        };
        int target = 12;
        assertArrayEquals(new int[]{1, 2}, solution.binarySearch(matrix, target), "Target 12 should be at [1, 2]");
    }

    @Test
    @DisplayName("Should find target in the first row and return its coordinates")
    void testTargetInFirstRow() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 7;
        assertArrayEquals(new int[]{0, 3}, solution.binarySearch(matrix, target), "Target 7 should be at [0, 3]");
    }

    @Test
    @DisplayName("Should find target in the last row and return its coordinates")
    void testTargetInLastRow() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 34;
        assertArrayEquals(new int[]{2, 2}, solution.binarySearch(matrix, target), "Target 34 should be at [2, 2]");
    }

    // --- Target Not Found Scenarios ---

    @Test
    @DisplayName("Should not find target smaller than all elements and return [-1, -1]")
    void testTargetTooSmall() {
        int[][] matrix = {
                {1, 3, 5},
                {10, 11, 12}
        };
        int target = 0;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Target 0 should not be found");
    }

    @Test
    @DisplayName("Should not find target larger than all elements and return [-1, -1]")
    void testTargetTooLarge() {
        int[][] matrix = {
                {1, 3, 5},
                {10, 11, 12}
        };
        int target = 100;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Target 100 should not be found");
    }

    @Test
    @DisplayName("Should not find target that doesn't exist within range and return [-1, -1]")
    void testTargetDoesNotExist() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 15;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Target 15 should not be found");
    }

    // --- Edge Case Matrices ---

    @Test
    @DisplayName("Should handle 1x1 matrix - target found, return coordinates")
    void testOneByOneMatrixFound() {
        int[][] matrix = {{5}};
        int target = 5;
        assertArrayEquals(new int[]{0, 0}, solution.binarySearch(matrix, target), "Target 5 should be at [0, 0] in 1x1 matrix");
    }

    @Test
    @DisplayName("Should handle 1x1 matrix - target not found, return [-1, -1]")
    void testOneByOneMatrixNotFound() {
        int[][] matrix = {{5}};
        int target = 10;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Target 10 should not be found in 1x1 matrix");
    }

    @Test
    @DisplayName("Should handle matrix with a single row - target found, return coordinates")
    void testSingleRowMatrixFound() {
        int[][] matrix = {{10, 20, 30, 40, 50}};
        int target = 30;
        assertArrayEquals(new int[]{0, 2}, solution.binarySearch(matrix, target), "Target 30 should be at [0, 2] in single row matrix");
    }

    @Test
    @DisplayName("Should handle matrix with a single row - target not found, return [-1, -1]")
    void testSingleRowMatrixNotFound() {
        int[][] matrix = {{10, 20, 30, 40, 50}};
        int target = 25;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Target 25 should not be found in single row matrix");
    }

    @Test
    @DisplayName("Should handle matrix with a single column - target found, return coordinates")
    void testSingleColumnMatrixFound() {
        int[][] matrix = {{10}, {20}, {30}, {40}};
        int target = 30;
        assertArrayEquals(new int[]{2, 0}, solution.binarySearch(matrix, target), "Target 30 should be at [2, 0] in single column matrix");
    }

    @Test
    @DisplayName("Should handle matrix with a single column - target not found, return [-1, -1]")
    void testSingleColumnMatrixNotFound() {
        int[][] matrix = {{10}, {20}, {30}, {40}};
        int target = 25;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Target 25 should not be found in single column matrix");
    }

    @Test
    @DisplayName("Should handle empty matrix (0 rows) and return [-1, -1]")
    void testEmptyMatrixZeroRows() {
        int[][] matrix = {};
        int target = 5;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Should return [-1, -1] for a matrix with 0 rows");
    }

    @Test
    @DisplayName("Should handle empty matrix (0 columns) and return [-1, -1]")
    void testEmptyMatrixZeroColumns() {
        int[][] matrix = {{}, {}}; // Matrix with 2 rows but 0 columns
        int target = 5;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Should return [-1, -1] for a matrix with 0 columns");
    }

    @Test
    @DisplayName("Should handle null matrix and return [-1, -1]")
    void testNullMatrix() {
        int[][] matrix = null;
        int target = 10;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Should return [-1, -1] for a null matrix");
    }

    // --- Tests with Negative Numbers and Zeros ---

    @Test
    @DisplayName("Should handle negative numbers and zero - target found, return coordinates")
    void testMatrixWithNegativeAndZeroFound() {
        int[][] matrix = {
                {-5, -2, 0},
                {1, 3, 7},
                {10, 15, 20}
        };
        int target = 0;
        assertArrayEquals(new int[]{0, 2}, solution.binarySearch(matrix, target), "Target 0 should be at [0, 2] with negative numbers");
    }

    @Test
    @DisplayName("Should handle negative numbers and zero - target not found, return [-1, -1]")
    void testMatrixWithNegativeAndZeroNotFound() {
        int[][] matrix = {
                {-5, -2, 0},
                {1, 3, 7},
                {10, 15, 20}
        };
        int target = -3;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Target -3 should not be found with negative numbers");
    }

    // --- Tests with Duplicates ---

    @Test
    @DisplayName("Should find target when duplicates are present, return coordinates")
    void testMatrixWithDuplicatesFound() {
        int[][] matrix = {
                {1, 1, 3},
                {5, 5, 7},
                {9, 9, 11}
        };
        int target = 5;
        // Binary search might find either [1,0] or [1,1]. Both are valid.
        int[] result = solution.binarySearch(matrix, target);
        assertTrue((result[0] == 1 && result[1] == 0) || (result[0] == 1 && result[1] == 1),
                "Target 5 should be found at either [1,0] or [1,1] with duplicates");
    }

    @Test
    @DisplayName("Should not find target when duplicates are present but target is absent, return [-1, -1]")
    void testMatrixWithDuplicatesNotFound() {
        int[][] matrix = {
                {1, 1, 3},
                {5, 5, 7},
                {9, 9, 11}
        };
        int target = 6;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Target 6 should not be found with duplicates");
    }
    
    
    //--------------------------------

    @Test
    @DisplayName("Should find target in a matrix where rows are sorted but not globally (middle)")
    void testTargetInMiddleOfUnconstrainedMatrix() {
        int[][] matrix = {
                {1, 5, 8, 12},
                {2, 6, 9, 13}, // Note: 2 < 12 (previous row's last)
                {3, 7, 10, 14},
                {4, 11, 15, 16}
        };
        int target = 9;
        assertArrayEquals(new int[]{1, 2}, solution.binarySearch(matrix, target), "Target 9 should be at [1, 2]");
    }

    @Test
    @DisplayName("Should find target in a matrix with typical structure (middle)")
    void testTargetInMiddleOfStandardMatrix() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 11;
        assertArrayEquals(new int[]{1, 1}, solution.binarySearch(matrix, target), "Target 11 should be at [1, 1]");
    }

    @Test
    @DisplayName("Should find target at top-left corner")
    void testTargetAtTopLeft_1() {
        int[][] matrix = {{1, 2}, {0, 3}};
        int target = 1;
        assertArrayEquals(new int[]{0, 0}, solution.binarySearch(matrix, target), "Target 1 should be at [0, 0]");
    }

    @Test
    @DisplayName("Should find target at bottom-right corner")
    void testTargetAtBottomRight_1() {
        int[][] matrix = {{1, 2}, {0, 3}};
        int target = 3;
        assertArrayEquals(new int[]{1, 1}, solution.binarySearch(matrix, target), "Target 3 should be at [1, 1]");
    }

    @Test
    @DisplayName("Should find target at the end of a row")
    void testTargetAtEndOfRow() {
        int[][] matrix = {
                {1, 2, 3},
                {10, 11, 12},
                {20, 21, 22}
        };
        int target = 22;
        assertArrayEquals(new int[]{2, 2}, solution.binarySearch(matrix, target), "Target 22 should be at [2, 2]");
    }

    @Test
    @DisplayName("Should find target at the beginning of a row")
    void testTargetAtBeginningOfRow() {
        int[][] matrix = {
                {1, 2, 3},
                {10, 11, 12},
                {20, 21, 22}
        };
        int target = 10;
        assertArrayEquals(new int[]{1, 0}, solution.binarySearch(matrix, target), "Target 10 should be at [1, 0]");
    }

    // --- Target Not Found Scenarios ---

    @Test
    @DisplayName("Should not find target smaller than any element")
    void testTargetTooSmall_1() {
        int[][] matrix = {
                {5, 10},
                {1, 2} // Note: 1 < 10 (previous row's last)
        };
        int target = 0;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Target 0 should not be found (too small)");
    }

    @Test
    @DisplayName("Should not find target larger than any element")
    void testTargetTooLarge_1() {
        int[][] matrix = {
                {5, 10},
                {1, 2}
        };
        int target = 11;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Target 11 should not be found (too large)");
    }

    @Test
    @DisplayName("Should not find target that doesn't exist within range")
    void testTargetDoesNotExist_1() {
        int[][] matrix = {
                {1, 5, 8},
                {2, 6, 9},
                {3, 7, 10}
        };
        int target = 4; // 4 is between rows, but not in any row
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Target 4 should not be found");
    }

    // --- Edge Case Matrices ---

    @Test
    @DisplayName("Should handle 1x1 matrix - target found")
    void testOneByOneMatrixFound_1() {
        int[][] matrix = {{5}};
        int target = 5;
        assertArrayEquals(new int[]{0, 0}, solution.binarySearch(matrix, target), "Target 5 should be at [0, 0] in 1x1 matrix");
    }

    @Test
    @DisplayName("Should handle 1x1 matrix - target not found")
    void testOneByOneMatrixNotFound_1() {
        int[][] matrix = {{5}};
        int target = 10;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Target 10 should not be found in 1x1 matrix");
    }

    @Test
    @DisplayName("Should handle matrix with a single row - target found")
    void testSingleRowMatrixFound_1() {
        int[][] matrix = {{10, 20, 30, 40, 50}};
        int target = 30;
        assertArrayEquals(new int[]{0, 2}, solution.binarySearch(matrix, target), "Target 30 should be at [0, 2] in single row matrix");
    }

    @Test
    @DisplayName("Should handle matrix with a single row - target not found")
    void testSingleRowMatrixNotFound_1() {
        int[][] matrix = {{10, 20, 30, 40, 50}};
        int target = 25;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Target 25 should not be found in single row matrix");
    }

    @Test
    @DisplayName("Should handle matrix with a single column - target found")
    void testSingleColumnMatrixFound_1() {
        int[][] matrix = {{10}, {20}, {30}, {40}};
        int target = 30;
        assertArrayEquals(new int[]{2, 0}, solution.binarySearch(matrix, target), "Target 30 should be at [2, 0] in single column matrix");
    }

    @Test
    @DisplayName("Should handle matrix with a single column - target not found")
    void testSingleColumnMatrixNotFound_1() {
        int[][] matrix = {{10}, {20}, {30}, {40}};
        int target = 25;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Target 25 should not be found in single column matrix");
    }

    @Test
    @DisplayName("Should handle empty matrix (0 rows)")
    void testEmptyMatrixZeroRows_1() {
        int[][] matrix = {};
        int target = 5;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Should return [-1, -1] for a matrix with 0 rows");
    }

    @Test
    @DisplayName("Should handle empty matrix (0 columns)")
    void testEmptyMatrixZeroColumns_1() {
        int[][] matrix = {{}, {}}; // Matrix with 2 rows but 0 columns
        int target = 5;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Should return [-1, -1] for a matrix with 0 columns");
    }

    @Test
    @DisplayName("Should handle null matrix")
    void testNullMatrix_1() {
        int[][] matrix = null;
        int target = 10;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Should return [-1, -1] for a null matrix");
    }

    // --- Tests with Negative Numbers and Zeros ---

    @Test
    @DisplayName("Should handle negative numbers and zero - target found")
    void testMatrixWithNegativeAndZeroFound_1() {
        int[][] matrix = {
                {-10, -5, -2},
                {-1, 0, 1},
                {5, 10, 15}
        };
        int target = 0;
        assertArrayEquals(new int[]{1, 1}, solution.binarySearch(matrix, target), "Target 0 should be at [1, 1]");
    }

    @Test
    @DisplayName("Should handle negative numbers and zero - target not found")
    void testMatrixWithNegativeAndZeroNotFound_1() {
        int[][] matrix = {
                {-10, -5, -2},
                {-1, 0, 1},
                {5, 10, 15}
        };
        int target = -3;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Target -3 should not be found");
    }

    // --- Tests with Duplicates ---

    @Test
    @DisplayName("Should find target when duplicates are present")
    void testMatrixWithDuplicatesFound_1() {
        int[][] matrix = {
                {1, 1, 3},
                {1, 5, 7}, // Another 1 in the second row
                {9, 9, 11}
        };
        int target = 1;
        int[] result = solution.binarySearch(matrix, target);
        assertTrue((result[0] == 0 && (result[1] == 0 || result[1] == 1)) || (result[0] == 1 && result[1] == 0),
                "Target 1 should be found at a valid coordinate with duplicates");
    }

    @Test
    @DisplayName("Should not find target when duplicates are present but target is absent")
    void testMatrixWithDuplicatesNotFound_1() {
        int[][] matrix = {
                {1, 1, 3},
                {5, 5, 7},
                {9, 9, 11}
        };
        int target = 6;
        assertArrayEquals(new int[]{-1, -1}, solution.binarySearch(matrix, target), "Target 6 should not be found with duplicates");
    }
}