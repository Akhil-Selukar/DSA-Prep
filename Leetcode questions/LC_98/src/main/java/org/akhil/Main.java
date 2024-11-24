package org.akhil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // To test the solution locally we will need a lot of supporting code and hence only the actual solution is given below.
    // To test the solution against testcases, run it on leetcode.

    public boolean isValidBST(TreeNode root) {
        Integer lowerLimit = null;
        Integer upperLimit = null;

        return isValidHelper(root, lowerLimit, upperLimit);
    }

    private boolean isValidHelper(TreeNode node, Integer lowerLimit, Integer upperLimit) {
        // base condition
        if(node == null){
            return true;
        }

        // invalid conditions
        if(lowerLimit != null && node.val <= lowerLimit){  // as for root node lower and upper limit can be null hence need a null check
            return false;
        }
        if(upperLimit != null && node.val >= upperLimit){  // as for root node lower and upper limit can be null hence need a null check
            return false;
        }

        // recursive calls for next level on both sides
        boolean leftTreeValid = isValidHelper(node.left, lowerLimit, node.val);
        boolean rightTreeValid = isValidHelper(node.right, node.val, upperLimit);

        return leftTreeValid && rightTreeValid; // both the side need to be valid for tree to be valid.
    }
}