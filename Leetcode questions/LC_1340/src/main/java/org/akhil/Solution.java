package org.akhil;

import java.util.Arrays;

public class Solution {
    // O(N*D)/O(N)
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] jumps = new int[n];       // stores indices we can visit if start from ith index.

        Arrays.fill(jumps, -1);

        // start from every index and check how many indices we can visit
        for(int i=0; i<n; i++){
            jumps[i] = simulateJumps(arr, d, i, jumps);
        }

        // compute max out of all possible answers
        int result = 1; // atleast we can stand of any 1 index initially
        for(int val:jumps){
            result = Math.max(result, val);
        }

        return result;
    }

    private int simulateJumps(int[] arr, int d, int currIndex, int[] jumps){
        if(jumps[currIndex] != -1){             // if we already have value for this index then no need to calculate further
            return jumps[currIndex];
        }

        jumps[currIndex] = 1;   // standing at currIndex;

        // explore left side till d indices
        for(int i=currIndex-1; i>=0 && currIndex-i <= d; i--){
            if(arr[i] < arr[currIndex]){    // we can only jump if height of destination index is strictly less than curr height
                jumps[i] = simulateJumps(arr, d, i, jumps); // calculate answer for next index where we can jump
                jumps[currIndex] = Math.max(jumps[currIndex], jumps[i]+1);      // +1 because we need to count currIndex as well
            } else {
                break;  // cant jump any further because i index will act as wall
            }
        }

        // explore right side till d indices
        for(int i=currIndex+1; i<arr.length && i-currIndex <= d; i++){
            if(arr[i] < arr[currIndex]){
                jumps[i] = simulateJumps(arr, d, i, jumps);
                jumps[currIndex] = Math.max(jumps[currIndex], jumps[i]+1);
            } else {
                break;
            }
        }

        return jumps[currIndex];    // whatever max value we got for currIndex after exploring all possibilities in both directions
    }
}
