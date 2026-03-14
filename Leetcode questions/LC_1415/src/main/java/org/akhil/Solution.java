package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution 1 - Using backtracking
    // O(n*2^n)/O(n*2^n)
//    public String getHappyString(int n, int k) {
//        List<String> resultList = new ArrayList<>();
//
//        helper(n, resultList, new StringBuilder());
//
//        return resultList.size() >= k ? resultList.get(k-1) : "";
//    }
//    private void helper(int n, List<String> result, StringBuilder sb){
//        if(sb.length() == n){
//            result.add(sb.toString());      // O(n)
//            return;
//        }
//
//        for(char i='a'; i<='c'; i++){       // O(3)
//            if(sb.length() > 0 && sb.charAt(sb.length()-1) == i){
//                continue;
//            }
//
//            sb.append(i);
//            helper(n, result, sb);
//            sb.deleteCharAt(sb.length()-1);
//        }
//    }


    // ------------------------
    // Solution 2 - Using backtracking (with early exit condition)
    // O(n*2^n)/O(n*2^n)
    public String getHappyString(int n, int k) {
        List<String> resultList = new ArrayList<>();

        helper(n, k, resultList, new StringBuilder());

        return resultList.size() >= k ? resultList.get(k-1) : "";
    }
    private void helper(int n, int k, List<String> result, StringBuilder sb){
        // Early exit -> No need to generate more strings if we have generated the kth one
        if(result.size() >= k){
            return;
        }

        if(sb.length() == n){
            result.add(sb.toString());      // O(n)
            return;
        }

        for(char i='a'; i<='c'; i++){       // O(3)
            if(sb.length() > 0 && sb.charAt(sb.length()-1) == i){
                continue;
            }

            sb.append(i);
            helper(n, k, result, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
