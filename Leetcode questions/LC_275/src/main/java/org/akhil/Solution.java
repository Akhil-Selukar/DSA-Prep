package org.akhil;

public class Solution {

    // Solution 1 - bruteforce
    // O(N)/O(1)
//    public int hIndex(int[] citations) {
//        int n = citations.length;
//
//        for(int i=0; i<n; i++){
//            if(citations[i] >= n-i){
//                return n-i;
//            }
//        }
//        return 0;
//    }

    // Solution 2 - Using binary search
    // As given array is sorted and we have a condition 'citations[i] >= n-i' we can use binary search here.
    // O(logN)/O(1)
    public int hIndex(int[] citations) {
        int n = citations.length;
        int start = 0;
        int end = n-1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(citations[mid] >= n-mid){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return start == n ? 0 : n-start;
    }
}
