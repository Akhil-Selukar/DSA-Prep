package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        int temp = 1;
        for(int i=0; i<nums.length; i++){
            ans[i] = ans[i] * temp;
            temp = temp * nums[i];
        }

        temp = 1;
        for(int i = nums.length-1; i>=0; i--){
            ans[i] = ans[i] * temp;
            temp = temp * nums[i];
        }
        return ans;
    }
}