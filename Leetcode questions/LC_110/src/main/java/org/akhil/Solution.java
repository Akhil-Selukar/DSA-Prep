package org.akhil;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        return isBalancedHelper(root) != -1;

    }

    // visualises this problem in bottoms-up way for better understanding.
    private int isBalancedHelper(TreeNode node){
        // base case - if node is null then it will not contribute to height.
        if(node == null){
            return 0;
        }

        // recursive call for left and right node
        int left = isBalancedHelper(node.left);
        int right = isBalancedHelper(node.right);

        // if any of the node is found imbalanced in below steps during recursive calls, the entire tree will be imbalanced.
        if(left == -1 || right == -1){
            return -1;
        }

        // Step to check if there is imbalance present at the node?
        // if imbalance is there then return -1 value (which can not be a valid height)
        if(Math.abs(left - right) > 1) {
            return -1;
        }

        // if the node is balanced the return height
        return Math.max(left, right)+1;
    }
}
