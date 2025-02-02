package org.akhil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - (O(N)/O(N))
//    public int[] singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int[] ans = new int[2];
//
//        for(int num:nums){
//            map.put(num, map.getOrDefault(num,0)+1);
//        }
//
//        int i=0;
//        for(Map.Entry entry: map.entrySet()){
//            if((int)entry.getValue() == 1){
//                ans[i++] = (int)entry.getKey();
//            }
//        }
//        return ans;
//    }

    // Solution 2 - using bit manipulation
    /*
     * Here in this example we have two numbers without pair, hence if we do XOR of all numbers then all pairs will be cancel out and we will get XOR of two unique numbers.
     * Now to separate these numbers - we know that XOR gives 1 if the bits are different hence rightmost 1 in resultant XOR of above step will be the first different bit in two unique numbers.
     * Hence if we identified the rightmost bit and separate numbers based on that bit and then do the XOR of two groups then we will have unique element in each group (i.e. two uniques will be separated)
     *
     * To find the rightmost set bit we can use & operation (num & -num)
     */
    public int[] singleNumber(int[] nums) {

        // step 1 - XOR all numbers
        int xorResult = 0;
        for(int num:nums){
            xorResult = xorResult ^ num;
        }

        // step 2 - Find rightmost set bit
        int rightSetBit = (xorResult & -xorResult);

        // step 3 - separate and XOR nums based on rightSetBit.
        int[] ans = new int[2];
        for(int num:nums){
            if((num & rightSetBit) == 0){
                ans[0] = ans[0] ^ num;
            } else {
                ans[1] = ans[1] ^ num;
            }
        }
        return ans;
    }
}
