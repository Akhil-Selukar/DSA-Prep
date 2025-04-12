package org.akhil;

public class Solution {

    // O(N)/O(N)
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

    private int[] dfs(TreeNode root) {
        if(root == null){
            return new int[]{0,0};
        }

        int[] leftValues = dfs(root.left);
        int[] rightValues = dfs(root.right);

        int sumOfValues = leftValues[0] + rightValues[0] + root.val;
        int totalNodes = leftValues[1] + rightValues[1] + 1;

        if(Math.floor(sumOfValues/totalNodes) == root.val){
            count++;
        }

        return new int[]{sumOfValues, totalNodes};
    }
}
