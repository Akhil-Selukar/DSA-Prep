package org.akhil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTIterator {

//    // Solution 1 - Bruteforce
//    // O(N)/O(N)
//
//    List<Integer> inOrder;
//    int pointer;        // to track place of iterator
//    public BSTIterator(TreeNode root) {
//        inOrder = new ArrayList<>();
//
//        // perform preorder traversal and populate the list (this will be O(N))
//        inorderTraversal(root);
//    }
//
//    private void inorderTraversal(TreeNode root) {
//        if(root == null){
//            return;
//        }
//
//        inorderTraversal(root.left);
//        inOrder.add(root.val);
//        inorderTraversal(root.right);
//    }
//
//    public int next() {
//        int val = inOrder.get(pointer);
//        pointer++;
//        return val;
//
//    }
//
//    public boolean hasNext() {
//        return inOrder.size() > pointer;
//    }

    // -------------------------------
    // Solution 2 - The optimized one and as per follow up
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
