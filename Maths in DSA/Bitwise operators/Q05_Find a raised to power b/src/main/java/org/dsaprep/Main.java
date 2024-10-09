package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int a = 2;
        int b = 5;

        System.out.println(findPower(a,b));
    }

    protected static int findPower(int a, int exponent) {
        int ans = 1;
        int base = a;
        while(exponent>0){
            if((exponent&1) == 1){  // checking if the LSB of binary value of exponent is 1 or not.
                ans = ans*base;
            }
            base = base*base;   // updating base in every iteration
            exponent = exponent>>1;   // moving to next value in binary form of exponent
        }
        return ans;
    }
}