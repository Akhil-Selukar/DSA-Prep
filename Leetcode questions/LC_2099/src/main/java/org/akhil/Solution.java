package org.akhil;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    // Solution 1 - bruteforce using priority queue
    // O(NlogK)/O(K)
//    public int[] maxSubsequence(int[] nums, int k) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a-b);
//
//        for(int i=0; i<nums.length; i++){         // O(N)
//            if(queue.size() < k){
//                queue.add(nums[i]);               // O(logK)
//                continue;
//            }
//
//            if(queue.peek() < nums[i]){
//                queue.poll();                     // O(logK)
//                queue.offer(nums[i]);             // O(logK)
//            }
//        }
//
//        int[] result = new int[k];
//        int index = 0;
//
//        for(int i=0; i<nums.length; i++){             // O(N)
//            if(queue.contains(nums[i])){              // O(logK)
//                result[index++] = nums[i];
//                queue.remove(nums[i]);                // O(logK)
//            }
//        }
//
//        return result;
//    }


    // Solution 2 - Using sorted helper array. (even though the time complexity looks similar (not same) still this one is faster and less complex)
    // O(NlogN)/O(N)
    public int[] maxSubsequence(int[] nums, int k) {
        int[] result = new int[k];
        int[] helper = Arrays.copyOf(nums, nums.length);            // O(N)

        // sort helper array
        Arrays.sort(helper);                                        // O(NlogN)

        // find the lowest value which can be present in answer
        int lowestAllowed = helper[nums.length - k];
        int countOfLowest = 0;      // in case duplicates are present

        // count the number of times threshold can be a part of result
        for(int i=nums.length-1; i>=nums.length-k; i--){                // O(K)
            if(helper[i] == lowestAllowed){
                countOfLowest++;
            }
        }

        // populate result array
        int index = 0;
        for(int i=0; i<nums.length; i++){                               // O(N)
            if(nums[i] > lowestAllowed){
                result[index++] = nums[i];
            } else if(nums[i] == lowestAllowed && countOfLowest > 0){
                result[index++] = nums[i];
                countOfLowest--;
            }

            if(index == k){
                break;
            }
        }

        return result;
    }
}
