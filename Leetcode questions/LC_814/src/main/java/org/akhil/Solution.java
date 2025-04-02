package org.akhil;

public class Solution {

    // O(N)/O(N)
    public TreeNode pruneTree(TreeNode root) {
        boolean finalTree = containsOne(root);

        return (!finalTree ? null : root);
    }

    private boolean containsOne(TreeNode root) {
        if(root == null){
            return false;
        }

        boolean leftTree = containsOne(root.left);
        if(!leftTree){
            root.left = null;
        }
        boolean rightTree = containsOne(root.right);
        if(!rightTree){
            root.right = null;
        }

        return (leftTree || rightTree || (root.val == 1));
    }
}
