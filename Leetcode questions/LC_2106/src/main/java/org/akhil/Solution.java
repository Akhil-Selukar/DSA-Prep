package org.akhil;

public class Solution {
    // Solution 1 - Using binary search
    // O(N + KlogN)/O(N)
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int result = 0;

        int[] prefixSum = new int[n];
        int[] indices = new int[n];         // to apply binary search and find range of travel

        // Build prefix sum and extract indices
        for (int i = 0; i < n; i++) {
            indices[i] = fruits[i][0];      // add index only
            prefixSum[i] = fruits[i][1] + (i > 0 ? prefixSum[i - 1] : 0);       // prefixSum of fruits only
        }

        // till k/2 only because after that if we turn back we will not be able to go beyond starting point
        // and there is point in turning back only if we can go back beyond starting point to collect more fruits
        for(int i=0; i<=k/2; i++) {
            // case 1 - move left first till i steps and turn back.
            int leftStart = startPos - i;
            int rightEnd = startPos + (k-(2*i));

            // find the range (as it is not necessary that at all leftStart and rightEnd fruits will be there.
            int left = lowerBound(indices, leftStart);
            int right = upperBound(indices, rightEnd) - 1;

            if (left <= right) {
                int totalFruitsInRange = prefixSum[right] - (left > 0 ? prefixSum[left - 1] : 0);
                result = Math.max(result, totalFruitsInRange);
            }

            // case 2 - move right first till ith step and then turn back
            leftStart = startPos - (k -(2*i));
            rightEnd = startPos + i;

            left = lowerBound(indices, leftStart);
            right = upperBound(indices, rightEnd) - 1;

            if (left <= right) {
                int totalFruitsInRange = prefixSum[right] - (left > 0 ? prefixSum[left - 1] : 0);
                result = Math.max(result, totalFruitsInRange);
            }
        }

        return result;
    }


    private int lowerBound(int[] arr, int target) {
        int start = 0, end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private int upperBound(int[] arr, int target) {
        int start = 0, end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
