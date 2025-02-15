package org.akhil;

import java.math.BigInteger;

public class Solution {

    // Solution 1 - Number format exception as testcase has numbers which can go beyond range of long.
//    public boolean isAdditiveNumber(String num) {
//        int n = num.length();
//        if(n < 3){
//            return false;
//        }
//
//        for(int i=1; i<=n/2; i++){
//            for(int j=1; j+i<n; j++){
//                if(isValid(i, j, num)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean isValid(int i, int j , String num){
//        // check leading 0 in first part
//        if(num.charAt(0) == '0' && i>1){    // it should not be leading 0, only 0 is valid hence i>1. (i.e. 0 is valid but 01 is invalid)
//            return false;
//        }
//        // check leading 0 in second part
//        if(num.charAt(i) == '0' && j>1){    // second part will start from ith index hence charAt(i) and again same logic for j>1.
//            return false;
//        }
//
//        long num1 = Long.parseLong(num.substring(0, i));
//        long num2 = Long.parseLong(num.substring(i, i+j));
//
//        String tempSum;
//        for(int start=i+j; start < num.length(); start = start+tempSum.length()){
//            num2 = num2 + num1;
//            num1 = num2 - num1;
//            tempSum = Long.toString(num2);
//
//            if(!num.startsWith(tempSum, start)){
//                return false;
//            }
//        }
//        return true;
//    }

    // Solution 2 - Using BigInteger (O(N^3)/O(N))
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        if(n < 3){
            return false;
        }

        for(int i=1; i<=n/2; i++){
            for(int j=1; j+i<n; j++){
                if(isValid(i, j, num)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int i, int j , String num){
        // check leading 0 in first part
        if(num.charAt(0) == '0' && i>1){    // it should not be leading 0, only 0 is valid hence i>1. (i.e. 0 is valid but 01 is invalid)
            return false;
        }
        // check leading 0 in second part
        if(num.charAt(i) == '0' && j>1){    // second part will start from ith index hence charAt(i) and again same logic for j>1.
            return false;
        }

        BigInteger num1 = new BigInteger(num.substring(0, i));
        BigInteger num2 = new BigInteger(num.substring(i, i+j));

        String tempSum;
        for(int start=i+j; start < num.length(); start = start+tempSum.length()){
            num2 = num2.add(num1);
            num1 = num2.subtract(num1);
            tempSum = num2.toString();

            if(!num.startsWith(tempSum, start)){
                return false;
            }
        }
        return true;
    }
}
