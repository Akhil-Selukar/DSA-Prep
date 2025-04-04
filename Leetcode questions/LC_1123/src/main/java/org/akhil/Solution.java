package org.akhil;

public class Solution {
    TreeNode ans = null;
    int maxDepth = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {

        dfs(root, 0);
        return ans;
    }

    private int dfs(TreeNode root, int currDepth) {
        if(root == null){
            return currDepth;
        }

        int leftDepth = dfs(root.left, currDepth+1);
        int rightDepth = dfs(root.right, currDepth+1);

        currDepth = Math.max(leftDepth, rightDepth);
        maxDepth = Math.max(maxDepth, currDepth);

        if(leftDepth == maxDepth && rightDepth == maxDepth){
            ans = root;
        }

        return currDepth;
    }
}
