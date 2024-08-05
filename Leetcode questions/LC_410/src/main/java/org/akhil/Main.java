package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3,2,5,8,1,6};
        int k = 2;

        System.out.println(splitArray(arr, k));
    }

    public static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        for(int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }

        while(start < end){
            int mid = start + (end-start)/2;
            int subArrayCount = 1;
            int subArraySum = 0;

            for(int num: nums){
                subArraySum += num;

                if(subArraySum > mid){
                    subArrayCount++;
                    subArraySum = num;
                }
            }
            if(subArrayCount > k){
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}