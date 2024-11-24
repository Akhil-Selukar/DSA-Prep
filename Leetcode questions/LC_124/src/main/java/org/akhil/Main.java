package org.akhil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // To test the solution locally we will need a lot of supporting code and hence only the actual solution is given below.
    // To test the solution against testcases, run it on leetcode.

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode node){
        if(node == null){
            return 0;
        }

        // get values for left and right nodes.
        int leftVal = helper(node.left);
        int rightVal = helper(node.right);

        // if any value is negative then better to exclude that from path as it will reduce the overall sum.
        leftVal = Math.max(0, leftVal);
        rightVal = Math.max(0, rightVal);

        // calculate sum of current path (left + right + node)
        int currentPathSum = leftVal + rightVal + node.val;

        // check against max and update if required
        maxSum = Math.max(maxSum, currentPathSum);

        // return max path at current node (as we need overall Max sum so no point in having minimum sum so get which one
        // is max left or right and add current node to create continuous path till previous node and then return it)
        return Math.max(leftVal, rightVal) + node.val;
    }
}