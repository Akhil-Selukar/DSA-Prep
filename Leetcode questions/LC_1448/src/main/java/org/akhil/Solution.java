package org.akhil;

public class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        if(root == null){
            return count;
        }

        dfs(root, root.val);
        return count;
    }

    private void dfs(TreeNode root, int maxTillNode){
        if(root == null){
            return;
        }

        if(root.val >= maxTillNode){
            count++;
            maxTillNode = root.val;
        }

        dfs(root.left, maxTillNode);
        dfs(root.right, maxTillNode);
    }
}
