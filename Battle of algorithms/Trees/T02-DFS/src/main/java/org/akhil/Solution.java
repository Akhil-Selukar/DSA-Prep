package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
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

        return node;
    }

    // Pre-order traversal
    public List<Integer> preOrderTraversal(){
        List<Integer> result = new ArrayList<>();
        preOrderTraversalHelper(this.root, result);
        return result;
    }

    // In-order traversal
    public List<Integer> inOrderTraversal(){
        List<Integer> result = new ArrayList<>();
        inOrderTraversalHelper(this.root, result);
        return result;
    }

    // post-order traversal
    public List<Integer> postOrderTraversal(){
        List<Integer> result = new ArrayList<>();
        postOrderTraversalHelper(this.root, result);
        return result;
    }

    // DO NOT TOUCH ANY CODE ABOVE THIS LINE.
    // Write yout code for all 3 methods below.

    private void preOrderTraversalHelper(Node node, List<Integer> result) {

    }

    private void inOrderTraversalHelper(Node node, List<Integer> result) {

    }

    private void postOrderTraversalHelper(Node node, List<Integer> result) {

    }
}
