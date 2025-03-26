package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // Solution 1 - Using BFS (this should be the 1st solution in interview and after this suggest for DFS by yourself for improved SC.)
    // O(N)/O(N) (here space complexity is O(N) because at max in balanced node the elements that the queue can have is all elements in last level,
    // and in balanced tree the nodes in last level are approximately N/2 (exactly 2^h where h is height) hence space complexity in worst case will be O(N/2) i.e. O(N)
//    public int findBottomLeftValue(TreeNode root) {
//        TreeNode leftMost = root;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while(!queue.isEmpty()){
//            leftMost = queue.peek();
//            int size = queue.size();
//            for(int i=0; i<size; i++){
//                TreeNode polled = queue.poll();
//                if(polled.left != null){
//                    queue.offer(polled.left);
//                }
//                if(polled.right != null){
//                    queue.offer(polled.right);
//                }
//            }
//        }
//        return leftMost.val;
//    }

    // Solution 2 - using DFS (O(N)/O(logN)) space complexity is only the recursion stack space, no extra space is required.
    int maxDepth = -1;
    int leftMost = -1;

    public int findBottomLeftValue(TreeNode root) {
        dfsHelper(root, 0);
        return leftMost;
    }

    private void dfsHelper(TreeNode root, int currentDepth){
        if(root == null){
            return;
        }

        if(currentDepth > maxDepth){
            leftMost = root.val;
            maxDepth = currentDepth;
        }
        dfsHelper(root.left, currentDepth+1);
        dfsHelper(root.right, currentDepth+1);
    }
}
