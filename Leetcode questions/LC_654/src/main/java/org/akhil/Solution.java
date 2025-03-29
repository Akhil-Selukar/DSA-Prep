package org.akhil;

public class Solution {
    // O(N^2>/O(N) - check explanation

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if(start > end){
            return null;
        }

        int max = getMaxIndex(nums, start, end);

        TreeNode node = new TreeNode(nums[max]);
        node.left = helper(nums, start, max-1);
        node.right = helper(nums, max+1, end);

        return node;
    }

    private int getMaxIndex(int[] nums, int start, int end) {
        int maxIndex = start;
        for(int i=start; i<=end; i++){
            if(nums[maxIndex]<nums[i]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
