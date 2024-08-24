package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2,1,2};

        System.out.println(largestPerimeter(nums));
    }

    public static int largestPerimeter(int[] nums) {
        for(int i=0; i<nums.length; i++){
            boolean isSwapped = false;
            for(int j=1; j<nums.length-i; j++){
                if(nums[j-1]>nums[j]){
                    swap(nums, j-1, j);
                    isSwapped = true;
                }
            }
            if(!isSwapped){
                break;
            }
        }

        for(int i=nums.length-1; i>=2; i--){
            if((nums[i-2]+nums[i-1])>nums[i]){
                return nums[i-2]+nums[i-1]+nums[i];
            }
        }
        return 0;
    }

    public static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}