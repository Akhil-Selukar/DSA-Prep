package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int end = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(end < n){
            int num = nums[end];

            map.put(num, map.getOrDefault(num, 0)+1);

            if(map.get(num) > k){
                while(map.containsKey(num) && map.get(num) > k){
                    int startNum = nums[start];
                    map.put(startNum, map.getOrDefault(startNum, 0)-1);

                    if(map.get(startNum) <= 0){
                        map.remove(startNum);
                    }
                    start++;
                }
            }
            result = Math.max(result, end-start+1);
            end++;
        }

        return result;
    }
}
