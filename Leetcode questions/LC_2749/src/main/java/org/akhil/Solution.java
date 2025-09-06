package org.akhil;

public class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int i=0; i<=60; i++){       // 60 because given in constraints we can use while(true){} loop as well because either we will get ans or will go invalid so will not be the case of infinite loop
            long x = num1 - i*num2;         // range of num2 is from -10^9 to 10^9 so it can go beyond int range.

            // invalid case
            if (x < 0) {
                return -1;
            }

            if(i >= Long.bitCount(x) && i <= x){        // bitCount gives number of set bits in binary form of x (we can write own function as well using logical shifts)
                return i;
            }
        }
        return -1;
    }
}
