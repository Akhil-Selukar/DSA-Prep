package org.akhil;

import java.util.Stack;

public class Solution {
    // O(N^2)/O(N)
    public String reverseParentheses(String s) {
        Stack<Integer> temp = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                temp.push(result.length());
            } else if (ch == ')') {
                int start = temp.pop();
                reverse(result, start, result.length() - 1);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
