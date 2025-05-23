package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution 1 - using String (as String is immutable hence we dont need to backtrack here, but as every time new String object is created hence the solution is little bit slow and memory consuming even though time and space complexity will be same)
//    public List<String> generateParenthesis(int n) {
//        List<String> answer = new ArrayList<>();
//        int openP = 0;
//        int closeP = 0;
//        helper(n, openP, closeP, "", answer);
//
//        return answer;
//    }
//
//    private void helper(int n, int openP, int closeP, String temp, List<String> answer) {
//        if(openP == n && closeP == n){
//            answer.add(temp);
//            return;
//        }
//
//        if(openP < n){
//            helper(n, openP+1, closeP, temp + "(", answer);
//        }
//
//        if(closeP < openP){
//            helper(n, openP, closeP+1, temp + ")", answer);
//        }
//    }

    // Solution 2 - Using stringBuilder (here backtracking will be required)
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n, 0, 0, sb, answer);

        return answer;
    }

    private void helper(int n, int openP, int closeP, StringBuilder sb, List<String> answer) {
        if(openP == n && closeP == n){
            answer.add(sb.toString());
            return;
        }

        if(openP < n){
            helper(n, openP+1, closeP, sb.append("("), answer);
            sb.deleteCharAt(sb.length()-1);
        }

        if(closeP < openP){
            helper(n, openP, closeP+1, sb.append(")"), answer);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
