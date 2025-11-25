package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Solution 1 - Bruteforce (Will give wrong answer, not because code is incorrect but at some point num will go oob for long range, hence will start falling apart)
//    public int smallestRepunitDivByK(int k) {
//        long num = 1;
//        Set<Integer> set = new HashSet<>();
//        int remainder = 0;
//        int counter = 1;
//
//        do{
//            remainder = (int)(num % k);
//            if(set.contains(remainder)){
//                return -1;
//            }
//            set.add(remainder);
//            num = (num*10)+1;
//            counter++;
//        } while(remainder != 0);
//
//        return counter-1;
//    }


    // ---------------------
    // Solution 2 - overflow problem fixed
    // O(K)/O(K)
//    public int smallestRepunitDivByK(int k) {
//        int num = 1;
//        Set<Integer> set = new HashSet<>();
//        int remainder = 0;
//        int counter = 1;
//
//        do{
//            remainder = (num % k);
//            if(set.contains(remainder)){
//                return -1;
//            }
//            set.add(remainder);
//            num = (remainder*10)+1;
//            counter++;
//        } while(remainder != 0);
//
//        return counter-1;
//    }

    //-------------------
    // Solution 3 - Optimized
    // O(K)/O(1)
    public int smallestRepunitDivByK(int k) {
        if(k == 1){
            return 1;
        }

        // if K is multiple of 2 or 5 then it will not have any num with all 1 which is completely divisible
        if(k%2 == 0 || k%5 == 0){
            return -1;
        }

        int remainder = 0;
        for(int length=1; length<=k; length++){
            remainder = ((remainder * 10) + 1) % k;

            if(remainder == 0){
                return length;
            }
        }
        return -1;
    }
}
