package org.akhil;

import java.util.Arrays;

public class Solution {
//     Here the most important hint is 'You may assume that both players are playing optimally.' This indicates that the question is
//     of optimal game strategy.
//     Now when we solve questions on optimal game strategy then always remember that when its your turn you will always hope for the
//     best (i.e. try to win) and when it's opponants turn he will always try to make you loose (means will leave worst for you)
//     That means choose best and expect worst. (that is what both players are playing optimally means).
//     now as we want tocheck if player 1 wins or not we can simply calculate best possible score (ensuring above rule is folowed) for
//     player 1 and from total possible score deduct player 1's score to get player 2 score and decide the winner.
//
//     O(N^2)/O(N)
    // public boolean predictTheWinner(int[] nums) {

    //     int totalScore = 0;
    //     for(int num:nums){
    //         totalScore += num;
    //     }

    //     int scoreP1 = helper(nums, 0, nums.length-1);
    //     int scoreP2 = totalScore - scoreP1;

    //     return scoreP1 >= scoreP2;
    // }

    // private int helper(int[] nums, int start, int end){     // player has start to end options to pick from
    //     if(start > end){
    //         return 0;
    //     }

    //     if(start == end){
    //         return nums[start];
    //     }

    //     // as we can only select elements at edge so we have 2 option only
    //     // Option 1: player 1 selected element at start considering that is maximum (selecting best for self)
    //     // player 2 will have range start+1 to end, giving player 2 as well 2 options.
    //     // now as wel rule expect worst from opponant, so what player 1 will get from player 2 is minimum possible hence Math.min()
    //     // inside min() 1st is considering player 2 pick start+1 element hence player 1 will now have range (start+2, end)
    //     // and if player 2 pick end number then player 1 will have range (start+1, end-1). As we are expecting worst hence take min of both considering player 2 took the max number leaving player 1 minimum
    //     int option1 = nums[start] + Math.min(helper(nums, start+2, end), helper(nums, start+1, end-1));

    //     // option 2: player 1 selected element at the end considering that is max
    //     int option2 = nums[end] + Math.min(helper(nums, start+1, end-1), helper(nums, start, end-2));

    //     // now we want to maximize the player 1's score
    //     return Math.max(option1, option2);
    // }

    //---------------------------

    // Solution 2 : Same just memoized
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n+2][n+2];     // +2 because we can go till start+2 in recursive function

        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        int totalScore = 0;
        for(int num:nums){
            totalScore += num;
        }

        int scoreP1 = helper(nums, 0, nums.length-1, dp);
        int scoreP2 = totalScore - scoreP1;

        return scoreP1 >= scoreP2;
    }

    private int helper(int[] nums, int start, int end, int[][] dp){
        if(start > end){
            return 0;
        }

        if(start == end){
            return nums[start];
        }

        if(dp[start][end] != -1){
            return dp[start][end];
        }

        int option1 = nums[start] + Math.min(helper(nums, start+2, end, dp), helper(nums, start+1, end-1, dp));
        int option2 = nums[end] + Math.min(helper(nums, start+1, end-1, dp), helper(nums, start, end-2, dp));

        return dp[start][end] = Math.max(option1, option2);
    }
}
