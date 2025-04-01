package org.akhil;

public class Solution {
    // worst case - O(N)/O(N) / average case - O(logN)/O(logN)
    public TreeNode searchBST(TreeNode root, int val) {
        return dfs(root, val);
    }

    private TreeNode dfs(TreeNode root, int val){
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        } else if(root.val > val){
            return dfs(root.left, val);
        } else {
            return dfs(root.right, val);
        }
    }

    // eliminated extra function definition
//    public TreeNode searchBST(TreeNode root, int val) {
//        if(root == null){
//            return null;
//        }
//        if(root.val == val){
//            return root;
//        } else if(root.val > val){
//            return searchBST(root.left, val);
//        } else {
//            return searchBST(root.right, val);
//        }
//    }
}
