package org.akhil;

public class Solution {
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        dfsHelper(root, distance);
        return count;
    }

    private int[] dfsHelper(TreeNode root, int distance) {
        // array to keep track of how many leaf nodes are present at what distance from current node.
        int[] leafDistance = new int[11];
        if(root==null) {
            return leafDistance;
        }
        if(root.left == null && root.right == null){
            leafDistance[1] = 1;
            return leafDistance;
        }

        int[] leftLeafs = dfsHelper(root.left, distance);
        int[] rightLeafs = dfsHelper(root.right, distance);

        for(int d1=1; d1<=distance; d1++){
            for(int d2=1; d2<=distance; d2++){
                if(d1+d2 <= distance){
                    count = count + (leftLeafs[d1] * rightLeafs[d2]);
                }
            }
        }

        // As we are moving 1 level up hence change the distance of leafs from new (up leveled) node.
        for(int i=1; i<11; i++){
            leafDistance[i] = leftLeafs[i-1] + rightLeafs[i-1];
        }
        return leafDistance;
    }
}
