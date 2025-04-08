package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // Solution 1 -  using BFS
    // O(N)/O(N)
//    public int deepestLeavesSum(TreeNode root) {
//        int sum = 0;
//        Queue<TreeNode> queue = new LinkedList();
//        queue.offer(root);
//
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            int currentSum = 0;
//            for(int i=0; i<size; i++){
//                TreeNode polled = queue.poll();
//                currentSum = currentSum + polled.val;
//
//                if(polled.left != null){
//                    queue.offer(polled.left);
//                }
//                if(polled.right != null){
//                    queue.offer(polled.right);
//                }
//            }
//            sum = currentSum;
//        }
//
//        return sum;
//    }

    // Solution 2 - Using DFS
    // O(N)/O(N)
    int maxHeight = Integer.MIN_VALUE;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {

        dfsHelper(root, 0);
        return sum;
    }

    private void dfsHelper(TreeNode root, int height){
        if(root == null){
            return;
        }

        height = height+1;

        dfsHelper(root.left, height);

        if(root.left == null && root.right == null){
            if(maxHeight < height){
                maxHeight = height;
                sum = root.val;
            } else if(maxHeight == height){
                sum = sum + root.val;
            }
        }

        dfsHelper(root.right, height);
    }
}
