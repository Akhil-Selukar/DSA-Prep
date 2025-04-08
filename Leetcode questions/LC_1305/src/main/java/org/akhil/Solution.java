package org.akhil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    // O((N+M) log(N+M))/O(N+M) where N and M are number of elements in tree1 and tree2 respectively.
    List<Integer> values = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        dfs(root1);
        dfs(root2);

        Collections.sort(values);
        return values;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }

        values.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
