package org.akhil;

public class Solution {
    // Solution 1 - O(logN)/O(1)
    // This will give correct answer and will pass 100% for time complexity but in interview the intent behind this question is to check implementation details
    // Hence do not solve this question using build in function like below.
//    public double myPow(double x, int n) {
//        return Math.pow(x, n);
//    }

    // Solution 2 - O(lonN)/O(1)
    // power exponentiation or binary exponentiation
    public double myPow(double base, int exponent) {
        long exp = exponent;        // because of an edge case where n = -2147483648 i.e. Integer.MIN_VALUE, when converted to +ve it goes out of range for int.
        if (exp < 0) {
            base = 1 / base;
            exp = -exp;     // make exponent positive and take base = 1/base (i.e. conversion of 2^-3 into 1/(2^3))
        }

        return helper(base, exp);
    }

    private double helper(double base, long exp) {
        if(exp == 0){
            return (base < 0)?-1:1;
        }
        double ans = 1.0;

        while(exp >= 1){
            if(exp % 2 == 1){
                ans = ans * base;
            }
            exp = exp/2;
            base = base*base;
        }

        return ans;
    }
}
