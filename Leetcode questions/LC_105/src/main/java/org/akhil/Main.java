package org.akhil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        buildTree1(preorder, inorder);
    }


    //  Solution 1 - O(N)/O(N)
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

    // Solution 2 - O(N)/O(N)  here time and space complexity is same but still this will be a better approach as we are reducing many executions of loops.

    static Map<Integer, Integer> map = new HashMap();      // to store index of inorder elements.
    static int preorderIndex = 0;
    public static TreeNode buildTree1(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildHelper(preorder, 0, inorder.length-1);
    }

    private static TreeNode buildHelper(int[] preorder, int startIndex, int endIndex) {
        if(startIndex > endIndex){
            return null;
        }

        int rootVal = preorder[preorderIndex];
        preorderIndex++;
        int rootIndex = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        root.left=buildHelper(preorder, startIndex, rootIndex-1);
        root.right= buildHelper(preorder, rootIndex+1,endIndex);

        return root;
    }
}