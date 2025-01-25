package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // solution-1 (gives TLE)
//    public int longestConsecutive(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//
//        for(int num:nums){
//            set.add(num);
//        }
//
//        int longest = 0;
//
//        for(int num:nums){
//            int length = 1;
//            while(set.contains(num-length)){
//                length++;
//            }
//
//            longest = Math.max(longest, length);
//        }
//
//        return longest;
//    }

    // solution 2
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num:nums){
            set.add(num);
        }

        int longest = 0;

        for(int num:set){                   // loop over set as no need to check for duplicate elements again and again.
            if(!set.contains(num-1)){       // That means current num is my starting point and length can be considered as 1 from here.
                int length = 1;

                while(set.contains(num+length)){    // check how many consecutive elements are present.
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
