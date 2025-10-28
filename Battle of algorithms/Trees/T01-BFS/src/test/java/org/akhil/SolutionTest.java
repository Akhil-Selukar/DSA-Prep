package org.akhil;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    // Helper method to create a list of lists for easy comparison
    private List<List<Integer>> createExpectedList(int[]... levels) {
        List<List<Integer>> expected = new ArrayList<>();
        for (int[] level : levels) {
            List<Integer> currentLevel = new ArrayList<>();
            for (int val : level) {
                currentLevel.add(val);
            }
            expected.add(currentLevel);
        }
        return expected;
    }

    // Test case 1: Empty tree
    @Test
    void testEmptyTree() {
        Solution solution = new Solution();
        List<List<Integer>> expected = new ArrayList<>();
        assertTrue(expected.equals(solution.levelOrderTraversal()),
                "Test 1 Failed: Empty tree should return an empty list.");
    }

    // Test case 2: Single node tree
    @Test
    void testSingleNodeTree() {
        Solution solution = new Solution();
        solution.insert(100);

        // Expected: [[100]]
        List<List<Integer>> expected = createExpectedList(new int[]{100});
        assertTrue(expected.equals(solution.levelOrderTraversal()),
                "Test 2 Failed: Single node tree traversal incorrect.");
    }

    // Test case 3: Balanced tree (Typical BST structure)
    @Test
    void testBalancedTree() {
        Solution solution = new Solution();
        // Insert order: 50(root), 30, 70, 20, 40, 60, 80
        solution.insert(50);
        solution.insert(30);
        solution.insert(70);
        solution.insert(20);
        solution.insert(40);
        solution.insert(60);
        solution.insert(80);

        // Expected structure:
        //      50
        //    /    \
        //   30    70
        //  / \    / \
        // 20 40  60 80

        List<List<Integer>> expected = createExpectedList(
                new int[]{50},
                new int[]{30, 70},
                new int[]{20, 40, 60, 80}
        );

        assertTrue(expected.equals(solution.levelOrderTraversal()),
                "Test 3 Failed: Balanced tree traversal incorrect.");
    }

    // Test case 4: Right-skewed tree (Degenerate case)
    @Test
    void testRightSkewedTree() {
        Solution solution = new Solution();
        // Insert order: 10, 20, 30, 40
        solution.insert(10);
        solution.insert(20);
        solution.insert(30);
        solution.insert(40);

        // Expected structure:
        // 10
        //  \
        //   20
        //    \
        //     30
        //      \
        //       40

        List<List<Integer>> expected = createExpectedList(
                new int[]{10},
                new int[]{20},
                new int[]{30},
                new int[]{40}
        );

        assertTrue(expected.equals(solution.levelOrderTraversal()),
                "Test 4 Failed: Right-skewed tree traversal incorrect.");
    }

    // Test case 5: Unbalanced tree with a gap in the middle
    @Test
    void testUnbalancedTreeWithGap() {
        Solution solution = new Solution();
        // Insert order: 40(root), 20, 60, 10, 30, 70 (50 is missing)
        solution.insert(40);
        solution.insert(20);
        solution.insert(60);
        solution.insert(10);
        solution.insert(30);
        solution.insert(70);

        // Expected structure:
        //        40
        //      /    \
        //     20    60
        //    / \     \
        //   10 30    70

        List<List<Integer>> expected = createExpectedList(
                new int[]{40},
                new int[]{20, 60},
                new int[]{10, 30, 70} // Note: 70 is the right child of 60, so it's the 3rd element in this level
        );

        assertTrue(expected.equals(solution.levelOrderTraversal()),
                "Test 5 Failed: Unbalanced tree traversal with gap incorrect.");
    }

}