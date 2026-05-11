package org.akhil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    // // Solution 1 - using another function to convert number to digits and reverse the digits
    // // O(N*L)/O(N*L) where N is number of values in nums and L is length of each value
    // public int[] separateDigits(int[] nums) {
    //     List<Integer> list = new ArrayList<>();

    //     for(int num:nums){
    //         list.addAll(getDigits(num));
    //     }

    //     int[] result = new int[list.size()];

    //     for(int i=0; i<list.size(); i++){
    //         result[i] = list.get(i);
    //     }

    //     return result;
    // }

    // private List getDigits(int num){
    //     List<Integer> digits = new ArrayList();

    //     while(num > 0){
    //         digits.add(num%10);
    //         num = num/10;
    //     }

    //     Collections.reverse(digits);
    //     return digits;
    // }


    // --------------------
    // Solution 2 - Using string representation of number
    // O(N*L)/O(N*L) where N is number of values in nums and L is length of each value
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int num:nums){
            for(char ch:Integer.toString(num).toCharArray()){   // will automatically give digits in correct order (no need to reverse)
                list.add(ch-'0');   // convert char to number
            }
        }

        int[] result = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }
}
