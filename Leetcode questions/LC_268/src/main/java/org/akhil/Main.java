package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1};

        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] nums) {
        int i=0;
        while(i < nums.length){
            int correctIndex = nums[i];  // as our array contains elements from range 0 to N, so we will have 0 as well in our sorted array and each element's correct index will be it's value itself.

            if(nums[i] < nums.length && nums[i] != nums[correctIndex]){    // here i < nums.length because if n = 3 and array is [0,3,1] in this case we do have n elements but we don't have nth index.
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        // check for missing number
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j) {
                return j;
            }
        }
        return nums.length; // in case of n=3 and given elements are [0,2,1] so missing element is nothing but N i.e. arr.length;
    }

    private static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}