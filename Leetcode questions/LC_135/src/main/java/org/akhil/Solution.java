package org.akhil;

import java.util.Arrays;

public class Solution {

    // O(N)/O(N)
    public int candy(int[] ratings) {
        int n = ratings.length;
        int totalCandies = 0;
        int[] candies = new int[n];

        Arrays.fill(candies, 1);    // each can have atleast 1 candy.

        // check if left child has lesser rank than current
        for (int i=1; i<n; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1]+1;
            }
        }

        // check if right child has lesser rank than current
        for (int i=n-1; i>0; i--) {
            if (ratings[i-1] > ratings[i]) {
                candies[i-1] = Math.max(candies[i] + 1, candies[i-1]);
            }

            totalCandies = totalCandies + candies[i-1];
        }
        return totalCandies + candies[n-1];
    }
}
