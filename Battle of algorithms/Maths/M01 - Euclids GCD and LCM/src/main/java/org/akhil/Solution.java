package org.akhil;

public class Solution {


    /**
     * EUCLID'S ALGORITHM for GCD/HCF and LCM
     * Find the GCD/HCF and LCM of two numbers
     * <p>
     * TC -> O(log(min(a,b)))
     * SC -> O(log(min(a,b)))
     *
     * @param a First value
     * @param b Second value
     * @return GCD or HCF of a and b
     */
    public long gcd(long a, long b) {
        // write your code here
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0) {
            return b;
        }

        return gcd(b%a, a);
    }

    public long lcm(long a, long b) {
        // write your code here
        a = Math.abs(a);
        b = Math.abs(b);
        long gcd = gcd(a, b);
        if(gcd == 0){
            return 0;
        }
        return (a*b)/gcd;
    }
}
