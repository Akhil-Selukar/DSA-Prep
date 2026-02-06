package org.example;

import java.util.TreeSet;

public class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        // Sort by value first, then index
        TreeSet<Integer> currentSet = new TreeSet<>((a, b) -> {
            if (nums[a] != nums[b]){
                return nums[a] - nums[b];
            }
            return a-b;
        });

        TreeSet<Integer> entireSet = new TreeSet<>((a, b) -> {
            if (nums[a] != nums[b]){
                return nums[a] - nums[b];
            }
            return a-b;
        });

        long result = Long.MAX_VALUE;
        long currSum = 0; // sum of cost of all subarays in current window

        // populate current possible window
        for(int i=1; i<=dist+1; i++) {
            currentSet.add(i);
            currSum += nums[i];
        }

        while(currentSet.size() > k-1) {
            int ind = currentSet.pollLast();
            currSum -= nums[ind];
            entireSet.add(ind);
        }

        result = currSum;
        // O(n*logn)
        for(int i=1; i < n-1-dist; i++) {
            int rightInd = i+dist+1;
            int leftInd = i;
            if(currentSet.contains(leftInd)) {
                currSum -= nums[leftInd];
                currentSet.remove(leftInd);
                currSum += nums[rightInd];
                currentSet.add(rightInd);
            }
            else {
                entireSet.remove(leftInd);
                entireSet.add(rightInd);
            }

            // balancing
            if(entireSet.size() > 0) {
                int minF = entireSet.first();
                int maxC = currentSet.last();
                if(nums[minF] < nums[maxC]) {
                    currSum -= nums[maxC];
                    currentSet.remove(maxC);
                    currentSet.add(minF);
                    currSum += nums[minF];
                    entireSet.remove(minF);
                    entireSet.add(maxC);
                }
            }

            result = Math.min(result, currSum);
        }

        return result + nums[0];
    }
}
