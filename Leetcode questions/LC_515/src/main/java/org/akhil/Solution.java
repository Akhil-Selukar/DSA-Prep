package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    // O(N)/O(N)
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null){
            return answer;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int maxVal = Integer.MIN_VALUE;
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode polled = queue.poll();
                if(maxVal < polled.val){
                    maxVal = polled.val;
                }

                if(polled.left != null){
                    queue.offer(polled.left);
                }
                if(polled.right != null){
                    queue.offer(polled.right);
                }
            }
            answer.add(maxVal);
        }
        return answer;
    }
}
