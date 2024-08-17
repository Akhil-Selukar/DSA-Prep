package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        bubbleSort(nums);

        // check for duplicates
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] == nums[i]){
                return true;
            }
        }
        return false;
    }

    private static void bubbleSort(int[] nums) {
        for(int i=0; i<nums.length; i++){
            boolean isSwapped = false;
            for(int j=1; j<nums.length-i; j++){
                if(nums[j-1]>nums[j]){
                    swap(nums, j-1, j);
                    isSwapped =  true;
                }
            }
            if(!isSwapped){
                break;
            }
        }
    }

    private static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second]= temp;
    }
}