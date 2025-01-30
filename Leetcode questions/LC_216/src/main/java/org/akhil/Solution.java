package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int target) {
        helper(k, target, 1, new ArrayList<Integer>());
        return answer;
    }

    private void helper(int k, int target, int index, ArrayList<Integer> temp) {
        if(k==0 && target == 0){
            answer.add(new ArrayList<>(temp));
            return;
        }
        if(k == 0 && target > 0){
            return;
        }

        for(int i=index; i<=Math.min(target, 9); i++){
            temp.add(i);
            helper(k-1, target-i, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}
