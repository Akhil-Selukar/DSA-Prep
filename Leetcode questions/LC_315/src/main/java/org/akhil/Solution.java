package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Solution 1 - Bruteforce
    // O(N^2)/O(N)
//    public List<Integer> countSmaller(int[] nums) {
//        int n = nums.length;
//        List<Integer> result = new ArrayList<>();
//
//        for(int i=0; i<n; i++){
//            int num = nums[i];
//            int count = 0;
//            for(int j=i+1; j<n; j++){
//                if(nums[j] < num){
//                    count++;
//                }
//            }
//            result.add(count);
//        }
//        return result;
//    }


    // Solution 2 - Using binary search (Accepted)
    // O(N^2)/O(N)
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();

        for(int i=nums.length-1; i>=0; i--){
            int indexInserted = binarySearch(sorted, nums[i]);
//            result.add(0, indexInserted);   // this gives TLE as it involves shifting
            result.add(indexInserted);
        }

//        return result;    // this gives TLE as we are shifting elements inside loop
        sorted.clear();
        for(int i=result.size()-1; i>=0; i--){
            sorted.add(result.get(i));
        }
        return sorted;
    }

    private int binarySearch(List<Integer> sorted, int num){
        int start = 0;
        int end = sorted.size()-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(sorted.get(mid) < num){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        sorted.add(start, num);         // Even after binary search the time complexity is O(N^2) because of this. Here it involves shifting of elements which can be O(N) i.e. shifting of all elements and adding new value at 0th index.
        return start;
    }
}
