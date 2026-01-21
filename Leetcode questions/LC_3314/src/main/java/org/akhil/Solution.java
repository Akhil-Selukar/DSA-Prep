package org.akhil;

import java.util.List;

public class Solution {

    // Solution 1 - bruteforce
    // O(N*max(nums))/O(N)
//    public int[] minBitwiseArray(List<Integer> nums) {
//        int n = nums.size();
//
//        int[] result = new int[n];
//
//        for(int i=0; i<n; i++){
//            int target = nums.get(i);
//            // As we are dealing with num and num+1, hence one of those two will always be odd number and in binary representation
//            // All odd numbers have 1 as the last digit. Now if we do OR operation of anything with 1 it is going to give 1 always
//            // Hence if the target is even number then it is impossible to get any number (ans) such that ans | (ans+1) = target
//
//            if(target%2 == 0){
//                result[i] = -1;
//                continue;
//            }
//            boolean flag = false;
//            for(int j=1; j<target; j++){
//                if((j | (j+1)) == target){
//                    result[i] = j;
//                    flag = true;
//                    break;
//                }
//            }
//            if(!flag){
//                result[i] = -1;
//            }
//        }
//
//        return result;
//    }

    // --------------------
    // Solution 2 - Optimized using bitwise operators
    // O(N)/O(N)
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();

        int[] result = new int[n];

        for(int i=0; i<n; i++){
            int target = nums.get(i);
            // As we are dealing with num and num+1, hence one of those two will always be odd number and in binary representation
            // All odd numbers have 1 as the last digit. Now if we do OR operation of anything with 1 it is going to give 1 always
            // Hence if the target is even number then it is impossible to get any number (ans) such that ans | (ans+1) = target

            if(target%2 == 0){
                result[i] = -1;
                continue;
            }
            boolean flag = false;
            for(int j=0; j<32; j++){
                // When we add 1 to any binary number that 1 either gets added to the last place (if last place in original number is 0)
                // Otherwise it gets shifted to left till it finds 0. This is what we are going to do to find value of and+1

                // if jth bit in target is 1 then we can skip
                if((target & (1<<j)) != 0){
                    continue;
                }

                // first 0 bit in target is at jth position
                // So we just have to flip the bit to get (ans+1) but we want ans so we need to flip (j-1)th bit
                result[i] = target ^ (1<<(j-1));
                flag = true;
                break;
            }
            if(!flag){
                result[i] = -1;
            }
        }

        return result;
    }
}
