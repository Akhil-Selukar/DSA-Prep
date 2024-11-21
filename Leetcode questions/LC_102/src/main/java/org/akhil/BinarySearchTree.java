package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    private class Node{
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public BinarySearchTree(){}

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    private boolean isEmpty(){
        return this.root == null;
    }

    public void insert(int value){
        this.root = insertHelper(value, this.root);
    }

    private Node insertHelper(int value, Node node) {
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(node.value > value){
            node.left = insertHelper(value, node.left);
        }
        if(node.value < value){
            node.right = insertHelper(value, node.right);
        }

        node.height = Math.max(this.height(node.left), this.height(node.right))+1;
        return node;
    }

    // actual answer
    public List<List<Integer>> levelOrder() {
        return levelOrderHelper(this.root);
    }

    private List<List<Integer>> levelOrderHelper(Node node) {
        List<List<Integer>> result = new ArrayList();

        if(node == null){
            return result;
        }

        Queue<Node> queue = new LinkedList();
        queue.offer(node);

        while(!queue.isEmpty()){
            List<Integer> subList = new ArrayList();
            int queueSize = queue.size();
            for(int i=0; i<queueSize; i++){
                Node currentNode = queue.poll();
                subList.add(currentNode.value);

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(subList);
        }
        return result;
    }
}
