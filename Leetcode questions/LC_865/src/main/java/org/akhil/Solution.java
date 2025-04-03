package org.akhil;

public class Solution {
    int deepestLength = 0;
    TreeNode result = null;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private int dfs(TreeNode root, int currentLevel){
        if(root == null){
            return currentLevel;
        }

        int leftLevel = dfs(root.left, currentLevel+1);
        int rightLevel = dfs(root.right, currentLevel+1);

        currentLevel = Math.max(leftLevel, rightLevel);
        deepestLength = Math.max(deepestLength, currentLevel);
        if(leftLevel == deepestLength && rightLevel == deepestLength){
            result = root;
        }
        return currentLevel;
    }
}
