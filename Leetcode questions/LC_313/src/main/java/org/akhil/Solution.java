package org.akhil;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Solution {

    // Solution 1 - Using TreeSet (TLE)
    // TC -> O(NPLogM) where p is length of primes and M is size of set.
    // SC -> O(M) where M is size of set.
//    public int nthSuperUglyNumber(int n, int[] primes) {
//        if(n==1){
//            return 1;
//        }
//
//        TreeSet<Long> set = new TreeSet<>();
//        set.add(1L);
//        n--;
//
//        while(n>0){
//            long currNo = set.pollFirst();
//
//            for(int prime:primes){
//                set.add(currNo * prime);
//            }
//
//            n--;
//        }
//        long ans = set.pollFirst();
//        return (int) ans;
//    }


    // Solution 2 - Using array and logical observations
    // TC -> O(N*M) where M = primes.length;
    // SC -> O(N+M)
    public int nthSuperUglyNumber(int n, int[] primes) {
        int length = primes.length;

        int[] pointers = new int[length];
        Arrays.fill(pointers, 1);

        int[] uglyNumbers = new int[n+1];       // as we want nth number and we know that 1st super ugly number is 1 (given), hence we will start from index 1 and skip index 0 hence n+1.
        uglyNumbers[1] = 1;

        for(int i=2; i<=n; i++){        // i=1 is already filled uglyNumbers[1] = 1; ans we are skipping 0th index
            long nextUglyNum = Long.MAX_VALUE;
            for(int j=0; j<length; j++){
                long product = (long)primes[j] * uglyNumbers[pointers[j]];      // calculate product before Math.min() to avoid integer overflow.
                nextUglyNum = Math.min(nextUglyNum, product);
            }

            uglyNumbers[i] = (int)nextUglyNum;

            for(int j=0; j<length; j++){
                if(nextUglyNum == (long) primes[j] *uglyNumbers[pointers[j]]){
                    pointers[j]++;
                }
            }
        }

        return uglyNumbers[n];
    }
}
