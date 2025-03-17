package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - using Map (O(N)/O(N))
//    public boolean divideArray(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for(int num:nums){
//            map.put(num, map.getOrDefault(num, 0)+1);
//        }
//
//        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
//            if(entry.getValue() % 2 !=0){
//                return false;
//            }
//        }
//
//        return true;
//    }

    // Solution 2 - Using frequency array (O(N)/O(1))

    public boolean divideArray(int[] nums) {
        int[] arr = new int[501];

        for(int num:nums){
            arr[num]++;
        }

        for(int num:arr){
            if(num % 2 !=0){
                return false;
            }
        }

        return true;
    }
}
