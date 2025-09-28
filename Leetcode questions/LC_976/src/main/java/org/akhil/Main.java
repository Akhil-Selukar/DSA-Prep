package org.akhil;

import java.util.Arrays;

public class Main {
//    public static void main(String[] args) {
//        int[] nums = {2,1,2};
//
//        System.out.println(largestPerimeter(nums));
//    }
//
//    public static int largestPerimeter(int[] nums) {
//        for(int i=0; i<nums.length; i++){
//            boolean isSwapped = false;
//            for(int j=1; j<nums.length-i; j++){
//                if(nums[j-1]>nums[j]){
//                    swap(nums, j-1, j);
//                    isSwapped = true;
//                }
//            }
//            if(!isSwapped){
//                break;
//            }
//        }
//
//        for(int i=nums.length-1; i>=2; i--){
//            if((nums[i-2]+nums[i-1])>nums[i]){
//                return nums[i-2]+nums[i-1]+nums[i];
//            }
//        }
//        return 0;
//    }
//
//    public static void swap(int[] nums, int first, int second){
//        int temp = nums[first];
//        nums[first] = nums[second];
//        nums[second] = temp;
//    }


    // --------------------

    // Solution 1 - Check all triangles and find the one with max perimeter
    // O(NlogN)/O(logN) // space complexity is suxikary space we can say it as O(1) if we are not considering space required for sorting.
    // public int largestPerimeter(int[] nums) {
    //     int n = nums.length;
    //     Arrays.sort(nums);
    //     int result = 0;

    //     for(int i=0; i<n-2; i++){
    //         int a = nums[i];
    //         int b = nums[i+1];
    //         int c = nums[i+2];

    //         if((a+b)>c){
    //             result = Math.max(result, a+b+c);
    //         }
    //     }
    //     return result;
    // }

    // -----------------
    // Even though above approach work but there is a major flaw in it which is we are going from front to back i.e. start to end of sorted array. So there can be some pairs where non adjacent values are forming triangle this will not be possible with reverse traversing because of sorting and the relation (a+b > c). So correct approach will be to traverse from end to start.
    // Also as we need highest perimeter so it will be because of the highest length which will be at the end only (because of sorting) so first valid triangle from back will be the answer and we will not be traversing through all triangles.

    // time and space complexity will be same but this will be efficient as we are not checking all pairs
    public static int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=n-1; i>=2; i--){
            int a = nums[i-2];
            int b = nums[i-1];
            int c = nums[i];

            if((a+b)>c){
                return a+b+c;
            }
        }
        return 0;
    }
}