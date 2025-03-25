package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> preOrder = new HashMap<>();
        preOrder.put(0L, 1);         // to get 0 sum we have 1 way i.e. no node to select.

        helper(root, targetSum, 0, preOrder);
        return count;
    }

    private void helper(TreeNode root, int target, long currentSum, Map<Long, Integer> preOrder){
        if(root == null){
            return;
        }

        currentSum = currentSum + root.val;         // consider current node in sum.

        if(preOrder.containsKey(currentSum - target)){          // if this condition is satisfied, we found the target sum
            count = count + preOrder.get(currentSum - target);
        }

        // update value in map
        preOrder.put(currentSum, preOrder.getOrDefault(currentSum, 0)+1);

        // explore left and right tree of current node
        helper(root.left, target, currentSum, preOrder);
        helper(root.right, target, currentSum, preOrder);

        // while going back need to ensure we don't have any way to form current sum (as we are going back from current node
        // hence there will not be any way we can get the value of current node in above tree paths.

        preOrder.put(currentSum, preOrder.get(currentSum)-1);
    }
}
