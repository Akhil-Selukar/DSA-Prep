package org.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // O(N)/O(N)
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();

        serializeHelper(root, map);

        for(List<TreeNode> list:map.values()){
            if(list.size()>1){
                ans.add(list.get(0));
            }
        }
        return ans;
    }

    private String serializeHelper(TreeNode root, Map<String, List<TreeNode>> map) {
        if(root == null){
            return "";
        }

        String leftNodes = serializeHelper(root.left, map);
        String rightNodes = serializeHelper(root.right, map);

        String str = "(" + leftNodes + root.val + rightNodes + ")";

        if(!map.containsKey(str)){
            map.put(str, new ArrayList<TreeNode>());
        }
        map.get(str).add(root);
        return str;
    }
}
