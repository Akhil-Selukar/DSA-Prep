package org.akhil;

public class Solution {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Solution 1 - Using recursion O(H)/O(H)  where H is height of the BST. Space complexity because we are using recursion which will need stack space
    // and time complexity is not O(N) because every time we are eliminating either left or right tree
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root == null){
//            return root;
//        }
//        if(p.val<=root.val && q.val>=root.val || p.val>=root.val && q.val <= root.val){
//            return root;
//        }
//        if(p.val<root.val && q.val<root.val){
//            return lowestCommonAncestor(root.left, p, q);
//        } else {
//            return lowestCommonAncestor(root.right, p, q);
//        }
//    }


    // Solution 1.1 - little simplified.
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root == null){
//            return root;
//        }
//        if(p.val<root.val && q.val<root.val){
//            return lowestCommonAncestor(root.left, p, q);
//        } if(p.val>root.val && q.val>root.val){
//            return lowestCommonAncestor(root.right, p, q);
//        }
//        else {
//            return root;
//        }
//    }


    // Solution 2 - without using recursion - O(H)/O(1) space is O(1) as no recursive stack space is required here.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(p.val<root.val && q.val<root.val){
                root = root.left;
            }
            if(p.val>root.val && q.val>root.val){
                root = root.right;
            }
            else {
                return root;
            }
        }
        return null;
    }
}
