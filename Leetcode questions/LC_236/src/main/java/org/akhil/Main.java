package org.akhil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // To test the solution locally we will need a lot of supporting code and hence only the actual solution is given below.
    // To test the solution against testcases, run it on leetcode.

    public static TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null){
            return null;
        }

        if(node == p || node == q){
            return node;
        }

        TreeNode leftFound = lowestCommonAncestor(node.left, p, q);
        TreeNode rightFound = lowestCommonAncestor(node.right, p, q);

        if(leftFound != null && rightFound != null){
            return node;
        }

        return leftFound == null ? rightFound : leftFound;
    }
}