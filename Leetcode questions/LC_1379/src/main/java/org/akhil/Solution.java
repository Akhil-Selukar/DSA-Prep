package org.akhil;

public class Solution {

    // Solution 1 - O(N)/O(N)
//    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
//        return dfs(cloned, target);
//    }
//
//    public TreeNode dfs(TreeNode root, TreeNode target){
//        if(root == null){
//            return null;
//        }
//
//        if(root.val == target.val){
//            return root;
//        }
//
//        TreeNode left = dfs(root.left, target);
//        TreeNode right = dfs(root.right, target);
//
//        return left == null ? right : left;
//    }


    // Solution 2 - O(N)/O(N)
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null || cloned == null){
            return null;
        }

        if(original == target){
            return cloned;
        }

        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if(left != null){
            return left;
        }

        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        if(right != null){
            return right;
        }

        return null;
    }
}
