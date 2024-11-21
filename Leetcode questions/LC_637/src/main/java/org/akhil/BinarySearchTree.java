package org.akhil;

import java.text.DecimalFormat;
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

    private Node insertHelper(int value, Node node){
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

        node.height = Math.max(height(node.left), height(node.right))+1;
        return node;
    }

    public void display(){
        displayHelper(this.root, "Root node is : ");
    }

    private void displayHelper(Node node, String description){
        if(node == null){
            return;
        }
        System.out.println(description + node.value);
        displayHelper(node.left, "Left node of "+node.value+" is : ");
        displayHelper(node.right, "Right node of "+node.value+" is : ");
    }

    // Actual answer
    public List<Double> averageOfLevels() {
        return averageOfLevels(root);
    }

    private List<Double> averageOfLevels(Node node) {
        List<Double> result = new ArrayList();

        if(node == null){
            return result;
        }

        Queue<Node> queue = new LinkedList();
        queue.offer(node);

        while(!queue.isEmpty()){
            int sum = 0;
            int queueSize = queue.size();
            for(int i=0; i<queueSize; i++){
                Node currentNode = queue.poll();
                sum += currentNode.value;

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            double average = (double) sum/queueSize;
            result.add(average);
        }
        return result;
    }
}
