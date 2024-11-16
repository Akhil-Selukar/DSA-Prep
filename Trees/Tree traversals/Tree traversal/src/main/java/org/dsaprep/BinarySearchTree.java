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

    public void insert(int value){
        this.root = insertHelper(value, root);
    }

    private Node insertHelper(int value, Node node){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.value){
            node.left = insertHelper(value, node.left);
        } else {
            node.right = insertHelper(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    private int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    // Preorder traversal
    public void preorder(){
        preorderHelper(this.root);
    }

    private void preorderHelper(Node node){
        if(node == null){
            return;
        }

        System.out.print(node.value + " -> ");
        preorderHelper(node.left);
        preorderHelper(node.right);
    }

    // Inorder traversal
    public void inorder(){
        inorderHelper(this.root);
    }

    private void inorderHelper(Node node){
        if(node == null){
            return;
        }

        inorderHelper(node.left);
        System.out.print(node.value + " -> ");
        inorderHelper(node.right);
    }

    // Postorder traversal
    public void postorder(){
        postorderHelper(this.root);
    }

    private void postorderHelper(Node node){
        if(node == null){
            return;
        }

        postorderHelper(node.left);
        postorderHelper(node.right);
        System.out.print(node.value + " -> ");
    }
}
