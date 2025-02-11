package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // O(81)/O(1) i.e. O(1)/O(1)
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if (n > 12) {
            return new ArrayList<>();
        }
        int index = 0;
        int parts = 0;
        List<String> ans = new ArrayList<>();

        helper(s, index, parts, ans, "");

        return ans;
    }

    private void helper(String s, int index, int parts, List<String> ans, String temp) {
        if(parts == 4 && index == s.length()){
            ans.add(temp);
        }
        if(parts > 4){
            return;
        }

        for(int i=1; i<4; i++){
            if(index + i > s.length()){
                break;
            }

            String subStr = s.substring(index, index+i);

            if((subStr.length() > 1 && subStr.startsWith("0")) || (i==3 && Integer.parseInt(subStr) > 255)){
                continue;
            }
            helper(s, index+i, parts+1, ans, temp+subStr+(parts==3?"":"."));
        }
    }
}
