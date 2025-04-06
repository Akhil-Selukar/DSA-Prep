package org.akhil;

public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfsHelper(root, 0, limit);
    }

    private TreeNode dfsHelper(TreeNode root, int currentSum, int limit) {
        if(root == null){
            return null;
        }

        currentSum = currentSum + root.val;

        if(root.left == null && root.right == null){
            if(currentSum < limit){
                return null;
            } else {
                return root;
            }
        }

        root.left = dfsHelper(root.left, currentSum, limit);
        root.right = dfsHelper(root.right, currentSum, limit);

        return ((root.left == null) && (root.right == null)) ? null : root;
    }
}
