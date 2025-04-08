package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class FindElements {
    // Solution 1 - bruteforce
//    TreeNode root = null;
//    // O(N)/O(N) or O(logN)
//    public FindElements(TreeNode root) {
//        this.root = root;
//
//        recover(root, 0);
//    }
//
//    private void recover(TreeNode root, int x){
//        if(root == null){
//            return;
//        }
//
//        root.val = x;
//        recover(root.left, (2*x)+1);
//        recover(root.right, (2*x)+2);
//    }
//
//    // O(N)/O(1)
//    public boolean find(int target) {
//        return dfs(this.root, target);
//    }
//
//    private boolean dfs(TreeNode root, int target){
//        if(root == null){
//            return false;
//        }
//
//        if(root.val == target){
//            return true;
//        }
//
//        return dfs(root.left, target) || dfs(root.right, target);
//    }

    // Solution 2
    TreeNode root = null;
    Set<Integer> vals = new HashSet<>();
    // O(N)/O(N)
    public FindElements(TreeNode root) {
        this.root = root;

        recover(root, 0);
    }

    private void recover(TreeNode root, int x){
        if(root == null){
            return;
        }

        root.val = x;
        vals.add(root.val);
        recover(root.left, (2*x)+1);
        recover(root.right, (2*x)+2);
    }

    // O(1)/O(1)
    public boolean find(int target) {
        return vals.contains(target);
    }
}
