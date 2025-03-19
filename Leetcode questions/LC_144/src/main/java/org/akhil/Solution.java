package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class TreeNode{
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

    List<Integer> answer = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorderHelper(root);
        return answer;
    }

    private void preorderHelper(TreeNode root){
        if(root == null){
            return;
        }
        answer.add(root.val);
        preorderHelper(root.left);
        preorderHelper(root.right);
    }
}
