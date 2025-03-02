package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // Solution 1 - O(N)/O(N)

//    public Node connect(Node root) {
//        if(root == null){
//            return root;
//        }
//
//        Queue<Node> queue = new LinkedList();
//        queue.offer(root);
//
//        while(!queue.isEmpty()){
//            int queueSize = queue.size();
//            for(int i=0; i<queueSize; i++){
//                Node currentNode = queue.poll();
//                if(i != queueSize-1){
//                    currentNode.next = queue.peek();
//                }
//                if(currentNode.left != null){
//                    queue.offer(currentNode.left);
//                }
//                if(currentNode.right != null){
//                    queue.offer(currentNode.right);
//                }
//            }
//        }
//        return root;
//    }


    // Solution 2 - O(N)/O(1)
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        Node dummy = new Node(0);
        Node ans = root;

        while(root != null){
            Node temp = dummy;
            while(root != null){
                if(root.left != null){
                    temp.next = root.left;
                    temp = temp.next;
                }
                if(root.right != null){
                    temp.next = root.right;
                    temp = temp.next;
                }
                root = root.next;
            }
            root = dummy.next;
            dummy.next = null;
        }

        return ans;
    }
}
