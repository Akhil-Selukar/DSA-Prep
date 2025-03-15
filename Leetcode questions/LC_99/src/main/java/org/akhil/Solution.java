package org.akhil;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Solution with in-order traversal ()
    TreeNode previous = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root){
        inOrderTraversal(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrderTraversal(TreeNode node) {
        if(node == null){
            return;
        }

        inOrderTraversal(node.left);
        if(previous != null && previous.val > node.val){
            if(first == null) {
                first = previous;
            }
            second = node;
        }
        previous = node;
        inOrderTraversal(node.right);
    }
}
