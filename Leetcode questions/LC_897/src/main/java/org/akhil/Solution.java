package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

    // Solution 1 - O(N)/O(N)
//    List<Integer> vals = new ArrayList<>();
//    public TreeNode increasingBST(TreeNode root) {
//        dfs(root);
//
//        if(vals.isEmpty()){
//            return null;
//        }
//
//        TreeNode dummy = new TreeNode(-1);
//        TreeNode node = dummy;
//        for(int val:vals){
//            node.right = new TreeNode(val);
//            node = node.right;
//        }
//        return dummy.right;
//    }
//
//    private void dfs(TreeNode root) {
//        if(root == null){
//            return;
//        }
//
//        dfs(root.left);
//        vals.add(root.val);
//        dfs(root.right);
//    }

    // Solution 2 - using stack  (O(N)/O(N))
    // Even though space complexity is same, but still space wise this is efficient because here O(N) will be the worst case space complexity
    // in average case space complexity will be O(logN) while in first solution the space complexity is always O(N).
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        TreeNode previous = dummy;
        TreeNode current = root;

        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || current != null){
            while(current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            previous.right = current;
            previous = current;
            previous.left = null;
            current = current.right;
        }

        return dummy.right;
    }
}
