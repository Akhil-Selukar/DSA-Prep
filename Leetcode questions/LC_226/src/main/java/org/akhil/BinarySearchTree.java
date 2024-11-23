package org.akhil;

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

    // actual solution
    public void invertTree() {
        invertTree(this.root);
    }

    private Node invertTree(Node node) {
        if(node == null){
            return null;
        }

        Node leftNode = invertTree(node.left);
        Node rightNode = invertTree(node.right);

        node.left = rightNode;
        node.right = leftNode;

        return node;
    }

}
