package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        buildTree(preorder, inorder);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }

        int rootNodeVal = preorder[0];

        int rootIndex = 0;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == rootNodeVal){
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootNodeVal);

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex+1), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, rootIndex+1, preorder.length), Arrays.copyOfRange(inorder, rootIndex+1, inorder.length));

        return root;
    }
}