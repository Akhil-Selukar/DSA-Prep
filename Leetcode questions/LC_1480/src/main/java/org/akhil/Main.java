package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};

        System.out.println(Arrays.toString(runningSum(arr)));
    }

    public static int[] runningSum(int[] nums) {
        // 1st and simple solution
        /*int[] ans = new int[nums.length];
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            ans[i] = sum;
        }
        return ans;*/

        // Improved solution with O(1) space complexity

        for(int i=1; i<nums.length; i++){
            nums[i] = nums[i-1]+nums[i];
        }
        return nums;
    }
}