package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        return bSearch(nums, target, 0, nums.length-1);
    }

    private static int bSearch(int[] nums, int target, int startIndex, int endIndex) {
        if(startIndex > endIndex){
            return -1;
        }

        int midIndex = startIndex + (endIndex - startIndex)/2;

        if(nums[midIndex] == target){
            return midIndex;
        } else if(nums[midIndex]<target){
            return bSearch(nums, target, midIndex+1, endIndex);
        } else {
            return bSearch(nums, target, startIndex, midIndex-1);
        }
    }
}
