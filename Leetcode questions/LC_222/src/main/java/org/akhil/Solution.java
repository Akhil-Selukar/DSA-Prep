package org.akhil;

public class Solution {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Solution 1
    // For this solution Time complexity will always be O(N)
    // space complexity will be O(1)
//    int count = 0;
//    public int countNodes(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//
//        dfsHelper(root);
//        return count;
//    }
//
//    private void dfsHelper(TreeNode root){
//        if(root == null){
//            return;
//        }
//
//        count++;
//        dfsHelper(root.left);
//        dfsHelper(root.right);
//    }


    // Solution 2
    // Time complexity in worst case O(N) if leftDepth != rightDepth. In average case O(logN) where leftDepth = rightDepth = N nodes.
    // Space complexity O(1)

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftDepth = getDepth(root, true);
        int rightDepth = getDepth(root, false);

        if(leftDepth == rightDepth){
            return (int)Math.pow(2, leftDepth)-1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }

    private int getDepth(TreeNode root, boolean isLeft){
        int depth = 0;
        while(root != null){
            depth++;
            root = isLeft ? root.left : root.right;
        }
        return depth;
    }
}
