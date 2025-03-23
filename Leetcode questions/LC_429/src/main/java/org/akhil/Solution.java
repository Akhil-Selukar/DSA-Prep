package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// O(N)/O(N)
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null){
            return answer;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node polled = queue.poll();
                temp.add(polled.val);

                List<Node> children = polled.children;
                for(Node child:children){
                    queue.offer(child);
                }
            }
            answer.add(temp);
        }
        return answer;
    }
}
