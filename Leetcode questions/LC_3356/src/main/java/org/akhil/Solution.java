package org.akhil;

import java.util.Arrays;

public class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {

        // if nums has all 0 then it is already zero array and no transformation is required
        if(Arrays.stream(nums).allMatch(num -> num == 0)){
            return 0;
        }

        int left = 0;
        int right = queries.length;

        // After using all queries as well if we are not able to transform
        if(!canTransform(right, nums, queries)){
            return -1;
        }

        // check for minimum value of k;
        while(left <= right){
            int mid = left + (right - left)/2;

            if(canTransform(mid, nums, queries)){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    private boolean canTransform(int k, int[] nums, int[][] queries){
        int n = nums.length;
        int[] differenceArray = new int[n+1];

        // apply difference array technique for range for first k queries
        for(int i=0; i<k; i++){
            int leftBoundary = queries[i][0];
            int rightBoundary = queries[i][1];
            int val = queries[i][2];

            differenceArray[leftBoundary] += val;
            differenceArray[rightBoundary+1] -= val;
        }

        // after applying k queries are we able to get all element 0 (here as we are applying all queries hence we are
        // not just restricting to 0, we can ge in -ve  and if we are going in -ve means we can for sure reach till 0 as
        // we can decrement AT MOST val times which means anything between 0 till val)
        int sum = 0;
        for(int i=0; i<n; i++){     // only till n because n+1th element in differenceArray is dully element to simplify calculations (i.e. population of diff array)
            sum = sum + differenceArray[i];
            if(sum < nums[i]){
                return false;
            }
        }
        return true;
    }
}
