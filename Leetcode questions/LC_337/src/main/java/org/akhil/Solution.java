package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - Recursive solution (O(2^N)/O(N) worst case, O(log(N)) average case
//    class TreeNode{
//        int val;
//        TreeNode left;
//        TreeNode right;
//    }
//
//    public int rob(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//
//        return helper(root);
//    }
//
//    private int helper(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//
//        int sum = 0;
//
//        if(root.left != null){
//            sum = sum + helper(root.left.left) + helper(root.left.right);
//        }
//        if(root.right != null){
//            sum = sum + helper(root.right.left) + helper(root.right.right);
//        }
//
//        int currentRobbed = root.val + sum;
//        int currentNotRobbed = helper(root.left) + helper(root.right);
//
//        return Math.max(currentRobbed, currentNotRobbed);
//    }


    // Solution 2 - memoization
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        Map<TreeNode, Integer> dp = new HashMap<>();
        return helper(root, dp);
    }

    private int helper(TreeNode root, Map<TreeNode, Integer> dp) {
        if(root == null){
            return 0;
        }

        if(dp.containsKey(root)){
            return dp.get(root);
        }

        int sum = 0;

        if(root.left != null){
            sum = sum + helper(root.left.left, dp) + helper(root.left.right, dp);
        }
        if(root.right != null){
            sum = sum + helper(root.right.left, dp) + helper(root.right.right, dp);
        }

        int currentRobbed = root.val + sum;
        int currentNotRobbed = helper(root.left, dp) + helper(root.right, dp);

        dp.put(root, Math.max(currentRobbed, currentNotRobbed));
        return Math.max(currentRobbed, currentNotRobbed);
    }
}
