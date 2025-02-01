package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // O(N)/O(N)
    public List<String> summaryRanges(int[] nums) {
        // int[] nums = {0,1,2,4,5,7};
        List<String> answer = new ArrayList<>();
        if(nums.length==0){
            return answer;
        }

        int start = 0;
        int end = 0;
        int diff = 0;

        while(end < nums.length){
            if(nums[end] - nums[start] == diff){
                diff++;
                end++;
            } else {
                StringBuilder sb = new StringBuilder();
                if(end-start > 1) {
                    sb.append(nums[start]);
                    sb.append("->");
                    sb.append(nums[end-1]);
                } else {
                    sb.append(nums[start]);
                }
                answer.add(sb.toString());
                start = end;
                diff = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(end-start > 1) {
            sb.append(nums[start]);
            sb.append("->");
            sb.append(nums[end-1]);
            answer.add(sb.toString());
        } else {
            sb.append(nums[start]);
            answer.add(sb.toString());
        }
        return answer;
    }
}
