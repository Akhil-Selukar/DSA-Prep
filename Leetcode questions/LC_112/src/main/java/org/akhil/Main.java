package org.akhil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // To test the solution locally we will need a lot of supporting code and hence only the actual solution is given below.
    // To test the solution against testcases, run it on leetcode.

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        // found the sum.
        if(root.val == targetSum && root.left == null && root.right == null){
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum-root.val);
    }
}