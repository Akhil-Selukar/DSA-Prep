package org.akhil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }


    // Solution 1 - O(N^2)/O(1)
//    public static int[] twoSum(int[] nums, int target) {
//        int[] ans = new int[2];
//
//        for(int i=0; i<nums.length; i++){
//            for(int j=i+1; j<nums.length; j++){
//                if(target == (nums[i] + nums[j])){
//                    ans[0] = i;
//                    ans[1] = j;
//                    break;
//                }
//            }
//        }
//        return ans;
//    }


    // Solution 2 - O(N)/O(N)
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> freq = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            freq.put(nums[i], i);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (freq.containsKey(target - nums[i]) && freq.get(target - nums[i]) != i) {
//                return new int[]{i, freq.get(target - nums[i])};
//            }
//        }
//
//        return new int[]{-1, -1};
//    }


    // Solution 3 - optimized O(N)/O(N)
    // As it is mentioned that order of indices in answer does not matter, hence we can use only 1 for loop and do map population as well as
    // checking for counterpart at once.
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int counterPart = target - nums[i];

            if(freq.containsKey(counterPart)){
                return new int[]{i, freq.get(counterPart)};
            }
            freq.put(nums[i], i);
        }

        return new int[]{-1,-1};
    }
}