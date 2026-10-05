package org.akhil;

import java.util.Stack;

public class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();

        int score = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(score);
                score = 0;
            } else {
                if (s.charAt(i - 1) == '(') { // this is the innermost pair hence add 1 to score
                    score = stack.peek() + 1;
                } else {
                    // whatever score we have till now double it.
                    score = stack.peek() + (2 * score);
                }
                stack.pop();
            }
        }
        return score;
    }
}
