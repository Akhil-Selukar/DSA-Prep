package org.akhil;

import java.util.List;

public class Solution {
    // Solution 1 - Bruteforce (TLE)
    // O(N*max(nums))/O(N)
    // public int[] minBitwiseArray(List<Integer> nums) {
    //     int n = nums.size();
    //     int[] result = new int[n];

    //     for(int i=0; i<n; i++){
    //         int target = nums.get(i);
    //         if((target % 2) == 0){
    //             result[i] = -1;
    //             continue;
    //         }

    //         boolean found = false;
    //         for(int j=0; j<target; j++){
    //             if((j | (j+1)) == target){
    //                 result[i] = j;
    //                 found = true;
    //                 break;
    //             }
    //         }

    //         if(!found){
    //             result[i] = -1;
    //         }
    //     }

    //     return result;
    // }

    // ---------------

    // Solution 2 - Optimized (using bit manipulation and finding 1st unset bit in target)
    // O(N)/O(N)
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];

        for(int i=0; i<n; i++){
            int target = nums.get(i);

            if((target % 2) == 0){
                result[i] = -1;
                continue;
            }

            for(int j=0; j<32; j++){

                // continue in case of jth bit in target is set
                if((target & (1<<j)) != 0){
                    continue;
                }

                // if jth bit in target is unset then flip the (j-1)th bit
                result[i] = (target ^ (1<<(j-1)));
                break;
            }

        }

        return result;
    }
}
