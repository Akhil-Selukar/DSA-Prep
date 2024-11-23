package org.akhil;

public class BinarySearchTree {
    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value) {
        this.root = insertHelper(this.root, value);
    }

    public Node insertHelper(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (node.value > value) {
            node.left = insertHelper(node.left, value);
        }
        if (node.value < value) {
            node.right = insertHelper(node.right, value);
        }
        return node;
    }

    // solution

    public int diameterOfBinaryTree() {
        return diameterOfBinaryTree(this.root);
    }

    private int maxDiameter = 0;

    private int diameterOfBinaryTree(Node root) {
        findHeight(this.root);
        return maxDiameter;
    }

    private int findHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        int diaOfCurrentNode = leftHeight + rightHeight;

        maxDiameter = Math.max(maxDiameter, diaOfCurrentNode);

        return Math.max(leftHeight, rightHeight)+1;
    }
}
