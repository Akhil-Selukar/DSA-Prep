package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // run below method directly on leetcode to test it against testcases.

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }

    private boolean helper(TreeNode root, int k, Set<Integer> set) {
        if(root == null){
            return false;
        }

        if(set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);

        return helper(root.left, k, set) || helper(root.right, k, set);
    }


}