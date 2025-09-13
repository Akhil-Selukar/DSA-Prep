package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {
//    int count = 0;
//    public int pathSum(TreeNode root, int targetSum) {
//        Map<Long, Integer> preOrder = new HashMap<>();
//        preOrder.put(0L, 1);         // to get 0 sum we have 1 way i.e. no node to select.
//
//        helper(root, targetSum, 0, preOrder);
//        return count;
//    }
//
//    private void helper(TreeNode root, int target, long currentSum, Map<Long, Integer> preOrder){
//        if(root == null){
//            return;
//        }
//
//        currentSum = currentSum + root.val;         // consider current node in sum.
//
//        if(preOrder.containsKey(currentSum - target)){          // if this condition is satisfied, we found the target sum
//            count = count + preOrder.get(currentSum - target);
//        }
//
//        // update value in map
//        preOrder.put(currentSum, preOrder.getOrDefault(currentSum, 0)+1);
//
//        // explore left and right tree of current node
//        helper(root.left, target, currentSum, preOrder);
//        helper(root.right, target, currentSum, preOrder);
//
//        // while going back need to ensure we don't have any way to form current sum (as we are going back from current node
//        // hence there will not be any way we can get the value of current node in above tree paths.
//
//        preOrder.put(currentSum, preOrder.get(currentSum)-1);
//    }


    // --------------------------
    // Solution 2 - Not optimized but more intuitive
    // O(N^2)/O(H) where H is height of the tree (in worst case N and in best case logN)
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        count = count + helper(root, targetSum);

        count = count + pathSum(root.left, targetSum);
        count = count + pathSum(root.right, targetSum);

        return count;
    }

    private int helper(TreeNode root, long target) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root.val == target) {
            count++;        // dont return from here because if lets say target is 4 and first path is 1-2-1, then there can be another path further like 1-2-1-4-(-4)
        }

        // explore left path
        count = count + helper(root.left, target - root.val);

        // explore right path
        count = count + helper(root.right, target - root.val);
        return count;
    }

}
