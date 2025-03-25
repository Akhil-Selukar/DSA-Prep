package org.akhil;

public class Solution {
    public class TreeNode {
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


    // O(logN)/O(1)
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(root.val == key){
            return helper(root);
        }

        TreeNode dummy = root;
        while(root != null){
            if(root.val > key){
                if(root.left != null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if(root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                } else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    private TreeNode helper(TreeNode root){
        // case 1 - if only right tree present to the node to delete
        // case 4 will also be handled here itself (i.e. ef both side trees are null then it will return null)
        if(root.left == null){
            return root.right;
        }

        // case 2 - if only left tree present to the node to delete
        if(root.right == null){
            return root.left;
        }

        // case 3 - if both side tree present to the node to delete.
        TreeNode rightNode = root.right;
        TreeNode leftNode = root.left;

        while(leftNode.right != null){
            leftNode = leftNode.right;
        }
        leftNode.right = rightNode;
        return root.left;
    }
}
