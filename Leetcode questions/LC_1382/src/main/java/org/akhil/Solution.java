package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // O(N)/O(N)
    List<TreeNode> sorted = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);

        return listToBST(0, sorted.size()-1);
    }

    private TreeNode listToBST(int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end-start)/2;

        TreeNode root = sorted.get(mid);
        root.left = listToBST(start, mid-1);
        root.right = listToBST(mid+1, end);

        return root;
    }

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        sorted.add(root);
        inorder(root.right);
    }
}
