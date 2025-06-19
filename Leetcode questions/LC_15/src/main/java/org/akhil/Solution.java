package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // Solution 1
    // O(N^2)/O(N)
    // space complexity O(NlogN) for sorting plus outer loop is O(N-2) ~ O(N) and inner while loop while(j<k) iterates N times
    // because either j increment or k decrement and both meet at a point so at worst case when there are no duplicates it iterates N times.
    // Hence O(N) for outer for loop * O(N) for inner while loop will become O(N^2).
    // Hence total time complexity will be O(NlogN + N^2) where dominant term is N^2 hence O(N^2)

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<=n-3; i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while(j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                } else {
                    if(sum < 0){
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            while(i+1 < n-2 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return ans;
    }

    // Solution 2 (Same approach but a bit clean code)

//    public List<List<Integer>> threeSum(int[] nums) {
//        int n = nums.length;
//        List<List<Integer>> ans = new ArrayList<>();
//
//        Arrays.sort(nums);
//
//        for(int i=0; i<n; i++){
//            if (i > 0 && nums[i] == nums[i-1]) {
//                continue;
//            }
//
//            int j = i + 1;
//            int k = n - 1;
//
//            while (j < k) {
//                int sum = nums[i] + nums[j] + nums[k];
//
//                if(sum == 0){
//                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                    j++;
//                    while (nums[j] == nums[j-1] && j < k) {
//                        j++;
//                    }
//                } else if(sum < 0){
//                    j++;
//                } else {
//                    k--;
//                }
//            }
//        }
//        return ans;
//    }
}
