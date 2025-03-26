package org.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // O(N)/O(N)
    Map<Integer, Integer> freq = new HashMap<>();
    List<Integer> tempList = new ArrayList<>();
    int maxFrequency = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfsHelper(root);

        int[] result = new int[tempList.size()];
        for(int i=0; i< tempList.size(); i++){
            result[i] = tempList.get(i);
        }

        return result;
    }

    private int dfsHelper(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSum = dfsHelper(root.left);
        int rightSum = dfsHelper(root.right);

        int totalSumAtNode = leftSum + rightSum + root.val;
        freq.put(totalSumAtNode, freq.getOrDefault(totalSumAtNode, 0)+1);

        if(maxFrequency == freq.get(totalSumAtNode)){
            tempList.add(totalSumAtNode);
        } else if(maxFrequency < freq.get(totalSumAtNode)){
            tempList.clear();
            tempList.add(totalSumAtNode);
        }
        maxFrequency = Math.max(maxFrequency, freq.get(totalSumAtNode));

        return totalSumAtNode;
    }
}
