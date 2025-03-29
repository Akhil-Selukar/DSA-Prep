package org.akhil;

public class Solution {

    // O(N)/O(logN) in worst case space complexity can go to O(N)
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsHelper(root, sb);
        return sb.toString();
    }

    private void dfsHelper(TreeNode root, StringBuilder sb){
        if(root == null){
            return;
        }

        sb.append(root.val);
        if(!isLeaf(root)){
            dfsHelper(root.left, sb.append("("));
            sb.append(")");
        }
        if(root.right !=  null){
            dfsHelper(root.right, sb.append("("));
            sb.append(")");
        }
    }

    private boolean isLeaf(TreeNode root){
        return (root.left == null && root.right == null);
    }
}
