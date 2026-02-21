package org.akhil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Solution 1 - bruteforce
    // O((right-left)*log(right))/O(1)
//    public int countPrimeSetBits(int left, int right) {
//        int count = 0;
//        for(int i=left; i<=right; i++){
//            int bitCount = Integer.bitCount(i);
//
//            if(isPrime(bitCount)){
//                count++;
//            }
//        }
//
//        return count;
//    }
//
//    private boolean isPrime(int num){
//        if(num <= 1){
//            return false;
//        }
//        for(int i=2; i<=Math.sqrt(num); i++){
//            if(num%i == 0){
//                return false;
//            }
//        }
//
//        return true;
//    }

    // ---------------------
    // Solution 2 - Slightly optimized
    // If we observe the question carefully we are converting int to binary and then counting the set bit's,
    // After that we need to check the **set-bit count** is prime or not. Here set-bit count is important.
    // We know that there are at max 32 bits in an integer so the set bit can be at max 32.
    // so we can be sure that we need to check for only prime numbers less than or equal to 32.
    // by this we can remove isPrime function and repeated loop used in it.

    // O((right-left)*32)/O(1)
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        Set<Integer> primes = new HashSet<>();
        primes.addAll(Arrays.asList(2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 31));

        for(int i=left; i<=right; i++){
            int bitCount = Integer.bitCount(i);

            if(primes.contains(bitCount)){
                count++;
            }
        }

        return count;
    }
}
