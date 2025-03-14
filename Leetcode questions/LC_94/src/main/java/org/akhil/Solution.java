package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        inOrderHelper(root, ans);
        return ans;
    }

    private void inOrderHelper(TreeNode node, List<Integer> ans){
        if(node == null){
            return;
        }

        inOrderHelper(node.left, ans);
        ans.add(node.val);
        inOrderHelper(node.right, ans);
    }
}
