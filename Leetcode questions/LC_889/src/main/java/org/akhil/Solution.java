package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Solution 1 - O(N)/O(N)
    Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        for(int i=0; i<n; i++){
            indexMap.put(postorder[i], i);
        }

        return construct(preorder, postorder, 0, n-1, 0, n-1);
    }

    private TreeNode construct(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd) {
        if(preStart > preEnd || postStart > postEnd){
            return null;
        }

        int rootElement = preorder[preStart];
        TreeNode root = new TreeNode(rootElement);

        if(preStart == preEnd){
            return root;
        }

        int leftElement = preorder[preStart+1];
        int indexOfLeft = indexMap.get(leftElement);
        int leftLength = indexOfLeft - postStart + 1;

        root.left = construct(preorder, postorder, preStart+1, preStart+leftLength, postStart, indexOfLeft);
        root.right = construct(preorder, postorder, preStart+leftLength+1, preEnd, indexOfLeft+1, postEnd-1);

        return root;
    }
}
