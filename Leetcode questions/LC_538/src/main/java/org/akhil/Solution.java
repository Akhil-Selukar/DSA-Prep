package org.akhil;

public class Solution {

    // Solution 1 - O(N)/O(logN)
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfsHelper(root);
        return root;
    }

    private void dfsHelper(TreeNode root){
        if(root == null){
            return;
        }

        dfsHelper(root.right);
        sum = sum + root.val;
        root.val = sum;
        dfsHelper(root.left);
    }
}
