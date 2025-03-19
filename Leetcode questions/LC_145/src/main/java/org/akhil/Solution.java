package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> answer = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorderHelper(root);
        return answer;
    }

    private void postorderHelper(TreeNode root){
        if(root ==  null){
            return;
        }

        postorderHelper(root.left);
        postorderHelper(root.right);
        answer.add(root.val);
    }
}
