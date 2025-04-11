package org.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // Solution 1 - bruteforce (TLE)
    // O(N*H)/O(H) where H is height of the tree.
//    int count = 0;
//    public int pseudoPalindromicPaths (TreeNode root) {
//        dfs(root, new ArrayList<Integer>());
//        return count;
//    }
//
//    private void dfs(TreeNode root, List<Integer> path){
//        if(root == null){
//            return;
//        }
//
//        path.add(root.val);
//        if(root.left == null && root.right == null){
//            // System.out.println(path);
//            if (checkPseudoPalindromic(path)){
//                count++;
//            }
//            path.remove(path.size()-1);
//            return;
//        }
//
//        dfs(root.left, path);
//        dfs(root.right, path);
//        path.remove(path.size()-1);
//
//    }
//
//    private boolean checkPseudoPalindromic(List<Integer> path){
//        int[] nums = new int[10];
//        for(int i=0; i<path.size(); i++){
//            nums[path.get(i)]++;
//        }
//
//        int oddCount = 0;
//        for(int num:nums){
//            if(num%2 != 0){
//                oddCount++;
//            }
//        }
//
//        return (oddCount<2);
//    }

    // Solution 2 - using map<>
    // complexities are same but still this one is a bit faster as we have eliminated some calculations.
//    int count = 0;
//    public int pseudoPalindromicPaths (TreeNode root) {
//        dfs(root, new HashMap<Integer, Integer>());
//        return count;
//    }
//
//    private void dfs(TreeNode root, Map<Integer, Integer> freq){
//        if(root == null){
//            return;
//        }
//
//        freq.put(root.val, freq.getOrDefault(root.val, 0)+1);
//        if(root.left == null && root.right == null){
//            // System.out.println(path);
//            int oddCount = 0;
//            for(int val : freq.values()){
//                if(val%2 == 1){
//                    oddCount++;
//                }
//            }
//            if(oddCount<2){
//                count++;
//            }
//        }
//
//        dfs(root.left, freq);
//        dfs(root.right, freq);
//        freq.put(root.val, freq.get(root.val)-1);
//
//    }

    // Solution 3 - using bit manipulation (check editorial for explanation and do a dry-run)
    // O(N)/O(H) where H is height of binary tree
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, 0);
        return count;
    }

    private void dfs(TreeNode root, int path){
        if(root == null){
            return;
        }

        path = path ^ (1 << root.val);
        if(root.left == null && root.right == null){
            if((path & (path-1)) == 0){
                count++;
            }
        }

        dfs(root.left, path);
        dfs(root.right, path);
    }
}
