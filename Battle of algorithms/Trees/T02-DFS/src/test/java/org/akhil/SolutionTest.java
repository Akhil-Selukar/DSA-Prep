package org.akhil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    // Helper to build a standard BST (e.g., for 50, 30, 70, 20, 40, 60, 80)
    private void buildComplexTree(Solution s) {
        s.insert(50);
        s.insert(30);
        s.insert(70);
        s.insert(20);
        s.insert(40);
        s.insert(60);
        s.insert(80);
        // Structure:
        //       50
        //      /  \
        //    30    70
        //   / \   / \
        // 20 40 60  80
    }

    // =========================================================================
    // Tests for preOrderTraversal
    // =========================================================================

    @Test
    void preOrderTraversal_emptyTree() {
        List<Integer> expected = Collections.emptyList();
        List<Integer> actual = solution.preOrderTraversal();
        assertEquals(expected, actual, "Pre-order traversal on an empty tree should return an empty list.");
    }

    @Test
    void preOrderTraversal_singleNode() {
        solution.insert(10);
        List<Integer> expected = Arrays.asList(10);
        List<Integer> actual = solution.preOrderTraversal();
        assertEquals(expected, actual, "Pre-order traversal on a single node tree should return the node's value.");
    }

    @Test
    void preOrderTraversal_complexTree() {
        buildComplexTree(solution);
        // Expected: Root -> Left -> Right (50, 30, 20, 40, 70, 60, 80)
        List<Integer> expected = Arrays.asList(50, 30, 20, 40, 70, 60, 80);
        List<Integer> actual = solution.preOrderTraversal();
        assertEquals(expected, actual, "Pre-order traversal failed for the complex BST structure.");
    }

    // =========================================================================
    // Tests for inOrderTraversal
    // =========================================================================

    @Test
    void inOrderTraversal_emptyTree() {
        List<Integer> expected = Collections.emptyList();
        List<Integer> actual = solution.inOrderTraversal();
        assertEquals(expected, actual, "In-order traversal on an empty tree should return an empty list.");
    }

    @Test
    void inOrderTraversal_singleNode() {
        solution.insert(10);
        List<Integer> expected = Arrays.asList(10);
        List<Integer> actual = solution.inOrderTraversal();
        assertEquals(expected, actual, "In-order traversal on a single node tree should return the node's value.");
    }

    @Test
    void inOrderTraversal_complexTree() {
        buildComplexTree(solution);
        // Expected: Left -> Root -> Right (For a BST, this is always sorted)
        // (20, 30, 40, 50, 60, 70, 80)
        List<Integer> expected = Arrays.asList(20, 30, 40, 50, 60, 70, 80);
        List<Integer> actual = solution.inOrderTraversal();
        assertEquals(expected, actual, "In-order traversal failed for the complex BST structure (should be sorted).");
    }

    // =========================================================================
    // Tests for postOrderTraversal
    // =========================================================================

    @Test
    void postOrderTraversal_emptyTree() {
        List<Integer> expected = Collections.emptyList();
        List<Integer> actual = solution.postOrderTraversal();
        assertEquals(expected, actual, "Post-order traversal on an empty tree should return an empty list.");
    }

    @Test
    void postOrderTraversal_singleNode() {
        solution.insert(10);
        List<Integer> expected = Arrays.asList(10);
        List<Integer> actual = solution.postOrderTraversal();
        assertEquals(expected, actual, "Post-order traversal on a single node tree should return the node's value.");
    }

    @Test
    void postOrderTraversal_complexTree() {
        buildComplexTree(solution);
        // Expected: Left -> Right -> Root (20, 40, 30, 60, 80, 70, 50)
        List<Integer> expected = Arrays.asList(20, 40, 30, 60, 80, 70, 50);
        List<Integer> actual = solution.postOrderTraversal();
        assertEquals(expected, actual, "Post-order traversal failed for the complex BST structure.");
    }

}