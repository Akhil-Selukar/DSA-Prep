package org.dsaprep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 30;

        printPrimes(n);
    }

    public static void printPrimes(int n){
        int[] primes = sieveOfEratosthenes(n);

        for(int i=1; i<=n; i++){
            if(primes[i] == 1){
                System.out.println(i);
            }
        }
    }

    private static int[] sieveOfEratosthenes(int n) {
        int[] primes = new int[n+1];        // +1 because we want N to be inclusive and index starts from 0.
        Arrays.fill(primes, 1);
        primes[0] = primes[1] = 0;          // 0 and 1 are not prime.

        for(int i=2; i*i<=n; i++){
            if(primes[i] == 1){
                for(int j= i*i; j<=n; j=j+i){
                    primes[j] = 0;
                }
            }
        }

        return primes;
    }
}