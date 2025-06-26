package org.akhil;

import java.util.Arrays;

public class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int offset1 = 0;
        int offset2 = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int p1 = 0;
        int p2 = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        long result = 0;

        while(k > 0){
            result = (long) nums1[p1] * nums2[p2];

            if(nums1[p1] <= nums2[p2]){
                p2++;
            } else {
                p1++;
            }

            if(p1 == n1){
                p1 = offset1+1;
            }
            if(p2 == n2){
                p2 = offset2+1;
            }
            k--;
        }

        return result;
    }
}
