package org.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // Solution 1 - O(N)/O(N)
//    int maxCount = 0;
//    public int[] findMode(TreeNode root) {
//        Map<Integer, Integer> count = new HashMap<>();
//        List<Integer> mode = new ArrayList<>();
//
//        inOrder(root, count, mode);
//
//        int[] answer = new int[mode.size()];
//        for(int i=0; i<mode.size(); i++){
//            answer[i] = mode.get(i);
//        }
//
//        return answer;
//    }
//
//    private void inOrder(TreeNode root, Map<Integer, Integer> count, List<Integer> mode){
//        if(root == null){
//            return;
//        }
//
//        inOrder(root.left, count, mode);
//
//        int currentCount = count.getOrDefault(root.val, 0)+1;
//        count.put(root.val, currentCount);
//
//        if(currentCount > maxCount){
//            mode.clear();
//            maxCount = currentCount;
//            mode.add(root.val);
//        } else if(currentCount == maxCount) {
//            mode.add(root.val);
//        }
//
//        inOrder(root.right, count, mode);
//    }

    // Solution 2 -
    int maxCount = 0;
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> mode = new ArrayList<>();

        inOrder(root, count, mode);

        int[] answer = new int[mode.size()];
        for(int i=0; i<mode.size(); i++){
            answer[i] = mode.get(i);
        }

        return answer;
    }

    private void inOrder(TreeNode root, Map<Integer, Integer> count, List<Integer> mode){
        if(root == null){
            return;
        }

        inOrder(root.left, count, mode);

        int currentCount = count.getOrDefault(root.val, 0)+1;
        count.put(root.val, currentCount);

        if(currentCount > maxCount){
            mode.clear();
            maxCount = currentCount;
            mode.add(root.val);
        } else if(currentCount == maxCount) {
            mode.add(root.val);
        }

        inOrder(root.right, count, mode);
    }
}
