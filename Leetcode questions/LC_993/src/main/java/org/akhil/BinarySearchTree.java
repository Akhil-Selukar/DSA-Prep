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
        return node;
    }

    // solution
    public boolean isCousins(int x, int y){
        return isCousins(this.root, x, y);
    }

    private boolean isCousins(Node root, int x, int y) {
        Node xNode = findNode(root, x);
        Node yNode = findNode(root, y);

        return ((level(root, xNode, 0) == level(root, yNode, 0)) && !isSiblings(root, xNode, yNode));
    }

    // find the node corresponding to given value
    private Node findNode(Node node, int val){
        if(node == null){
            return null;
        }
        if(node.value == val){
            return node;
        }
        Node temp = findNode(node.left, val);
        if(temp != null){
            return temp;
        }
        return findNode(node.right, val);
    }

    // find the level of given node
    private int level(Node node, Node givenNode, int level){
        if(node == null){
            return 0;
        }

        if(node == givenNode){
            return level;
        }

        int tempLevel = level(node.left, givenNode, level+1);
        if(tempLevel != 0){
            return tempLevel;
        }
        return level(node.right, givenNode, level+1);
    }

    // check if two nodes are siblings or not.
    private boolean isSiblings(Node node, Node firstNode, Node secondNode){
        if(node == null){
            return false;
        }

        return ((node.left == firstNode && node.right == secondNode) || (node.left == secondNode && node.right == firstNode)
                || isSiblings(node.left, firstNode, secondNode) || isSiblings(node.right, firstNode, secondNode));
    }
}
