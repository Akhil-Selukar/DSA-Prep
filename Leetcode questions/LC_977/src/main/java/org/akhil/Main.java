package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};

        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int ansIndex = nums.length-1;
        int[] ans = new int[nums.length];

        while(start<=end){
            if(Math.abs(nums[start]) < Math.abs(nums[end])){
                ans[ansIndex] = nums[end]*nums[end];
                end--;
            } else{
                ans[ansIndex] = nums[start]*nums[start];
                start++;
            }
            ansIndex--;
        }
        return ans;
    }
}