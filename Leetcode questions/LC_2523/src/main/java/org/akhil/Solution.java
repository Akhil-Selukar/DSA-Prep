package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // Solution 1 -O(R * sqrt(right))/O(R) where R is the total values between right and left (i.e. numbers in given range)
//    public int[] closestPrimes(int left, int right) {
//        List<Integer> primes = new ArrayList<>();
//        while(left<=right){
//            if(isPrime(left)){
//                primes.add(left);
//            }
//            left++;
//        }
//
//        if(primes.size() < 2){
//            return new int[]{-1,-1};
//        }
//
//        int l = -1;
//        int r = -1;
//        int minDiff = Integer.MAX_VALUE;
//
//        for(int i=0; i<primes.size()-1; i++){
//            int diff = primes.get(i+1) - primes.get(i);
//            if(diff < minDiff){
//                l = primes.get(i);
//                r = primes.get(i+1);
//                minDiff = diff;
//            }
//        }
//
//        return new int[]{l, r};
//    }
//
//    private boolean isPrime(int n) {
//        if (n <= 1) {
//            return false;
//        }
//        for (int i = 2; i * i <= n; i++) {
//            if (n % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }


    // Solution 2 - Sieve of Eratosthenes - The Sieve of Eratosthenes is a very efficient way to find all prime numbers up to a given limit.
    // O(right * log(log(right)))/ O(right)
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = sieveOfEratosthenes(right);
        List<Integer> primes = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        int l = -1;
        int r = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < primes.size() - 1; i++) {
            int diff = primes.get(i + 1) - primes.get(i);
//            if (diff == 2) {
//                return new int[]{primes.get(i), primes.get(i + 1)};
//            }
            if (diff < minDiff) {
                l = primes.get(i);
                r = primes.get(i + 1);
                minDiff = diff;
            }
        }

        return new int[]{l, r};
    }

    private boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        return isPrime;
    }

}
