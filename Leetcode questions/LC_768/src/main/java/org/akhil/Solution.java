package org.akhil;

import java.util.Arrays;

public class Solution {
    // Exact same code and concept as that of LC-769 just 1 line change.
    // O(NlogN)/O(N)
    public int maxChunksToSorted(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);        // change
        Arrays.sort(copy);

        int n = arr.length;
        int count = 0;

        int expectedSum = 0;
        int actualSum = 0;

        for (int i = 0; i < n; i++) {
            expectedSum = expectedSum + copy[i];
            actualSum = actualSum + arr[i];

            if (expectedSum == actualSum) {
                count++;
            }
        }
        return count;
    }
}
