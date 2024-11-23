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

    // actual solution
    public int maxDepth() {
        return maxDepth(this.root);
    }
    private int maxDepth(Node node) {
        if(node == null){
            return 0;
        }

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);

        int maxDepth = Math.max(leftDepth, rightDepth)+1;

        return maxDepth;
    }
}
