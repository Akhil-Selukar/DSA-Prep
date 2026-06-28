package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - Using sorting
    // O(NlogN)/O(1)
//    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
//        Arrays.sort(arr);
//        int result = 1;     // as it is mentioned that index 0 value has to be 1 so answer will be atleast 1.
//        arr[0] = 1;
//        for(int i=1; i<arr.length; i++){
//            if(Math.abs(arr[i] - arr[i-1]) > 1){
//                arr[i] = arr[i-1]+1;
//            }
//            result = Math.max(result, arr[i]);
//        }
//        return result;
//    }

    // -----------------------------------------
    // Solution 2 - Count sort technique
    // As it is given that index 0 element will be 1 and difference between two adjacent element can not be greater than 1.
    // Another important thing given is we want to find the maximum possible value so we will always try to keep the difference 1 rather than 0.
    // Hence we can conclude that the max possible value can not be greater than n in an element of length n.
    // so we can use count sort to find the max possible.
    // O(N)/O(N)
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] count = new int[n + 1];

        // find count of all elements
        // if any element is > n then consider it as n and add its count in nth index.
        for (int a : arr) {
            count[Math.min(a, n)]++;
        }

        int result = 1;
        for (int i=2; i<=n; i++) {
            // count[i] elements available at value i — each can extend ans by 1
            int next = result + count[i];
            // Can't exceed i itself (can only decrement, not increment)
            result = Math.min(i, next);
        }
        return result;
    }
}
