package org.akhil;

public class Solution {

    // Solution 1 - without memoization
    // in this approach we have total 4 choices at each cell
    //  1. dont skip and go right
    //  2. dont skip and go down
    //  3. skip and go right
    //  4. skip and go down
    // though skip operations can only be performed in case of -ve cell value. but still in worst case of we have all -ve cells then we will have these 4
    // choices making the TC for this approach O(4^(M+N)) (Here imp point is (M+N) and not (M*N) because we are not visiting each cell during traversal,
    // in a path we can visit at max M+N) cells only)
    // Still this is not optimized solution hence will give TLE
    // SC -> O(M+N) because at max recursion can go till (M+N) levels deep
//    public int maximumAmount(int[][] coins) {
//        return helper(coins, 0, 0, 2);
//    }
//
//    private int helper(int[][] coins, int row, int col, int skips){
//        if(row >= coins.length || col >= coins[0].length){
//            return Integer.MIN_VALUE;
//        }
//
//        if(row == coins.length-1 && col == coins[0].length-1){
//            if(coins[row][col] < 0 && skips > 0){
//                return 0;
//            }
//            return coins[row][col];
//        }
//
//        // considering current cell has +ve coins and No skips are applied here
////        int rightSum = coins[row][col] + helper(coins, row, col+1, skips);
////        int downSum = coins[row][col] + helper(coins, row+1, col, skips);
//        // above gives incorrect answer because of int overflow. helper() call can give Integer.MIN_VALUE and if coins[row][col] is also -ve then it will
//        // go int overflow and result in incorrect answer hence dont add coins[row][col] right away, first get the value and then add it to
//        // whichever is max
//
//        int rightSum =helper(coins, row, col+1, skips);
//        int downSum = helper(coins, row+1, col, skips);
//
//        int noSkipMax = Math.max(rightSum, downSum) == Integer.MIN_VALUE ? Integer.MIN_VALUE : Math.max(rightSum, downSum) + coins[row][col];
//
//        // if in case current cell has -ve coins the skip the current cell and find the max we can get from both path
//        int skipMax = Integer.MIN_VALUE;
//        if(coins[row][col] < 0 && skips > 0){
//            int skipAndRight = helper(coins, row, col+1, skips-1);
//            int skipAndDown = helper(coins, row+1, col, skips-1);
//
//            // what max we can get
//            skipMax = Math.max(skipAndDown, skipAndRight);
//        }
//
//        // max can be achieved by either without skipping and going to right and down or what max we got by skipping in case of -ve coins
////        int maxCoins = Math.max(skipSum, Math.max(rightSum, downSum));
//        int maxCoins = Math.max(skipMax, noSkipMax);
//        return maxCoins;
//    }


    // ---------------------------
    // Solution 2 - Memoization
    // O(M*N)/O(M+N)
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        Integer[][][] dp = new Integer[m+1][n+1][3];

        return helper(coins, 0, 0, 2, dp);
    }

    private int helper(int[][] coins, int row, int col, int skips, Integer[][][] dp){
        if(row >= coins.length || col >= coins[0].length){
            return Integer.MIN_VALUE;
        }

        if(dp[row][col][skips] != null){
            return dp[row][col][skips];
        }

        if(row == coins.length-1 && col == coins[0].length-1){
            if(coins[row][col] < 0 && skips > 0){
                return 0;
            }
            return coins[row][col];
        }

        // considering current cell has +ve coins and No skips are applied here
//        int rightSum = coins[row][col] + helper(coins, row, col+1, skips);
//        int downSum = coins[row][col] + helper(coins, row+1, col, skips);
        // above gives incorrect answer because of int overflow. helper() call can give Integer.MIN_VALUE and if coins[row][col] is also -ve then it will
        // go int overflow and result in incorrect answer hence dont add coins[row][col] right away, first get the value and then add it to
        // whichever is max

        int rightSum = helper(coins, row, col + 1, skips, dp);
        int downSum = helper(coins, row + 1, col, skips, dp);
        int noSkipMax = Math.max(rightSum, downSum) == Integer.MIN_VALUE ? Integer.MIN_VALUE : Math.max(rightSum, downSum) + coins[row][col];


        // if in case current cell has -ve coins the skip the current cell and find the max we can get from both path
        int skipMax = Integer.MIN_VALUE;
        if(coins[row][col] < 0 && skips > 0){
            int skipAndRight = helper(coins, row, col+1, skips-1, dp);
            int skipAndDown = helper(coins, row+1, col, skips-1, dp);

            // what max we can get
            skipMax = Math.max(skipAndDown, skipAndRight);
        }

        // max can be achieved by either without skipping and going to right and down or what max we got by skipping in case of -ve coins
//        int maxCoins = Math.max(skipSum, Math.max(rightSum, downSum));
        int maxCoins = Math.max(skipMax, noSkipMax);
        return dp[row][col][skips] = maxCoins;
    }
}
