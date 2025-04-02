package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(k == 0){
            ans.add(target.val);
            return ans;
        }
        dfsHelper(root, target, k, 0);
        return ans;
    }

    private int dfsHelper(TreeNode root, TreeNode target, int k, int depth){
        if(root == null){
            return 0;
        }

        // element found at given the depth
        if(depth == k){
            ans.add(root.val);
            return 0;
        }

        if(target == root || depth > 0){            // add nodes from subtree of target
            dfsHelper(root.left, target, k, depth+1);
            dfsHelper(root.right, target, k, depth+1);
        } else {
            // add node from remaining tree
            int left = dfsHelper(root.left, target, k, depth);
            int right = dfsHelper(root.right, target, k, depth);

            if(left == k || right == k){
                ans.add(root.val);
                return 0;
            } else if(left > 0){        // need to traverse right tree
                dfsHelper(root.right, target, k, left + 1);
                return left + 1;
            } else if(right > 0){       // need to traverse left tree
                dfsHelper(root.left, target, k, right + 1);
                return right + 1;
            }
        }

        if(target == root){
            return 1;
        }

        return 0;
    }
}
