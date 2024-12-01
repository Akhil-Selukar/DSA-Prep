package org.akhil;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    private class NodeWithCoordinate{
        int val;
        int xCoordinate;
        int yCoordinate;

        public NodeWithCoordinate(){};
        public NodeWithCoordinate(int val, int x, int y){
            this.val = val;
            this.xCoordinate = x;
            this.yCoordinate = y;
        };
    }
    
    PriorityQueue<NodeWithCoordinate> queue;        // defining globally because will be initializing in separate function and using in another.
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null){
            return answer;
        }

        // Implement comparator for sorting
        queue = new PriorityQueue<>((node1,node2)->{
           if(node1.xCoordinate != node2.xCoordinate){          // sort based on x-coordinate
               return node1.xCoordinate - node2.xCoordinate;
           }
           else if(node1.yCoordinate != node2.yCoordinate){     // if x coordinates are some i.e. nodes in same column, then sort based on y-coordinate (top-to-bottom)
               return node1.yCoordinate - node2.yCoordinate;
           }
           else{                                                // if both coordinates are same then sort based on values.
               return node1.val - node2.val;
           }
        });

        depthFirstSearch(root, 0, 0);      // traverse all the nodes and initialize queue.

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            NodeWithCoordinate removed = queue.poll();
            list.add(removed.val);
            while(!queue.isEmpty() && queue.peek().xCoordinate == removed.xCoordinate){
                list.add(queue.poll().val);
            }
            answer.add(list);
        }
        return answer;
    }

    private void depthFirstSearch(TreeNode node, int x_coordinate, int y_coordinate) {
        // base condition
        if(node == null){
            return;
        }
        queue.offer(new NodeWithCoordinate(node.val, x_coordinate, y_coordinate));
        depthFirstSearch(node.left, x_coordinate-1, y_coordinate+1);
        depthFirstSearch(node.right, x_coordinate+1, y_coordinate+1);
    }
}
