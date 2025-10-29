package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution 1 - bruteforce
    // O(logN)/O(logN)
//    public int smallestNumber(int n) {
//        List<Integer> list = new ArrayList<>();
//
//        while(n>0){
//            list.add(n%2);
//            n=n/2;
//        }
//
//        int result = 0;
//        for(int i=0; i<list.size(); i++){
//            result = result + (int)Math.pow(2,i);
//        }
//
//        return result;
//    }

    // Solution 2 - Improved space complexity in solution 1
    // O(logN)/O(1)
    public int smallestNumber(int n) {
        int count = 0;

        while(n>0){
            count++;
            n=n/2;
        }

        int result = 0;
        for(int i=0; i<count; i++){
            result = result + (int)Math.pow(2,i);
        }

        return result;
    }


    // The process here is we first need to find the smallest number greater than n which can be represented by only 1 bit.
    // then we need to unset the only set bit and set all other unset bits to left. This can be done by subtracting 1 from that number
//    public int smallestNumber(int n) {
//
//        for(int i=0; i<n; i++){
//            int nextPerfect = 1<<i;
//
//            if(nextPerfect > n){
//                return nextPerfect-1;
//            }
//        }
//        return 0;
//    }
}
