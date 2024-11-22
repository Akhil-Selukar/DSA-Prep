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

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void insert(int value){
        this.root = insertHelper(this.root, value);
    }

    private Node insertHelper(Node node, int value){
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
        displayHelper(node.left, "Left node to "+node.value+" is : ");
        displayHelper(node.right, "Right node to "+node.value+" is : ");
    }

    public List<List<Integer>> levelOrderBottom() {
        return levelOrderBottom(this.root);
    }
    public List<List<Integer>> levelOrderBottom(Node node) {
        List<List<Integer>> result = new ArrayList();

        if(root == null){
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
            result.add(0,subList);
        }
        return result;
    }
}
