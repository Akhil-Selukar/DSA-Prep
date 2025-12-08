package org.akhil;

public class Solution {
    // Solution 1 - Bruteforce
    // O(N^3)/O(1)
//    public int countTriples(int n) {
//        int count = 0;
//        for(int a=1; a<=n; a++){
//            for(int b=1; b<=n; b++){
//                for(int c=1; c<=n; c++){
//                    if(((a*a) + (b*b)) == (c*c)){
//                        count++;
//                    }
//                }
//            }
//        }
//
//        return count;
//    }

    // -----------------
    // Solution 2 - Optimized
    // O(N^2*logN)/O(1)
    public int countTriples(int n) {
        int count = 0;
        for(int a=1; a<=n; a++){
            for(int b=a+1; b<=n; b++) {
                int cSum = (a * a) + (b * b);
                int sqrt = (int) Math.sqrt(cSum);       // O(logN)

                // sqrt can be decimal which we dont want
                if ((sqrt * sqrt) == cSum && sqrt <= n) {
                    count = count + 2;          // +2 because we are starting b from a+1 and if a,b,c is a pair then b,a,c will also be a pair
                }
            }
        }
        return count;
    }
}
