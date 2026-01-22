package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // O(N^3)/O(N)
    public int minimumPairRemoval(int[] nums) {
        int count = 0;
        List<Integer> list = new ArrayList<>();

        for(int num:nums){
            list.add(num);
        }

        while(!isSorted(list)){     // O(N) -> isSorted() is traversing entire list
            int minIndex = -1;
            int minSum = Integer.MAX_VALUE;

            for(int i=1; i<list.size(); i++){       // O(N)
                int currSum = list.get(i-1) + list.get(i);
                if(currSum < minSum){
                    minSum = currSum;
                    minIndex = i-1;
                }
            }

            if(minIndex != -1){
                list.remove(minIndex+1);        // O(N) -> involve shifting
                list.set(minIndex, minSum);
                count++;
            }
        }
        return count;
    }

    private boolean isSorted(List<Integer> list){
        for(int i=1; i<list.size(); i++){
            if(list.get(i-1) > list.get(i)){
                return false;
            }
        }
        return true;
    }
}
