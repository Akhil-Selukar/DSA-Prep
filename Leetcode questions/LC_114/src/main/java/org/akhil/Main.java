package org.akhil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // Here normal brute force approach will be to traverse the tree in pre-order fashion and store all elements in a queue,
    // then get element one by one from the queue and form required tree/List.
    // Followup question given is to solve it in O(1) space complexity. For that we can use below approach

    // To run the solution here we need lot-of supporting code hence the code can be run here.
    // To test the code against testcases run the code on leetcode.

    public static void flatten(TreeNode root) {
        // start from root node
        TreeNode currentNode = root;

        while(currentNode != null){
            if(currentNode.left != null){
                // find rightmost node on left side of currentNode.
                TreeNode temp = currentNode.left;
                while(temp.right != null){
                    temp = temp.right;
                }

                // attach currentNode.right to temp.right (refer readme.md image step2)
                temp.right = currentNode.right;
                currentNode.right = currentNode.left;  // (refer readme.md image step3)
                currentNode.left = null;
            }
            currentNode = currentNode.right;
        }
    }
}