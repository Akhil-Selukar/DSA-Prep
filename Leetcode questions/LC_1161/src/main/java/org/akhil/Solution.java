package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // O(N)/O(N)
    public int maxLevelSum(TreeNode root) {
        int maxLevel = 0;
        int maxSum = Integer.MIN_VALUE;
        int currLevel = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            int currSum = 0;
            currLevel++;
            for(int i=0; i<size; i++){
                TreeNode polled = queue.poll();
                currSum = currSum + polled.val;

                if(polled.left != null){
                    queue.offer(polled.left);
                }
                if(polled.right != null){
                    queue.offer(polled.right);
                }
            }

            if(currSum > maxSum){
                maxLevel = currLevel;
                maxSum = currSum;
            }
        }

        return maxLevel;
    }
}
