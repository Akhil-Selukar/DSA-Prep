package org.akhil;

/*
Important to know to solve this problem:
Sum of any two sides of triangle is always greater than third side.
(a+b)>c
(a+c)>b
(b+c)>a
*/

import java.util.Arrays;

class Solution {
    // Solution 1 - Bruteforce
    // O(N^3)/O(1) - TLE
    // public int triangleNumber(int[] nums) {
    //     if(nums.length < 3){
    //         return 0;
    //     }
    //    int count = 0;
    //    for(int i=0; i<nums.length-2; i++){
    //         for(int j=i+1; j<nums.length-1; j++){
    //             for(int k=j+1; k<nums.length; k++){
    //                 if((nums[i]+nums[j]) > nums[k] && (nums[j]+nums[k]) > nums[i] && (nums[i]+nums[k]) > nums[j]){
    //                     count++;
    //                 }
    //             }
    //         }
    //    }

    //    return count;
    // }


    // ---------------------
    // Solution 2 - Optimized
    // O(N^2 logN)/O(1)
    // a+b > c need to be true so if we sort the array we will have array like [2,3,4,4]
    // now if we run two loops for a and b (consider a=2  and b=3 then we just need to find elements to the right of b where that element is less than (a+b))
    // as array is sorted so other two conditions will obviously besatisfied because a < b < c will always true.
    // as array is sirted we can use binary search to the right side of b and find last value which is less than a+b.
    public int triangleNumber(int[] nums) {
        if(nums.length < 3){
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;

        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                int sum = nums[i]+nums[j];
                int index = binarySearch(j+1, nums, sum);

                if(index != -1){
                    count = count + (index-j);
                }
            }
        }

        return count;
    }

    private int binarySearch(int i, int[] nums, int target){
        int result = -1;
        int start = i;
        int end = nums.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] < target){
                result = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return result;
    }
}
