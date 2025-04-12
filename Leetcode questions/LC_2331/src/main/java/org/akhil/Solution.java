package org.akhil;

public class Solution {

    // O(N)/O(N)
    public boolean evaluateTree(TreeNode root) {
        if(root.val == 0 || root.val == 1){
            return root.val == 1;
        }

        boolean leftVal = evaluateTree(root.left);
        boolean rightVal = evaluateTree(root.right);

        int rootVal = root.val;

        if(rootVal == 2){
            return (leftVal || rightVal);
        } else {
            return (leftVal && rightVal);
        }
    }
}
