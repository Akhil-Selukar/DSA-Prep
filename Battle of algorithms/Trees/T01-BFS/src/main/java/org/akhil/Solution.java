package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    private class Node {
        private int val;
        private Node leftNode;
        private Node rightNode;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    public Solution() {
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

    public List<List<Integer>> levelOrderTraversal(){
        return levelOrder(this.root);
    }

    // DO NOT TOUCH CODE ABOVE THIS LINE
    // Only write your solution below.
    // BFS also called as level order traversal as we traverse tree level by level

    public List<List<Integer>> levelOrder(Node root) {
        // Write your code here (complete this method with BFS logic)

    }
}
