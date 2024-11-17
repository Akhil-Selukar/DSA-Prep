package org.dsaprep;

public class AVLTree {

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

    public int getTreeHeight(){
        return height(this.root);
    }

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

    private Node insertHelper(int value, Node node){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(node.value < value){
            node.right = insertHelper(value, node.right);
        } else {
            node.left = insertHelper(value, node.left);
        }

        node.height = Math.max(height(node.left), height(node.right))+1;

        return balance(node);
    }

    private Node balance(Node node){
        // left heavy tree
        if(height(node.left) - height(node.right) > 1){
            // left-left case
            if (height(node.left.left) - height(node.left.right) > 0){
                return rotateRight(node);
            }

            // left-right case
            if(height(node.left.left) - height(node.left.right) < 0){
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        // right heavy tree
        if(height(node.left) - height(node.right) < -1){
            // right-right case
            if(height(node.right.right) - height(node.right.left) > 0){
                return rotateLeft(node);
            }

            // right-left case
            if(height(node.right.right) - height(node.right.left) < 0){
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        // if balanced tree
        return node;
    }

    public Node rotateRight(Node node){
        Node child = node.left;
        Node temp = child.right;

        child.right = node;
        node.left = temp;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;

        return child;
    }

    public Node rotateLeft(Node node){
        Node child = node.right;
        Node temp = child.left;

        child.left = node;
        node.right = temp;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;

        return child;
    }

    public void display(){
        displayHelper(this.root, "Root node is : ");
    }

    private void displayHelper(Node node, String description) {
        if(node == null){
            return;
        }
        System.out.println(description+node.value);
        displayHelper(node.left, "Left node for node "+node.value+" is :");
        displayHelper(node.right, "Right node for node "+node.value+" is :");
    }
}
