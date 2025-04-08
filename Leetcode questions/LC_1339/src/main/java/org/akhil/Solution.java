package org.akhil;

public class Solution {

    // O(N)/O(N) or O(Nlog(N)) i.e. recursion stack space.
    long totalSum = 0;
    long answer = 0;
    public int maxProduct(TreeNode root) {
        totalSum = dfs(root);
        dfs(root);

        return (int)(answer % (1e9+7));
    }

    private long dfs(TreeNode root) {
        if(root == null){
            return 0;
        }

        long leftSum = dfs(root.left);
        long rightSum = dfs(root.right);

        long currentSum = leftSum + rightSum + root.val;

        answer = Math.max(answer, (totalSum - currentSum) * currentSum);
        return currentSum;
    }
}
