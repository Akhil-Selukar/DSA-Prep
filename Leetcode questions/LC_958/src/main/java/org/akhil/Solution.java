package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // The solution to this problem depends on below property of complete binary tree
    // In complete binary tree's preorder or inorder traversal there will not be any null node in between (i.e. no null node
    // can be present before any non-null node.

    // O(N)/O(N) - here space complexity can be stated as O(2^h) where h is height of the binary tree but this will be valid only in case of PERFECT binary tree.
    // but it is not necessary that all complete binary trees are perfect hence we are using approximation (i.e. number of nodes in
    // last level of a complete binary tree are approximately (N/2) nodes hence we are saying space complexity as O(N).
    // Mention above point related to space complexity in interview, can be a positive impression on interviewer.
    public boolean isCompleteTree(TreeNode root) {
        boolean isComplete = true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode polled = queue.poll();
            if(polled == null){
                isComplete = false;
            } else {
                if(!isComplete){        // we had encountered a null node in BFS before current non-null node.
                    return false;
                }
                queue.offer(polled.left);
                queue.offer(polled.right);
            }
        }

        // if reach till this point then that means our queue became empty and we were able to traverse through entire tree
        // without violating the condition of null. There is a edge case here i.e. last node which will be polled in case of
        // valid complete tree can be a null node hence isComplete can be false at this place even though the tree is complete.
        // Hence we are not directly returning isComplete and returning true instead.
        return true;
    }
}
