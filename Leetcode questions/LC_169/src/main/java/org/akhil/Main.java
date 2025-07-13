package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};

        System.out.println(majorityElement(nums));
    }

//    public static int majorityElement(int[] nums) {
//        // cyclic sort
//        bubbleSort(nums);
//        return nums[(nums.length/2)];
//    }
//
//    private static void bubbleSort(int[] nums) {
//        for(int i=0; i<nums.length; i++){
//            boolean isSwapped = false;
//            for(int j=1;j<nums.length-i; j++){
//                if(nums[j-1]>nums[j]){
//                    swap(nums, j-1, j);
//                    isSwapped = true;
//                }
//            }
//            if(!isSwapped){
//                break;
//            }
//        }
//    }
//
//    private static void swap(int[] nums, int first, int second){
//        int temp = nums[first];
//        nums[first] = nums[second];
//        nums[second] = temp;
//    }


    // Solution 2 - Optimized without sorting (O(N)/O(1))
    public static int majorityElement(int[] nums) {
        int majorityElement = nums[0];
        int countOfMajorityElement = 1;

        for(int i=1; i<nums.length; i++){
            if(nums[i] == majorityElement){
                countOfMajorityElement++;
            } else {
                countOfMajorityElement--;
                if(countOfMajorityElement < 0){
                    majorityElement = nums[i];
                    countOfMajorityElement = 1;
                }
            }
        }
        return majorityElement;
    }
}