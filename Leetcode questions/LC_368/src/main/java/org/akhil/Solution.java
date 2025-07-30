package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // Solution 1
    // O(N^2)/O(N)
//    public List<Integer> largestDivisibleSubset(int[] nums) {
//        int n = nums.length;
//        int[] count = new int[n];
//        int[] previousIndex = new int[n];
//        int max = 0;
//        int index = -1;
//
//        Arrays.sort(nums);
//
//        for(int i=0; i<n; i++){
//            count[i] = 1;
//            previousIndex[i] = -1;
//            for(int j=0; j<i; j++){
//                if(nums[i]%nums[j] == 0){
//                    if(count[i]<count[j]+1){
//                        count[i] = count[j]+1;
//                        previousIndex[i] = j;
//                    }
//                }
//            }
//            if(count[i]>max){
//                max = count[i];
//                index = i;
//            }
//        }
//
//        List<Integer> answer = new ArrayList();
//        while(index != -1){
//            answer.add(0, nums[index]);
//            index = previousIndex[index];
//        }
//        return answer;
//    }

    //----------------------------------
    // Solution 2 - Same concept but more simpler and intuitive code
    // O(N^2)/O(N)

    /**
     * 	- Note here what is asked is subset and not subsequence or subArray, so order doesn't matter here. This is the hint for sorting.
     * 	- After sorting this problem becomes nothing but finding LIS with specific condition of (nums[i] % nums[j] == 0)
     * 	- As array is sorted, ith element will always be greater than jth element hence no need to check reverse condition.
     *  - Once length of LIS is identified build the logic to get the nums forming the LIS (use dp array and length of LIS)
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        // LIS logic with specific condition given in question
        int[] dp = new int[n];
        int lengthOfLIS = 1;
        Arrays.fill(dp, 1);

        Arrays.sort(nums);

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] % nums[j] == 0){     // specific condition in question
                    if(dp[j]+1 > dp[i]){        // if this is the longest subsequence found till now?
                        dp[i] = dp[j]+1;
                    }

                    lengthOfLIS = Math.max(lengthOfLIS, dp[i]);     // keep track of length of LIS
                }
            }
        }

        //identify the numbers forming LIS
        List<Integer> result = new ArrayList<>();
        int previousNum = -1;       // initially there will not be any previous

        for(int i=n-1; i>=0; i++){
            if(dp[i] == lengthOfLIS && (previousNum == -1 || previousNum % nums[i] == 0)){
                result.add(nums[i]);
                lengthOfLIS--;
                previousNum = nums[i];
            }
        }

        return result;
    }
}
