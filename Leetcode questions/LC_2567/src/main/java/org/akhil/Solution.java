package org.akhil;

import java.util.Arrays;

public class Solution {
    // here as we can only change two numbers and from testcase given we can see that we are allowed to make two numbers equal.
    // so low score will always be 0, because as we have two changes allowed we can use one change to make any number equal to some
    // other number making the absolute difference 0.
    // Now the only question remaining is we need to minimize the high score.
    // The high score depends on first and last value of the array after sorting. Hence we are only interested in those tw values.
    // Now the possible transformations after sorting are
    //      1. We can change first two values equal to third (i.e. index 0 and 1 equal to index 2) this will reduce the high
    //         score and make first three values equal so low score will be 0.
    //      2. We can make last two value equal to 3rd last value (i.e. index n-1 and n-2 equal to n-3) this will also reduce
    //         high score and make last three values equal so low score will be .
    //      3. We can make first value equal to second and last value equal to second last making reducingthe high score and making
    //         first two and last two values same so low scre will be 0.
    // Here we can conclude that in all cases low score is 0, so only thing we need to find is in what case the high score is minimum.
    // That will be the required answer.

    // O(NlogN)/O(1)
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int option1 = nums[n-1] - nums[2];  // consider changed 0th and 1st index element to 2nd index element hence array range is [2 to n-1]
        int option2 = nums[n-3] - nums[0];  // consider changed last 2 index element to n-3 index element hence array range is [0  to n-3]
        int option3 = nums[n-2] - nums[1];  // consider changed 0th index element to 1st index element and n-1th to n-2th hence array range is [1 to n-2]

        return Math.min(option1, Math.min(option2, option3));
    }
}
