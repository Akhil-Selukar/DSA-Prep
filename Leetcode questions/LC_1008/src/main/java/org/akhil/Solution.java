package org.akhil;

public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return generateTree(preorder, 0, preorder.length-1);
    }

    private TreeNode generateTree(int[] preorder, int start, int end) {
        if(start > end){
            return null;
        }

        int rootVal = preorder[start];
        int splitIndex = getIndex(preorder, start, end);

        TreeNode root = new TreeNode(rootVal);

        root.left = generateTree(preorder, start+1, splitIndex);
        root.right = generateTree(preorder, splitIndex+1, end);

        return root;
    }

    private int getIndex(int[] pre, int start, int end){
        int val = pre[start];
        for(int i=start; i<=end; i++){
            if(pre[i] > val){
                return i-1;
            }
        }
        return end;
    }
}
