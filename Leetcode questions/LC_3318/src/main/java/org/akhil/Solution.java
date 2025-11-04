package org.akhil;

import java.util.*;

public class Solution {

    // O(KlogK * (n-k+1)) // O(K)
    public int[] findXSum(int[] nums, int k, int x) {
        Map<Integer, Integer> count = new HashMap<>();

        int n = nums.length;
        int startIndex = 0;
        int endIndex = Math.min(k, n);
        int[] result = new int[n-k+1];
        int resultIndex = 0;

        while(resultIndex < n-k+1){
            int val = nums[startIndex];
            count.put(val, count.getOrDefault(val, 0)+1);

            if(startIndex == endIndex-1){
                result[resultIndex++] = getTopXCount(count, x);
                count = new HashMap<>();
                startIndex = resultIndex;
                endIndex = Math.min(n, endIndex+1);
            } else {
                startIndex++;
            }
        }

        return result;
    }

    private int getTopXCount(Map<Integer, Integer> count, int x){
        List<int[]> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry:count.entrySet()){
            list.add(new int[]{entry.getValue(), entry.getKey()});
        }

        Collections.sort(list, (a, b)->{
            if(a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return b[1]-a[1];
            }
        });

        int result = 0;
        for(int i=0; i<Math.min(count.size(), x); i++) {
            int val = list.get(i)[1] * list.get(i)[0];
            result = result + val;
        }

        return result;
    }
}
