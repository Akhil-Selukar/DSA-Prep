package org.akhil;

public class Solution {
    // O(N)/O(1) where N is number of digits in given number
    public int mirrorDistance(int n) {
        int reverse = getReverse(n);

        return Math.abs(n - reverse);
    }

    private int getReverse(int num){
        int reverse = 0;
        while(num > 0){
            reverse = reverse*10 + num%10;
            num = num/10;
        }
        return reverse;
    }
}
