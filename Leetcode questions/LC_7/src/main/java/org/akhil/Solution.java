package org.akhil;

public class Solution {
    // Solution 1 - Converting int to string and reversing
    // O(N)/O(N) where N is number of digits in x (i.e. log(X))
//    public int reverse(int x) {
//        int result = 0;
//        boolean isNegative = x < 0;
//
//        String strNum = String.valueOf(Math.abs(x));
//        StringBuilder sb = new StringBuilder(strNum);
//
//        try{
//            result = Integer.parseInt(sb.reverse().toString());
//        } catch (NumberFormatException e){
//            return 0;
//        }
//
//        if(isNegative){
//            return -1 * result;
//        }
//        return result;
//    }


    // Solution 2 - normal reversal of number (more intuitive)
    public int reverse(int x) {
        long result = 0;

        while(x != 0){
            result = (result * 10) + x%10;
            x = x/10;
        }

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }
}
