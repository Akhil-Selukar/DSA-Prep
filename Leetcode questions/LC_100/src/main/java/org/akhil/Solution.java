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

    // Time complexity O(N) because we will visit and compare each node once.
    // Space complexity Average case O(logN) i.e. height of the tree - balanced tree / Worst case O(N) - skewed tree (height of a skewed tree is N-1)

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return traverse(p, q);
    }

    private boolean traverse(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }

        if(p != null && q != null && p.val != q.val){
            return false;
        }

        if((p != null && q == null) || (p == null && q != null)){
            return false;
        }

        boolean leftAns = traverse(p.left, q.left);
        boolean rightAns = traverse(p.right, q.right);

        return leftAns && rightAns;
    }
}
