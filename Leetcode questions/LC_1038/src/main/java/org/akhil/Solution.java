package org.akhil;

public class Solution {

    // O(N)/O(N)
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }

        dfs(root.right);
        sum = sum + root.val;
        root.val = sum;
        dfs(root.left);
    }
}
