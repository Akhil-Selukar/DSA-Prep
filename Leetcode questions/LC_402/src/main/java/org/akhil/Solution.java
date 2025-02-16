package org.akhil;

import java.util.Stack;

public class Solution {

    // O(N)/O(1)
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<num.length(); i++){
            char digit = num.charAt(i);
            while(k>0 && !stack.isEmpty() && stack.peek() > digit){
                stack.pop();
                k--;
            }
                stack.push(digit);
        }

        // if k elements were not removed in above loop then remove remaining elements from stack.
        while(k>0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for(char ch:stack){
            sb.append(ch);
        }

        while(!sb.isEmpty() && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }
}
