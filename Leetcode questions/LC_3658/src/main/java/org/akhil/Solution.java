package org.akhil;

public class Solution {
    public int gcdOfOddEvenSums(int n) {
        int evenSum = n*(n+1);
        int oddSum = (int)Math.pow(n, 2);

        return gcd(evenSum, oddSum);
    }

    private int gcd(int a, int b) {
        if(a == 0){
            return b;
        }

        return gcd(b%a, a);
    }
}
