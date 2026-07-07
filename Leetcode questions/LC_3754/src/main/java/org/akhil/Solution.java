package org.akhil;

public class Solution {
    // Solution 1
    // O(logN)/O(logN)
    // public long sumAndMultiply(int n) {
    //     int sum = 0;
    //     StringBuilder sb = new StringBuilder();

    //     while(n > 0){
    //         int digit = n%10;
    //         if(digit != 0){
    //             sum = sum + digit;
    //             sb.append(digit);
    //         }
    //         n = n/10;
    //     }
    //     if(sb.length() == 0){
    //         return 0;
    //     }
    //     return Long.parseLong(sb.reverse().toString())*sum;
    // }

    // ----------------------
    // Solution 2
    // O(logN)/O(logN)
    public long sumAndMultiply(int n) {
        String str = Integer.toString(n);
        int sum = 0;
        long num = 0;

        for(int i=0; i<str.length(); i++){
            int digit = str.charAt(i)-'0';
            if(digit != 0){
                sum = sum + digit;
                num = num*10 + digit;
            }
        }
        return num*sum;
    }
}
