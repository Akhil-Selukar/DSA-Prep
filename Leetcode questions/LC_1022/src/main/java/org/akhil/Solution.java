package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Solution 1 - O(N*H) in worst case O(N^2)/O(N) to O(NlogN) based on structure of tree.
//    List<List<Integer>> blist = new ArrayList<>();
//    public int sumRootToLeaf(TreeNode root) {
//        dfs(root, new ArrayList<Integer>());
//
//        int sum = 0;
//        for(List<Integer> binary:blist){
//            sum = sum + convertToDecimal(binary);
//        }
//
//        return sum;
//    }
//
//    private void dfs(TreeNode root, List<Integer> temp){
//        if(root == null){
//            return;
//        }
//
//        temp.add(root.val);
//        if (root.left == null && root.right == null) {
//            blist.add(new ArrayList<>(temp));
//        } else {
//            dfs(root.left, temp);
//            dfs(root.right, temp);
//        }
//        temp.remove(temp.size()-1);
//    }
//
//    private int convertToDecimal(List<Integer> binary){
//        int index = binary.size()-1;
//        int decimal = 0;
//        for(int bit:binary){
//            decimal = decimal + (bit * (int)Math.pow(2, index--));
//        }
//        return decimal;
//    }


    // Solution 2 a bit optimized. space complexity is improved here as we are not storing the binary forms.
//    int sum = 0;
//    public int sumRootToLeaf(TreeNode root) {
//        dfs(root, new ArrayList<Integer>());
//
//        return sum;
//    }
//
//    private void dfs(TreeNode root, List<Integer> temp){
//        if(root == null){
//            return;
//        }
//
//        temp.add(root.val);
//        if (root.left == null && root.right == null) {
//            sum = sum + convertToDecimal(temp);
//        } else {
//            dfs(root.left, temp);
//            dfs(root.right, temp);
//        }
//        temp.remove(temp.size()-1);
//    }
//
//    private int convertToDecimal(List<Integer> binary){
//        int index = binary.size()-1;
//        int decimal = 0;
//        for(int bit:binary){
//            decimal = decimal + (bit * (int)Math.pow(2, index--));
//        }
//        return decimal;
//    }


    // Solution 3 - O(N)/O(N) or O(logN)
    // If we observe carefully from top to bottom every time we shift level the decimal value is getting doubled and the
    // bit at current node is getting added to it. This we can use to get answer in linear time without using any extra space (except recursive stack)

    public int sumRootToLeaf(TreeNode root) {

        return dfsHelper(root, 0);
    }

    private int dfsHelper(TreeNode root, int sum){
        if(root == null){
            return 0;
        }

        sum = sum * 2 + root.val;

        if(root.left == null && root.right == null){
            return sum;
        }

        int leftSum = dfsHelper(root.left, sum);
        int rightSum = dfsHelper(root.right, sum);

        return leftSum + rightSum;
    }

}
