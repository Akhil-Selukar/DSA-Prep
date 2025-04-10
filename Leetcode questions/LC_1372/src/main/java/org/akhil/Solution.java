package org.akhil;

public class Solution {

    // Solution 1 - O(N)/O(N)
//    int longestPath = 0;
//    public int longestZigZag(TreeNode root) {
//
//        helper(root, 1, 0);
//        helper(root, -1, 0);
//        return longestPath;
//    }
//
//    private void helper(TreeNode root, int direction, int currLength){
//        if(root == null){
//            return;
//        }
//
//        longestPath = Math.max(longestPath, currLength);
//
//        if(direction == 1){
//            helper(root.left, -1, currLength+1);
//            helper(root.right, 1, 1);
//        } else {
//            helper(root.right, 1, currLength+1);
//            helper(root.left, -1, 1);
//        }
//    }

    // Solution 2 - O(N)/O(N)
    public int longestZigZag(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(helper(root, 1, 0), helper(root, -1, 0));
    }

    private int helper(TreeNode root, int direction, int currLength){
        if(root == null){
            return currLength-1;
        }

        if(direction == 1){
            return Math.max(helper(root.left, -1, currLength+1), helper(root.right, 1, 1));
        } else {
            return Math.max(helper(root.right, 1, currLength+1), helper(root.left, -1, 1));
        }
    }
}
