package org.akhil;

public class Solution {

    /*
    * Solution 1 is more intuitive and it is okay to just give solution 1.
    * */

    // Solution 1 - bruteforce (calculating and storing leftMaxHeight and rightMaxHeight)
    // TC - O(N)
    // SC - O(N)
//    public int trap(int[] height) {
//        int n = height.length;
//        int[] leftMaxHeight = new int[n];
//        int[] rightMaxHeight = new int[n];
//        int maxWater = 0;
//        int tempMaxHeight = 0;
//
//        // calculate leftMaxHeight
//        for(int i=1; i<n; i++){             // starting from 1 because there will not be any max height to the left of index 0.
//            tempMaxHeight = Math.max(tempMaxHeight, height[i-1]);
//            leftMaxHeight[i] = tempMaxHeight;
//        }
//
//        // calculate rightMaxHeight
//        tempMaxHeight = 0;
//        for(int i=n-2; i>=0; i--){
//            tempMaxHeight = Math.max(tempMaxHeight, height[i+1]);
//            rightMaxHeight[i] = tempMaxHeight;
//        }
//
//        // calculation of trapped watter
//        for(int i=0; i<n; i++){
//            int maxCapacity = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
//
//            if((maxCapacity - height[i]) > 0){
//                maxWater = maxWater + (maxCapacity - height[i]);
//            }
//        }
//
//        return maxWater;
//    }

    // Solution 2 - Using two pointer method.
    // TC - O(N)
    // SC - O(1)
    // Here as the max water which can be trapped between two walls is determined by smallest wall out of two, hence this we can use to our advantage.
    public int trap(int[] height) {
        int n = height.length;
        int maxWater = 0;

        int leftPointer = 0;
        int rightPointer = n-1;

        int leftMaxHeight = 0;
        int rightMaxHeight = 0;

        while(leftPointer <= rightPointer) {
            if (leftMaxHeight <= rightMaxHeight) {
                int waterAtCurrPlace = leftMaxHeight - height[leftPointer];
                if(waterAtCurrPlace > 0){
                    maxWater = maxWater + waterAtCurrPlace;
                }
                leftMaxHeight = Math.max(leftMaxHeight, height[leftPointer]);
                leftPointer++;

            } else {
                int waterAtCurrPlace = rightMaxHeight - height[rightPointer];
                if(waterAtCurrPlace > 0){
                    maxWater = maxWater + waterAtCurrPlace;
                }
                rightMaxHeight = Math.max(rightMaxHeight, height[rightPointer]);
                rightPointer--;
            }
        }

        return maxWater;
    }
}
