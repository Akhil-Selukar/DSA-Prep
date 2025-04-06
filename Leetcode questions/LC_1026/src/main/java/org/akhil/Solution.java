package org.akhil;

public class Solution {

    // to have the difference as max we need to subtract min value from a path to the max value in that same path.
    // O(N)/O(H) where H is the height of the tree. Space complexity is because of recursive stack space.
    int maxDiff = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null || (root.left==null && root.right == null)){
            return 0;
        }

        dfsHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return maxDiff;
    }

    private void dfsHelper(TreeNode root, int minValue, int maxValue) {
        if(root == null){       // we are at the end of current path so we can calculate max diff.
            maxDiff = Math.max(maxDiff, Math.abs(maxValue - minValue));
            return;
        }

        maxValue = Math.max(maxValue, root.val);
        minValue = Math.min(minValue, root.val);

        dfsHelper(root.left, minValue, maxValue);
        dfsHelper(root.right, minValue, maxValue);
    }
}
