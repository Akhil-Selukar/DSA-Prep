package org.dsaprep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    private class Node {
        private int val;
        private Node leftNode;
        private Node rightNode;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    public BinarySearchTree() {
    }

    public void insert(int val) {
        this.root = insertHelper(val, this.root);
    }

    private Node insertHelper(int val, Node node) {
        if (node == null) {
            node = new Node(val);
            return node;
        }

        if (node.val > val) {
            node.leftNode = insertHelper(val, node.leftNode);
        } else if (node.val < val) {
            node.rightNode = insertHelper(val, node.rightNode);
        }
        return node;
    }

    public void display() {
        displayHelper(this.root, "Root node is : ");
    }

    private void displayHelper(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.val);
        displayHelper(node.leftNode, "Left node to " + node.val + " is : ");
        displayHelper(node.rightNode, "Right node to " + node.val + " is : ");
    }

    // BFS implementation
    public List<List<Integer>> levelOrder(){
        return levelOrder(this.root);
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> subList = new ArrayList();
            for (int i = 0; i < queueSize; i++) {      // because at the end of every level the number of elements in queue will be the next levels element.
                Node currentNode = queue.poll();
                subList.add(currentNode.val);

                // add left and right of the current node in queue
                if (currentNode.leftNode != null) {
                    queue.offer(currentNode.leftNode);
                }
                if (currentNode.rightNode != null) {
                    queue.offer(currentNode.rightNode);
                }
            }
            result.add(subList);
        }
        return result;
    }
}
