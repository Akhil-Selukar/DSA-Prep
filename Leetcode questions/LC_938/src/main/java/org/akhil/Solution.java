package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution 1 - using inorder traversal O(N)/O(N)
//    List<Integer> list = new ArrayList<>();
//    public int rangeSumBST(TreeNode root, int low, int high) {
//        inorder(root);
//
//        int sum = 0;
//        for(int i=0; i<list.size(); i++){
//            if(list.get(i) >= low && high >= list.get(i)){
//                sum += list.get(i);
//            }
//        }
//
//        return sum;
//    }
//
//    private void inorder(TreeNode root){
//        if(root == null){
//            return;
//        }
//
//        inorder(root.left);
//        list.add(root.val);
//        inorder(root.right);
//    }

    // Solution 2 - eliminating list (O(N)/O(logN)
//    int sum = 0;
//    public int rangeSumBST(TreeNode root, int low, int high) {
//        inorder(root, low, high);
//
//        return sum;
//    }
//
//    private void inorder(TreeNode root, int low, int high){
//        if(root == null){
//            return;
//        }
//
//        sum = sum + ((root.val >= low && root.val <= high) ? root.val : 0);
//        inorder(root.left, low, high);
//        inorder(root.right, low, high);
//    }

    // Solution 3 - Above solution can be more optimized further by using BST property.
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root, low, high);

        return sum;
    }

    private void inorder(TreeNode root, int low, int high){
        if(root == null){
            return;
        }

        sum = sum + ((root.val >= low && root.val <= high) ? root.val : 0);
        if(!(root.val < low)) {
            inorder(root.left, low, high);
        }

        if(!(root.val > high)){
            inorder(root.right, low, high);
        }
    }
}
