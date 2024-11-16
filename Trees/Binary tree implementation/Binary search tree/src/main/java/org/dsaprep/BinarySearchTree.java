package org.dsaprep;

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
        // Base condition : If node is null then create the node and return it
        if(node == null){
            node = new Node(value);
            return node;
        }

        // check which side to go from current node and add value to that side node.
        if(value < node.value){
            node.left = insertHelper(value, node.left);
        } else {
            node.right = insertHelper(value, node.right);
        }

        // update the height of node is recursion call stack. (as new node got added hence height will be updated.)
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

    public boolean isBalanced(){
        return isBalancedHelper(this.root);
    }

    private boolean isBalancedHelper(Node node) {
        // Base condition : if node does not have any other child then it is already balanced.
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <=1 && isBalancedHelper(node.left) && isBalancedHelper(node.right);
    }
}
