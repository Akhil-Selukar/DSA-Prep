package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Solution 1 - Using Set;
    // O(N)/O(N)
//    public int maxSum(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//
//        int sum = 0;
//        int max = Integer.MIN_VALUE;
//        boolean hasPositive = false;
//
//        for(int num:nums){
//            if(num >= 0 && !set.contains(num)){
//                sum = sum + num;
//                set.add(num);
//                hasPositive = true;
//            }
//
//            max = Math.max(max, num);
//        }
//
//        if(hasPositive){
//            return sum;
//        }
//        return max;
//    }

    // Solution 2 - without hashSet
    // O(N)/O(1)

    public int maxSum(int[] nums) {
        boolean[] visited = new boolean[101];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        boolean hasPositive = false;

        for(int num:nums){
            if(num >= 0 && !visited[num]){
                sum = sum + num;
                visited[num] = true;
                hasPositive = true;
            }

            max = Math.max(max, num);
        }

        if(hasPositive){
            return sum;
        }
        return max;
    }
}
