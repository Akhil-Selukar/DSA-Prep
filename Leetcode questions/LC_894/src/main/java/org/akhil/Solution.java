package org.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // approximately O(2^(n/2))/ O(n*2^(n/2)))
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2 == 0){
            return new ArrayList<>();
        }

        Map<Integer, List<TreeNode>> dp = new HashMap<>();
        return constructTree(n, dp);
    }

    private List<TreeNode> constructTree(int n, Map<Integer, List<TreeNode>> dp) {
        if(n == 1){
            TreeNode node = new TreeNode(0);
            List<TreeNode> list = new ArrayList<>();
            list.add(node);
            return list;
        }

        if(dp.containsKey(n)){
            return dp.get(n);
        }

        List<TreeNode> ans = new ArrayList<>();
        for(int leftNodes = 1; leftNodes < n; leftNodes = leftNodes+2){
            List<TreeNode> leftSubtree = constructTree(leftNodes, dp);
            List<TreeNode> rightSubtree = constructTree(n-leftNodes-1, dp);

            for(TreeNode left:leftSubtree){
                for(TreeNode right:rightSubtree){
                    TreeNode node = new TreeNode(0, left, right);
                    ans.add(node);
                }
            }
        }
        dp.put(n, ans);

        return ans;
    }
}