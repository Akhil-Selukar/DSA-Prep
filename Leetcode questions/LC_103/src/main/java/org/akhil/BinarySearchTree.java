package org.akhil;

import java.util.*;

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

    private int height(Node node){
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

        if(value < node.value){
            node.left = insertHelper(value, node.left);
        } else {
            node.right = insertHelper(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right))+1;
        return node;
    }

    public void display(){
        displayHelper(this.root, "Root node : ");
    }

    private void displayHelper(Node node, String details) {
        if(node == null){
            return;
        }
        System.out.println(details + node.value);
        displayHelper(node.left, "left child of " + node.value + " : ");
        displayHelper(node.right, "right child of " + node.value + " : ");
    }

    public List<List<Integer>> zigzagLevelOrder() {
        return zigzagLevelOrder(this.root);
    }

    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null){
            return result;
        }

        Deque<Node> queue = new LinkedList();
        queue.offer(root);
        boolean reverse = false;

        while(!queue.isEmpty()){
            List<Integer> subList = new ArrayList();
            int queueSize = queue.size();

            for(int i=0; i<queueSize; i++){
                if(!reverse){
                    Node currentNode = queue.pollFirst();
                    subList.add(currentNode.value);

                    if(currentNode.left != null){
                        queue.addLast(currentNode.left);
                    }
                    if(currentNode.right != null){
                        queue.addLast(currentNode.right);
                    }
                } else {
                    Node currentNode = queue.pollLast();
                    subList.add(currentNode.value);

                    if(currentNode.right != null){
                        queue.addFirst(currentNode.right);
                    }
                    if(currentNode.left != null){
                        queue.addFirst(currentNode.left);
                    }
                }
            }
            reverse = !reverse;
            result.add(subList);
        }
    return result;
    }
}
