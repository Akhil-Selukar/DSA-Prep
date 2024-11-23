package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    private class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value){
        this.root = insertHelper(this.root, value);
    }

    private Node insertHelper(Node node, int value) {
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(node.value > value){
            node.left = insertHelper(node.left, value);
        }
        if(node.value < value){
            node.right = insertHelper(node.right, value);
        }
        return node;
    }

    // actual answer
    public List<Integer> rightSideView() {
        return rightSideView(this.root);
    }

    public List<Integer> rightSideView(Node node){
        List<Integer> result = new ArrayList();

        if(node == null){
            return result;
        }

        Queue<Node> queue = new LinkedList();
        queue.offer(node);

        while(!queue.isEmpty()){
            int queueSize = queue.size();
            Node currentNode = null;
            for(int i=0; i<queueSize; i++){
                currentNode = queue.poll();
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentNode.value);
        }
        return result;
    }
}
