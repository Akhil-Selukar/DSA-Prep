package org.akhil;

public class Solution {
    // O(N^2)/O(1)
    // public int maxProduct(int[] nums) {
    //     int result = Integer.MIN_VALUE;

    //     for(int i=0; i<nums.length; i++){
    //         int currProd = 1;
    //         for(int j=i; j<nums.length; j++){
    //             currProd *= nums[j];
    //             result = Math.max(result, currProd);
    //         }
    //     }
    //     return result;
    // }

    // -------------------
    // Solution 2 - optimized
    // O(N)/O(1)
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int currProd = 1;

        for(int i=0; i<nums.length; i++){
            currProd *= nums[i];
            result = Math.max(result, currProd);

            if(currProd == 0){      // as soon as we have currProd = 0, all further products will be 0.
                currProd = 1;       // Hence set currProd = 1; (kind of starting new subArray)
            }
        }

        // we can have -ve numbers as well hence the subarray can be maximum after -ve element. hence we need to check in reverse direction as well.
        // consider [3,-1,4], if we consider only above loop it willl give max product as 3 which is wrong.
        // hence we need to check in reverse direction as well.
        currProd = 1;
        for(int i=nums.length-1; i>=0; i--){
            currProd *= nums[i];
            result = Math.max(result, currProd);

            if(currProd == 0){
                currProd = 1;
            }
        }
        return result;
    }

    // ----------------
    // Solution 3 - bit complex solution
    // O(N)/O(1)
//    public int maxProduct(int[] nums) {
////        int max = Arrays.stream(nums).max();
//
//        int max = Integer.MIN_VALUE;
//        for(int num:nums){
//            max = Math.max(max, num);
//        }
//
//        int currentMax = 1;
//        int currentMin = 1;
//
//        for(int num:nums){
//            int temp = currentMax * num;
//
//            currentMax = Math.max(temp, Math.max(currentMin * num, num));
//            currentMin = Math.min(temp, Math.min(currentMin * num, num));
//
//            max = Math.max(currentMax, max);
//        }
//
//        return max;
//    }
}
