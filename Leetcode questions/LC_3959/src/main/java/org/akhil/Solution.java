package org.akhil;

public class Solution {
    // O(N)/O(1)
    public boolean checkGoodInteger(int n) {
        int digitSum = 0;
        int sqSum = 0;

        while(n > 0){
            int digit = n%10;
            digitSum = digitSum + digit;
            sqSum = sqSum + (int)Math.pow(digit, 2);
            n = n/10;
        }

        return (sqSum - digitSum) >= 50;
    }
}
