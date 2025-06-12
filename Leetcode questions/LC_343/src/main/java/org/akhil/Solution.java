package org.akhil;

public class Solution {

    // Solution 1 - Bruteforce without DP (TLE)
    // TC -> O(N * N^(N-1)) (for each element n there are n-1 choices)
    // SC -> O(1) plus recursive stack
//    public int integerBreak(int n) {
//
//        int max = Integer.MIN_VALUE;
//
//        for(int i=1; i<=n-1; i++){
//            int product = i * Math.max((n-i), helper(n-i));
//            max = Math.max(max, product);
//        }
//        return max;
//    }
//
//    private int helper(int num){
//        if(num == 1){
//            return 1;
//        }
//        int max = Integer.MIN_VALUE;
//
//        for(int i=1; i<=num-1; i++){
//            int product = i * Math.max((num-i), helper(num-i));
//            max = Math.max(max, product);
//        }
//        return max;
//    }


    // Solution 2 - Memoization
    // Solution 1 - Bruteforce without DP (TLE)
    // TC -> O(N^2) every value in dp we will calculate once and this we will do for N times (because of for loop) hence N^2
    // SC -> O(N) plus recursive stack
//    public int integerBreak(int n) {
//
//        int max = Integer.MIN_VALUE;
//        int[] dp = new int[n];
//
//        for(int i=1; i<=n-1; i++){
//            int product = i * Math.max((n-i), helper(n-i, dp));
//            max = Math.max(max, product);
//        }
//        return max;
//    }
//
//    private int helper(int num, int[] dp){
//        if(num == 1){
//            return 1;
//        }
//        if(dp[num] != 0){
//            return dp[num];
//        }
//
//        int max = Integer.MIN_VALUE;
//
//        for(int i=1; i<=num-1; i++){
//            int product = i * Math.max((num-i), helper(num-i, dp));
//            max = Math.max(max, product);
//        }
//        return dp[num] = max;
//    }


    // Solution 3 - More optimized solution.
    // TC -> O(logN) needed for Math.pow();
    // SC -> O(1)
    public int integerBreak(int n) {

        // edge cases handling
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }

        int countOfThree = n / 3;
        int remainder = n % 3;

        if(remainder == 1){
            countOfThree--;
            remainder = remainder + 3;
        } else if(remainder == 0){
            remainder = 1;  // any num multiplied by 1 will not change the number.
        }

        return (int) (Math.pow(3, countOfThree) * remainder);
    }
}
