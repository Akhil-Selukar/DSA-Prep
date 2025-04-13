package org.example;

public class Solution {
    private static final long MOD = (long)(1e9+7);
    public int countGoodNumbers(long n) {
        long evenIndex = (n+1)/2;
        long oddIndex = n/2;

        double count = (power(5, evenIndex) * power(4, oddIndex))%MOD;

        return (int)count;
    }

    private long power(double base, long exp){
        if(exp == 0){
            return (base < 0) ? -1 : 1;
        }

        base = base % MOD;
        double result = 1;

        while(exp>=1){
            if(exp % 2 == 1){
                result = (result * base)%MOD;
            }

            exp = exp/2;
            base = (base * base)%MOD;
        }

        return (long) result;
    }
}
