package org.akhil;

public class Solution {
    // Solution 1 - O(N)/O(1)
//    public int differenceOfSums(int n, int m) {
//        int num1 = 0;
//        int num2 = 0;
//
//        for(int i=1; i<=n ; i++){
//            if(i%m == 0){
//                num2 += i;
//            } else {
//                num1 += i;
//            }
//        }
//
//        return num1 - num2;
//    }


    // -----------
    // Solution 2 - O(1)/O(1)
    // Solution 1 - O(N)/O(1)
    public int differenceOfSums(int n, int m) {
        int temp = n/m;
        int nSum = (n* (n+1))/2;

        return nSum - (temp * (temp+1) * m);
    }
}
