package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // O(N)/O(N)
    List<Integer> list = new ArrayList();
    public int minDiffInBST(TreeNode root) {
        if(root == null){
            return 0;
        }

        int minDifference = Integer.MAX_VALUE;
        dfs(root);

        for(int i=0; i<list.size()-1; i++){
            minDifference = Math.min(minDifference, list.get(i+1)-list.get(i));
        }

        return (minDifference == Integer.MAX_VALUE) ? list.get(0) : minDifference;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }

        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
