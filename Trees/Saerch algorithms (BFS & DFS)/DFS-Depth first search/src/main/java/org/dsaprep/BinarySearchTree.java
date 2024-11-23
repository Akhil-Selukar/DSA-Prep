package org.dsaprep;

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
    public void preOrderTraversal(){
        preOrderTraversalHelper(this.root);
    }

    private void preOrderTraversalHelper(Node node) {
        if(node == null){
            return;
        }

        System.out.print(node.value+" -> ");
        preOrderTraversalHelper(node.left);
        preOrderTraversalHelper(node.right);
    }

    // In-order traversal
    public void inOrderTraversal(){
        inOrderTraversalHelper(this.root);
    }

    private void inOrderTraversalHelper(Node node) {
        if(node == null){
            return;
        }

        inOrderTraversalHelper(node.left);
        System.out.print(node.value+" -> ");
        inOrderTraversalHelper(node.right);
    }

    // post-order traversal
    public void postOrderTraversal(){
        postOrderTraversalHelper(this.root);
    }

    private void postOrderTraversalHelper(Node node) {
        if(node == null){
            return;
        }

        postOrderTraversalHelper(node.left);
        postOrderTraversalHelper(node.right);
        System.out.print(node.value+" -> ");
    }
}
