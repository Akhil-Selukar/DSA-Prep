package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - (O(N^4)/O(1)) TLE
//    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
//        int count = 0;
//        for(int i=0; i<nums1.length; i++){
//            for(int j=0; j<nums2.length; j++){
//                for(int k=0; k<nums3.length; k++){
//                    for(int l=0; l<nums4.length; l++){
//                        if(nums1[i]+nums2[j]+nums3[k]+nums4[l] == 0){
//                            count++;
//                        }
//                    }
//                }
//            }
//        }
//        return count;
//    }


    // Solution 2 - O(N^3)/O(N) Still TLE
//    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
//        int count = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int l=0; l<nums4.length; l++){
//            map.put(nums4[l], map.getOrDefault(l, 0)+1);
//        }
//
//        for(int i=0; i<nums1.length; i++){
//            for(int j=0; j<nums2.length; j++){
//                for(int k=0; k<nums3.length; k++){
//                    count = count + map.getOrDefault(-(nums1[i] + nums2[j] + nums3[k]), 0);
//                }
//            }
//        }
//        return count;
//    }


    // Solution 3 - (O(N^2)/O(N^2))
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int k=0; k<nums3.length; k++){
            for(int l=0; l<nums4.length; l++){
                map.put(nums4[l] + nums3[k], map.getOrDefault(nums4[l] + nums3[k], 0)+1);
            }
        }

        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                    count = count + map.getOrDefault(-(nums1[i] + nums2[j]), 0);
            }
        }
        return count;
    }
}
