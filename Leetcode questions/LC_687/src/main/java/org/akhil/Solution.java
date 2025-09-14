package org.akhil;

public class Solution {

    // Solution 1 - O(N)/O(N)
//    int maxUniLength = Integer.MIN_VALUE;
//    public int longestUnivaluePath(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//
//        dfsHelper(root, root.val);
//        return maxUniLength;
//    }
//
//    private int dfsHelper(TreeNode root, int prevNodeVal) {
//        if(root == null){
//            return 0;
//        }
//
//        int leftLength = dfsHelper(root.left, root.val);
//        int rightLength = dfsHelper(root.right, root.val);
//
//        maxUniLength = Math.max(maxUniLength, leftLength+rightLength);
//        if(root.val == prevNodeVal){
//            return Math.max(leftLength, rightLength)+1;
//        }
//        return 0;
//    }

    // ----------------------------
    // Solution 2 - More intuitive solution
    // O(N)/O(H)
    int maxLength = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxLength;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right= dfs(root.right);

        int leftPathLength = 0;
        if(root.left != null && root.val == root.left.val){
            leftPathLength = left + 1;
        }

        int rightPathLength = 0;
        if(root.right != null && root.val == root.right.val){
            rightPathLength = right + 1;
        }

        maxLength = Math.max(maxLength, leftPathLength + rightPathLength);

        return Math.max(leftPathLength, rightPathLength);
    }
}
