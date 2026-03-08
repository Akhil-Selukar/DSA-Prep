package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String findDifferentBinaryString(String[] nums) {

        int n = nums.length;
        Set<String> set = new HashSet<>();

        for(String s:nums){
            set.add(s);
        }

        for(int i=0; i<n; i++){
            String str = nums[i]+nums[i];

            int startIndex = 0;
            while(startIndex + n <= str.length()){
                String subStr = str.substring(startIndex, startIndex+n);
                if(!set.contains(subStr)){
                    return subStr;
                }
                startIndex++;
            }
        }

        return null;
    }
}
