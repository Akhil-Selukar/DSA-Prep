package org.akhil;

public class Solution {

    // (O(N)/O(logN)) space complexity is only of recursive stack
    int minDiff = Integer.MAX_VALUE;
    Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
        dfsHelper(root);
        return minDiff;
    }

    private void dfsHelper(TreeNode root){
        if(root == null){
            return;
        }

        dfsHelper(root.left);
        if(prev != null){
            minDiff = Math.min(minDiff, Math.abs(prev - root.val));
        }
        prev = root.val;
        dfsHelper(root.right);
    }
}
