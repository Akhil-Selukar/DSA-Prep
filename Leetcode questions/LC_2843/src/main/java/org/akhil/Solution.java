package org.akhil;

public class Solution {
    // Solution 1
    // TC - O(high-low) (Check the explanation in readme.md)
    // SC - O(1)
//    public int countSymmetricIntegers(int low, int high) {
//        int nLow = (getTotalDigits(low)+1)/2;
//        int nHigh = (getTotalDigits(high)+1)/2;
//        int count = 0;
//
//        for(int n=nLow; n<=nHigh; n++){
//            for(int i=low; i<=high; i++){
//                if((getTotalDigits(i) == (2*n)) && isSymmetric(i)){
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }
//
//    private boolean isSymmetric(int num){
//        int n = getTotalDigits(num);
//        if(n%2 == 1){
//            return false;
//        }
//
//        int leftHalf = num / (int)(Math.pow(10, (n/2)));
//        int rightHalf = num % (int)(Math.pow(10, (n/2)));
//
//        return (getSum(leftHalf) == getSum(rightHalf));
//    }
//
//    private int getSum(int num){
//        int sum = 0;
//        while(num > 0){
//            int digit = num%10;
//            num = num/10;
//            sum = sum + digit;
//        }
//        return sum;
//    }
//
//    private int getTotalDigits(int num){
//        int count = 0;
//
//        while(num > 0){
//            num = num/10;
//            count++;
//        }
//
//        return count;
//    }


    // Solution 2
    // TC - O(high-low)
    // SC - O(1)
    // Even though the space and time complexity is same here but this solution will be better one because of less calculations and elimination of calculating digits in each number and Math.pow() operation.
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            int len = s.length();
            // if digits in the number are odd then no symmetric number is possible
            if (len % 2 != 0){
                continue;
            }

            int half = len / 2;
            int sumLeft = 0;
            int sumRight = 0;

            for (int j = 0; j < half; j++) {
                sumLeft += s.charAt(j);             // we dont need actual sum here, we just want to verify the digits are same on both the side (if digits are same no matter in which order the sum will be same only)
                sumRight += s.charAt(half + j);
            }
            if (sumLeft == sumRight) {
                count++;
            }
        }
        return count;
    }
}
