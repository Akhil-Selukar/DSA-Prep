package org.akhil;

public class Solution {
    // Here the intuition is simple, check all possibilities of red node. (There are only 3 either red node is root node,
    // or red node is to the left or root or to the right of root)
    // Next we can count the nodes present to the left and right of the red node.
    // In left or right case if the total nodes (i.e. leftNodes + rightNodes + 1 (for itself) is less that n/2 i.e. half of total number of nodes
    // then we can win (we can mark parent to red as blue and block the entire tree except children of red)
    // In root node is red case if any of the left or right side nodes are greater that n/2 then we can pick that side and win the game.

    // O(N)/ O(logN)/O(N) in case of skewed tree
    int leftRedCount = 0;
    int rightRedCount = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfsHelper(root, x);

        if((leftRedCount > (n/2)) || (rightRedCount > (n/2))){
            return true;
        }
        if((leftRedCount + rightRedCount + 1) <= (n/2)){
            return true;
        }

        return false;
    }

    private int dfsHelper(TreeNode root, int x){
        if(root == null){
            return 0;
        }

        int leftCount = dfsHelper(root.left, x);
        int rightCount = dfsHelper(root.right, x);

        if(root.val == x){
            leftRedCount = leftCount;
            rightRedCount = rightCount;
        }

        return leftCount +  rightCount + 1;
    }
}
