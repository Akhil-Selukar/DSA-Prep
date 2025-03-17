package org.akhil;

import java.util.ArrayList;
import java.util.List;

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

    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return answer;
        }

        helperDfs(root, targetSum, new ArrayList<Integer>());

        return answer;
    }

    private void helperDfs(TreeNode node, int target, ArrayList<Integer> path) {
        if(node == null){
            return;
        }

        path.add(node.val);

        if(node.left == null && node.right == null && node.val == target){
            answer.add(new ArrayList(path));
        }

        target = target - node.val;

        helperDfs(node.left, target, path);
        helperDfs(node.right, target, path);

        path.remove(path.size()-1);
    }
}
