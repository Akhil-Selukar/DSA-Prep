package org.akhil;

public class Solution {

    // Solution 1 - bruteforce (O(N LogN)/O(1)) will give TLE
//    public int countDigitOne(int n) {
//        int count = 0;
//
//        for(int i=1; i<=n; i++){
//            int num = i;
//            while(num > 0){
//                if(num%10 == 1){
//                    count++;
//                }
//                num = num/10;
//            }
//        }
//        return count;
//    }


    // Solution 2 - using simple observations and maths
    // O(logN to the base 10)/O(1)
    public int countDigitOne(int n) {
        int count = 0;

        for(int powOf10=1; powOf10<=n; powOf10=powOf10*10){  // multiplying factor will be 1,10,100,... so we will check for 1 to 9, then from 10 to 99, then 100 to 999, and so on..
            int divisor = powOf10*10;
            int quotient = n/divisor;
            int remainder = n%divisor;

            if(quotient > 0){
                count = count + quotient * powOf10;      // calculating all 1's at UNITS place (Only and all units place)
            }
            if(remainder >= powOf10){
                count = count + Math.min(remainder - powOf10 + 1, powOf10);     // calculating all 1's except units place
            }
        }
        return count;
    }
}
