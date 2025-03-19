package org.akhil;

import java.util.Stack;

public class BSTIterator {

    // to keep track of smallest node at the top of stack
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {

        // leftmost node is always smallest in BST
        while(root!= null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode smallestNode = stack.pop();
        int val = smallestNode.val;

        smallestNode = smallestNode.right;
        while(smallestNode != null){
            stack.push(smallestNode);
            smallestNode = smallestNode.left;
        }

        return val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
