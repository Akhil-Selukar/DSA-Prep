package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class Pair{
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }

    // O(N)/O(N)
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int maxWidth = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            int size = queue.size();
            int leftMostIndex = 0;
            int rightMostIndex = 0;

            for(int i=0; i<size; i++){
                Pair polled = queue.poll();
                if(i == 0){
                    leftMostIndex = polled.index;
                }
                if(i == size-1){
                    rightMostIndex = polled.index;
                }
                if(polled.node.left != null){
                    queue.offer(new Pair(polled.node.left, (polled.index * 2) + 1));
                }
                if(polled.node.right != null){
                    queue.offer(new Pair(polled.node.right, (polled.index * 2) + 2));
                }
            }
            int currentLevelWidth = rightMostIndex - leftMostIndex + 1;
            maxWidth = Math.max(maxWidth, currentLevelWidth);
        }

        return maxWidth;
    }
}
