package org.akhil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    // Solution 1 - TLE
    // O(2^N)
//    public List<String> removeInvalidParentheses(String s) {
//        List<String> result = new ArrayList<>();
//
//        // calculate allowed skips
//        int skipAllowed = 0;
//        Stack<Character> stack = new Stack<>();
//
//        for(char ch:s.toCharArray()){
//            if(ch != '(' && ch != ')'){
//                continue;
//            }
//            if(ch == ')' && !stack.isEmpty() && stack.peek() == '('){
//                stack.pop();
//            } else {
//                stack.push(ch);
//            }
//        }
//        skipAllowed = stack.size();
//
//        helper(s, 0, skipAllowed, new StringBuilder(), result, 0);
//
//        return result;
//    }
//
//    private void helper(String s, int i, int skipAllowed, StringBuilder sb, List<String> result, int openCount) {
//        if(i < s.length() && s.charAt(i) == ')' && openCount == 0 && skipAllowed == 0){
//            return;
//        }
//
//        if(i >= s.length() && openCount == 0){
//            if(!result.contains(sb.toString())) {
//                result.add(sb.toString());
//            }
//            return;
//        }
//
//        if(i >= s.length()){
//            return;
//        }
//
//        if(s.charAt(i) != '(' && s.charAt(i) != ')'){
//            sb.append(s.charAt(i));
//            helper(s, i+1, skipAllowed, sb, result, openCount);
//            sb.deleteCharAt(sb.length()-1);
//        }
//
//        if(skipAllowed > 0){
//            helper(s, i+1, skipAllowed-1, sb, result, openCount);
//        }
//
//        if(s.charAt(i) == '('){
//            sb.append(s.charAt(i));
//            helper(s, i+1, skipAllowed, sb, result, openCount+1);
//            sb.deleteCharAt(sb.length()-1);
//        }
//
//        if(s.charAt(i) == ')' && openCount > 0){
//            sb.append(s.charAt(i));
//            helper(s, i+1, skipAllowed, sb, result, openCount-1);
//            sb.deleteCharAt(sb.length()-1);
//        }
//    }

    // ------------------------

    // Solution 2 - similar concept but much easier implementation
    // TC -> O(N!) SC-> O(N)   TLE
//    public List<String> removeInvalidParentheses(String s) {
//        List<String> result = new ArrayList<>();
//
//        // calculate allowed skips or number of invalid brackets
//        int invalidCount = getInvalidParentheses(s);
//
//        helper(s, invalidCount, result);
//        return result;
//    }
//
//    private int getInvalidParentheses(String s) {
//        Stack<Character> stack = new Stack<>();
//
//        for(char ch:s.toCharArray()){
//            if(ch != '(' && ch != ')'){
//                continue;
//            }
//            if(ch == ')' && !stack.isEmpty() && stack.peek() == '('){
//                stack.pop();
//            } else {
//                stack.push(ch);
//            }
//        }
//        return stack.size();
//    }
//
//    private void helper(String s, int invalidCount, List<String> result) {
//
//        if(invalidCount < 0){
//            return;
//        }
//
//        if(invalidCount == 0){
//            if(0 == getInvalidParentheses(s) && !result.contains(s)) {
//                result.add(s);
//            }
//            return;
//        }
//
//        for(int i=0; i<s.length(); i++)
//        {
//            String leftStr = s.substring(0,i);
//            String rightStr = s.substring(i+1);
//            helper(leftStr+rightStr, invalidCount-1, result);
//        }
//
//    }


    // ------------------------

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        // calculate allowed skips or number of invalid brackets
        int invalidCount = getInvalidParentheses(s);

        helper(s, invalidCount, result);
        return result;
    }

    private int getInvalidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int openCount = 0;
        int closeCount = 0;
        for(char ch:s.toCharArray()){
            if(ch != '(' && ch != ')'){
                continue;
            }
            if(ch == '('){
                openCount++;
            } else {
                closeCount++;
            }
            if(ch == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        if(openCount == 0 || closeCount == 0){
            return -1;
        }
        return stack.size();
    }

    private void helper(String s, int invalidCount, List<String> result) {

        if(invalidCount < 0){
            return;
        }

        if(invalidCount == 0){
            if(0 == getInvalidParentheses(s) && !result.contains(s)) {
                result.add(s);
            }
            return;
        }

        int canSkipCount = 0; // to prevent checking for each string
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == '('){
                canSkipCount++;
            }
            if(s.charAt(i) == ')'){
                canSkipCount--;
            }
            if(canSkipCount >= 0) {
                String leftStr = s.substring(0, i);
                String rightStr = s.substring(i + 1);
                helper(leftStr + rightStr, invalidCount - 1, result);
            }
        }

    }
}
