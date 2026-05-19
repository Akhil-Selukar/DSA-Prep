package org.akhil;

public class Solution {
    // O(Min(m, n))/O(1)
    public int getCommon(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int p1 = 0;
        int p2 = 0;

        while(p1 < m && p2 < n){
            if(nums1[p1] == nums2[p2]){
                return nums1[p1];
            }

            if(nums1[p1] < nums2[p2]){
                p1++;
            } else {
                p2++;
            }
        }
        return -1;
    }
}
