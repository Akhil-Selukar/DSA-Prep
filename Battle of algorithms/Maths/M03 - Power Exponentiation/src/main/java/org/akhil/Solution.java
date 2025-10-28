package org.akhil;

public class Solution {

    /**
     * Power exponentiation algorithm
     *
     * TC -> O(log(b))
     * SC -> O(1)
     *
     * @param a base
     * @param b exponent
     * @return Math.pow(a,b)
     */
    public double power(int a, int b){
        long exp = (long)b;

        if(exp < 0){
            exp = -1 * exp;
            a = 1/a;
        }

        return helper(a, exp);
    }

    private double helper(int base, long exp) {
        if(exp == 0){
            return 1.0;
        }

        double result = 1.0;

        while(exp >= 1){
            if(exp%2 == 1){
                result = result * base;
            }

            base = base * base;
            exp = exp/2;
        }

        return result;
    }
}
