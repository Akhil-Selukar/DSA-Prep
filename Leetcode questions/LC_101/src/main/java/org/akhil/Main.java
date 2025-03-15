package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // Below solution is difficult to run locally and wil need a lot of background code hence writing only solution below
    // to check the solution against testcases run the solution on leetcode.


    // Solution 1 - O(N)/O(N)
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();

        queue.offer(root.left);     // not adding root as there can not be any mirror position for root.
        queue.offer(root.right);

        while(!queue.isEmpty()){
            TreeNode leftNode = queue.poll();       // because leftNode was inserted in queue first so FIFO
            TreeNode rightNode = queue.poll();

            if(leftNode == null && rightNode == null){
                continue;                           // skipping this iteration as there won't be any child to these nodes but there can be some other nodes in queue.
            }

            if(leftNode == null || rightNode == null){      // we are at this condition means both are not null (but any one can). And if this condition is true means only one is null, so mirror positions are not same.
                return false;
            }

            if(leftNode.val != rightNode.val){          // mirror positions are not same
                return false;
            }

            // add outer mirror nodes
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);

            // add inner mirror nodes
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;        // if none of the false condition is executed and entire tree is traversed that means tree is a mirror/symmetric tree.
    }

    // Solution 2 - O(N)/O(logN)
    public boolean isSymmetric2(TreeNode root) {

        return symmetricHelper(root.left, root.right);
    }

    private boolean symmetricHelper(TreeNode left, TreeNode right) {
        if(right == null && left == null){
            return true;
        }

        if(right == null || left == null){
            return false;
        }

        if(right.val != left.val){
            return false;
        }

        return symmetricHelper(left.left, right.right) && symmetricHelper(left.right, right.left);
    }
}