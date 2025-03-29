package org.akhil;

public class Solution {

    // O(N)/O(N)
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        return addNodeUsingDfs(root, val, depth, 1);
    }

    private TreeNode addNodeUsingDfs(TreeNode root, int val, int depth, int currentDepth) {
        if(root == null){
            return null;
        }

        if(currentDepth == depth-1){
            TreeNode tempLeft = root.left;
            TreeNode tempRight = root.right;

            root.left = new TreeNode(val);
            root.left.left = tempLeft;
            root.right = new TreeNode(val);
            root.right.right = tempRight;

            return root;
        }

        root.left = addNodeUsingDfs(root.left, val, depth, currentDepth+1);
        root.right = addNodeUsingDfs(root.right, val, depth, currentDepth+1);

        return root;
    }
}
