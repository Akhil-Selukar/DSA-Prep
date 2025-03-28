package org.akhil;

public class Solution {

    // Solution 1 - Bruteforce (O(N^2)/O(logN))
//    int findSum(TreeNode root) {
//        if (root == null) return 0;
//        return root.val + findSum(root.left) + findSum(root.right);
//    }
//
//    public int findTilt(TreeNode root) {
//        if (root == null) return 0;
//
//        int left = findTilt(root.left);
//        int right = findTilt(root.right);
//
//        return Math.abs(findSum(root.left) - findSum(root.right)) + left + right;
//
//    }


    // Solution 2 - Using DFS PostOrder (O(N)/O(logN))
    int tildSum = 0;
    public int findTilt(TreeNode root) {
        postOrder(root);

        return tildSum;
    }

    private int postOrder(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        tildSum = tildSum + Math.abs(left - right);
        return root.val + left + right;
    }
}
