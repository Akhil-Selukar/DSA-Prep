package org.akhil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    List<Integer> list = new ArrayList<>();
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);

        Collections.sort(list);
        for(int i=1; i<list.size(); i++){
            if(list.get(i-1) < list.get(i)){
                return list.get(i);
            }
        }
        return -1;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }

        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
