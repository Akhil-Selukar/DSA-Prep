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
        // write your code here
        long exp = (long)b;     // in case of exponent is Integer.MIN_VALUE because converting this to +ve will go out of range

        if(exp < 0){        // handle -ve exponent
            a = 1/a;
            exp = -1*exp;
        }

        return helper(a, exp);
    }

    private double helper(int base, long exp) {
        if(exp == 0){
            return 1.0;
        }

        double result = 1.0;

        while(exp >= 1){
            if(exp%2 == 1){                // odd exponent
                result = result * base;
            }

            base = base*base;
            exp = exp/2;
        }

        return result;
    }
}
