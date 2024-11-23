package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    private Node root;

    public void insert(int value){
        this.root = insertHelper(this.root, value);
    }

    private Node insertHelper(Node node, int value){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(node.val > value){
            node.left = insertHelper(node.left, value);
        }
        if(node.val < value){
            node.right = insertHelper(node.right, value);
        }

        return node;
    }

    public void display(){
        displayHelper(this.root, "Root node is : ");
    }

    private void displayHelper(Node node, String description){
        if(node == null){
            return;
        }

        System.out.println(description+ node.val);
        displayHelper(node.left, "Left node to "+node.val+" is : ");
        displayHelper(node.right, "Right node to "+node.val+" is : ");
        displayHelper(node.next, "Next node to "+node.val+" is : ");
    }

    // Actual solution

    public void connect(){
        connect(this.root);
    }

    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i=0; i<queueSize; i++){
                Node currentNode = queue.poll();
                if(i != queueSize-1){
                    currentNode.next = queue.peek();
                }
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
        }
        return root;
    }

    // Solution without using extra space.
    public void connect1(){
        connect1(this.root);
    }

    public Node connect1(Node root) {
        if(root == null){
            return root;
        }

        Node leftMost = root;

        while(leftMost.left != null){
            Node currentNode = leftMost;
            while(currentNode != null){
                currentNode.left.next = currentNode.right;
                if(currentNode.next != null){
                    currentNode.right.next = currentNode.next.left;
                }
                currentNode = currentNode.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
