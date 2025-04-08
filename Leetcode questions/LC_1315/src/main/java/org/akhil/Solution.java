package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // Solution 1 - Bruteforce using BFS
    // O(N)/O(N)
//    public int sumEvenGrandparent(TreeNode root) {
//        int sum = 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            for(int i=0; i<size; i++){
//                TreeNode polled = queue.poll();
//                if(polled.left != null){
//                    queue.offer(polled.left);
//                    if(polled.val %2 == 0){
//                        sum = sum + ((polled.left.left != null)?polled.left.left.val : 0)
//                                + ((polled.left.right != null)?polled.left.right.val : 0);
//                    }
//                }
//                if(polled.right != null){
//                    queue.offer(polled.right);
//                    if(polled.val % 2 == 0){
//                        sum = sum + ((polled.right.left != null)?polled.right.left.val : 0)
//                                + ((polled.right.right != null)?polled.right.right.val : 0);
//                    }
//                }
//            }
//        }
//
//        return sum;
//    }


    // Solution 2 - using DFS
    // O(N)/O(N) only recursive stack space.
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {

        dfs(root, null, null);
        return sum;
    }

    private void dfs(TreeNode current, TreeNode parent, TreeNode grandParent) {
        if(current == null){
            return;
        }

        if(grandParent != null && (grandParent.val % 2 == 0)){
            sum = sum + current.val;
        }

        dfs(current.left, current, parent);
        dfs(current.right, current, parent);
    }
}
