package org.akhil;

public class Solution {

    // Solution 1 - O(N)/O(N)
    int maxUniLength = Integer.MIN_VALUE;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }

        dfsHelper(root, root.val);
        return maxUniLength;
    }

    private int dfsHelper(TreeNode root, int prevNodeVal) {
        if(root == null){
            return 0;
        }

        int leftLength = dfsHelper(root.left, root.val);
        int rightLength = dfsHelper(root.right, root.val);

        maxUniLength = Math.max(maxUniLength, leftLength+rightLength);
        if(root.val == prevNodeVal){
            return Math.max(leftLength, rightLength)+1;
        }
        return 0;
    }
}
