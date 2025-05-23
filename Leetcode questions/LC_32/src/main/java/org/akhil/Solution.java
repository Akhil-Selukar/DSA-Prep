package org.akhil;

import java.util.Stack;

public class Solution {

    // Solution 1 - Using stack
    // TC -> O(N)
    // SC -> O(N)
//    public int longestValidParentheses(String s) {
//        Stack<Integer> stack = new Stack<>();
//
//        for(int i=0; i<s.length(); i++){
//            if(!stack.isEmpty() && s.charAt(i) == ')' && s.charAt(stack.peek()) == '('){
//                stack.pop();
//            } else {
//                stack.push(i);
//            }
//        }
//
//        int maxLength = 0;
//        int lastIndex = -1;     // to handle edge case (longest valid at start)
//
//        for(int i:stack){       // iterating over stack this is NOT FILO
//            maxLength = Math.max(maxLength, i-lastIndex-1);
//            lastIndex = i;
//        }
//
//        // edge case (longest valid at the end)
//        maxLength = Math.max(maxLength, s.length()-lastIndex-1);
//
//        return maxLength;
//    }


    // Solution 2 - without stack using just count.
    // We can traverse the string from both the directions and find the longest valid string.
    // TC -> O(N)
    // SC -> O(1)
    // As no stack operations and complex conditions are involved, this solution is faster as well even though the TC is same.
    public int longestValidParentheses(String s) {

        int openCount = 0;
        int closeCount = 0;
        int maxLength = 0;

        // traversing from left to right
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                openCount++;
            } else {
                closeCount++;
            }

            // if string is valid the check maxLength
            if(openCount == closeCount){
                maxLength = Math.max(maxLength, openCount*2);
            } else if(closeCount > openCount){  // if closeCount is more then reset
                openCount = 0;
                closeCount = 0;
            }
        }

        // traverse from right to left (to handle edge case of maxLength valid string is at end)

        // reset the values
        openCount = 0;
        closeCount = 0;

        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) == '('){
                openCount++;
            } else {
                closeCount++;
            }

            // if string is valid the check maxLength
            if(openCount == closeCount){
                maxLength = Math.max(maxLength, openCount*2);
            } else if(openCount > closeCount){  // IMPORTANT (reversed condition as we are checking in reversed direction now.
                openCount = 0;
                closeCount = 0;
            }
        }

        return maxLength;
    }
}
