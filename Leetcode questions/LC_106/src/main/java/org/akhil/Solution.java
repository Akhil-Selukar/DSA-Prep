package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - (O(N^2)/O(N))
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        int inStart = 0;
//        int inEnd = inorder.length-1;
//        int postStart = 0;
//        int postEnd = postorder.length-1;
//
//        return buildHelper(inorder, inStart, inEnd, postorder, postStart, postEnd);
//    }
//
//    private TreeNode buildHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
//        if(inStart > inEnd || postStart > postEnd){
//            return null;
//        }
//
//        int nodeVal = postorder[postEnd];
//        int nodeIndex = 0;
//
//        for(int i=0; i<inorder.length; i++){
//            if(inorder[i] == nodeVal){
//                nodeIndex = i;
//                break;
//            }
//        }
//
//        TreeNode node = new TreeNode(nodeVal);
//
//        node.left = buildHelper(inorder, inStart, nodeIndex-1, postorder, postStart, postStart+nodeIndex-inStart-1);
//        node.right = buildHelper(inorder, nodeIndex+1, inorder.length-1, postorder, postStart+nodeIndex-inStart, postEnd-1);
//
//        return node;
//    }


    // Solution 1.1 - O(N)/O(N) - Slight change in index finding but improve time a lot.
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        int inStart = 0;
//        int inEnd = inorder.length-1;
//        int postStart = 0;
//        int postEnd = postorder.length-1;
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for(int i=0; i<inorder.length; i++){
//            map.put(inorder[i], i);
//        }
//        return buildHelper(inorder, inStart, inEnd, postorder, postStart, postEnd, map);
//    }
//
//    private TreeNode buildHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map){
//        if(inStart > inEnd || postStart > postEnd){
//            return null;
//        }
//
//        int nodeVal = postorder[postEnd];
//        int nodeIndex = map.get(nodeVal);
//
//        TreeNode node = new TreeNode(nodeVal);
//
//        node.left = buildHelper(inorder, inStart, nodeIndex-1, postorder, postStart, postStart+nodeIndex-inStart-1, map);
//        node.right = buildHelper(inorder, nodeIndex+1, inorder.length-1, postorder, postStart+nodeIndex-inStart, postEnd-1, map);
//
//        return node;
//    }

    // Same solution as that of above but a bit simple (in terms of finding the range)
    /**
     *     public TreeNode buildTree(int[] inorder, int[] postorder) {
     *         HashMap<Integer, Integer> map = new HashMap<>();
     *         for (int i = 0; i < inorder.length; i++) {
     *             map.put(inorder[i], i);
     *         }
     *         return fun(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
     *     }
     *
     *     public TreeNode fun(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> map) {
     *         if (inStart > inEnd || postStart > postEnd) {
     *             return null;
     *         }
     *         TreeNode root = new TreeNode(postorder[postEnd]);
     *         int rootIndex = map.get(root.val);
     *         int leftTreeSize = rootIndex - inStart;
     *
     *         root.left = fun(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftTreeSize - 1, map);
     *         root.right = fun(inorder, rootIndex + 1, inEnd, postorder, postStart + leftTreeSize, postEnd - 1, map);
     *         return root;
     *     }
     */


    // Solution 3 - More intuitive and easy to understand.
    // O(N)/O(N)
    Map<Integer, Integer> map = new HashMap<>();
    int postorderIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length-1;

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildHelper(postorder, 0, inorder.length-1);
    }

    private TreeNode buildHelper(int[] postorder, int inorderStart, int inorderEnd){
        if(inorderStart > inorderEnd){
            return null;
        }

        int rootVal = postorder[postorderIndex--];
        int indexOfRoot = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.right = buildHelper(postorder, indexOfRoot+1, inorderEnd);
        root.left = buildHelper(postorder, inorderStart, indexOfRoot-1);

        return root;
    }
}
