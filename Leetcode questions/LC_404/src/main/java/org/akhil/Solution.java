package org.akhil;

public class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return 0;
        }
        return helper(root, false);
    }

    private int helper(TreeNode root, boolean isLeft){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return isLeft ? root.val : 0;
        }

        int leftSum = helper(root.left, true);
        int rightSum = helper(root.right, false);

        return leftSum + rightSum;
    }
}
