package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // Solution 1 - O(N)/O(N)
    int depth = 0;
    public int maxDepth(Node root) {
        if(root == null){
            return depth;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                Node polled = queue.poll();
                for(Node node:polled.children){
                    queue.offer(node);
                }
            }
            depth++;
        }

        return depth;
    }
}
