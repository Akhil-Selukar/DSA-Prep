package org.akhil;

// Solution 1 - Bruteforce (TLE)
//public class FindSumPairs {
//
//    int[] nums1;
//    int[] nums2;
//    public FindSumPairs(int[] nums1, int[] nums2) {
//        this.nums1 = nums1;
//        this.nums2 = nums2;
//    }
//
//    public void add(int index, int val) {
//        nums2[index] = nums2[index]+val;
//    }
//
//    public int count(int tot) {
//        int count = 0;
//        for(int i=0; i<nums1.length; i++){
//            for(int j=0; j<nums2.length; j++){
//                if(nums1[i] + nums2[j] == tot){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//}


import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {

    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> freq = new HashMap<>();

    // O(N2)/O(N2)
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        for(int val:nums2){
            freq.put(val, freq.getOrDefault(val, 0)+1);
        }
    }

    // O(1)/O(1)
    public void add(int index, int val) {
        int oldValue = nums2[index];
        freq.put(oldValue, freq.get(oldValue)-1);

        int newValue = nums2[index]+val;

        freq.put(newValue, freq.getOrDefault(newValue, 0)+1);
        nums2[index] = newValue;
    }

    // O(N1)/O(1)
    public int count(int tot) {
        int count = 0;
        for(int i=0; i<nums1.length; i++){
            int nums2Key = tot - nums1[i];

            count = count+freq.getOrDefault(nums2Key, 0);
        }

        return count;
    }
}
