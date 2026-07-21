package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Here the important thing is 1 transaction/operation consists of both the steps (i.e. converting 1 to 0 and then converting 0 to 1 again)
    // We are allowed at max 1 operation.
    // So to perform this we need to first find out a group/section of 1 which is surrounded by 0 then only that 1 can be converted to 0.
    // Now as we want to maximize the active sessions (i.e. count of 1), eventually we will be converting 0 to 1 to maximize the count of 1
    // So we need to find out 0's surrounded by 1 which are maximum (then only those 0's can be converted to 1 in 2nd step of transaction)
    // Hence ultimately the problem becomes find out a section of 1 which is surrounded by the most numbers of 0's or in other words
    // find out two sections of 0's on either side of a section of 1 which has max number of zeros in it.
    // These will be the 0's we will be converting to 1 and maximizing the active sessions
    // also we need to count already active sessions as well as those also will be counted in result.

    // O(N)/O(N)
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        List<Integer> section0Count = new ArrayList<>();
        int count1 = 0;

        // calculate 0's in each section and total count of 1's
        int i=0;
        while(i<n){
            char ch = s.charAt(i);
            if (ch == '0') {
                int count = 0;
                while(i<n && s.charAt(i) == '0'){
                    count++;
                    i++;
                }
                section0Count.add(count);
            } else {
                count1++;
                i++;
            }
        }

        // find consecutive sections which gives max number of 0's
        int maxZeros = 0;
        for(int j=1; j<section0Count.size(); j++){
            int firstSection = section0Count.get(j-1);
            int secondSection = section0Count.get(j);

            maxZeros = Math.max(maxZeros, firstSection + secondSection);
        }

        return maxZeros + count1;
    }
}
