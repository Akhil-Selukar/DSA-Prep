package org.akhil;

public class Solution {
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        postOrder(root);
        return moves;
    }

    private int postOrder(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftExcess = distributeCoins(root.left);
        int rightExcess = distributeCoins(root.right);

        moves += Math.abs(leftExcess) + Math.abs(rightExcess);

        int currentAvailable = leftExcess + rightExcess + root.val - 1; // -1 because the node at which we are, will consume 1 coin.
        return currentAvailable;
    }
}
