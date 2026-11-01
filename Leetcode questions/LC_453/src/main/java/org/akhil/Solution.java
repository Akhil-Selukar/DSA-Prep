package org.akhil;

import java.util.Arrays;

public class Solution {
    // [0  1  2  3  4]
    // [2  3  4  5  6] -> [2 3 4 5 6]
    // [3  4  5  6  6] -> [2 2 4 5 6]
    // [4  5  6  6  7] -> [2 2 3 5 6]
    // [5  6  7  7  7] -> [2 2 2 5 6]
    // [6  6  8  8  8] -> [2 2 2 4 6]
    // [7  7  9  9  8] -> [2 2 2 3 6]
    // [8  8  9  10 9] -> [2 2 2 2 6]
    // [9  9  10 10 10]-> [2 2 2 2 5]
    // [10 10 10 11 11]-> [2 2 2 2 4]
    // [11 11 11 11 12]-> [2 2 2 2 3]
    // [12 12 12 12 12]-> [2 2 2 2 2]

    // Visualize this as a bar graph and then the blocks we need to increment all bars to max are same as that of blocks we need
    // to remove from every bar to make all bar height to same (minimum)
    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int diff = 0;
        for(int num:nums){
            diff = diff + (num-min);
        }
        return diff;
    }
}
