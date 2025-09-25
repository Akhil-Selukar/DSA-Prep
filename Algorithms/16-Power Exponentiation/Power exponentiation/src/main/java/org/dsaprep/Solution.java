package org.dsaprep;

public class Solution {
    public double myPower(double a, int b){
        long exp = b;           // this we need to do for edge case of b = Integer.MIN_VALUE, because when we convert this minValue to +ve it goes beyond +ve range of int.

        if(exp < 0){
            // conversion of 2^-3 into (1/(2^3))
            a = 1/a;
            exp = -1*exp;
        }

        return helper(a, exp);
    }

    private double helper(double base, long exp) {
        if(exp == 0){
            return 1.0;
        }

        double result = 1.0;

        while(exp >= 1){
            if(exp%2 == 1){     // odd exponent
                result = result * base;     // multiple answer by base.
            }

            exp = exp/2;
            base = base * base;
        }

        return result;
    }
}
