package org.akhil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // To test the solution locally we will need a lot of supporting code and hence only the actual solution is given below.
    // To test the solution against testcases, run it on leetcode.

    public int kthSmallest(TreeNode root, int k) {
        return helper(root, k).val;
    }

    int counter = 0;
    private TreeNode helper(TreeNode node, int k) {
        if(node == null){
            return null;
        }

        // find on the left hand side tree
        TreeNode leftNode = helper(node.left, k);

        if(leftNode != null){
            return leftNode;
        }
        counter++;
        if(counter == k){
            return node;
        }

        // check right hand side tree
        return helper(node.right, k);
    }


}