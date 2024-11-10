package org.akhil;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "(()())(())(()(()))";

        System.out.println(removeOuterParentheses(s));
        System.out.println(removeOuterParentheses1(s));
    }

    public static String removeOuterParentheses(String s) {
        int length = s.length();
        if(length < 2){
            return s;
        }

        Stack<Character> stack = new Stack<>();
        int startIndex = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<length; i++){
            // If ')' then check is corresponding '(' is available in stack or not
            if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    return s;
                }
                char ch = stack.peek();
                if(ch == '('){
                    stack.pop();
                }
            } else {
                // if '(' then add to stack
                stack.push(s.charAt(i));
            }

            // after iteration is stack became empty that means valid parentheses strings is found.
            if(stack.isEmpty()){
                sb.append(s.substring(startIndex+1, i));
                startIndex = i+1;
            }
        }
        return sb.toString();
    }

    // Another approach for this is using stringBuilder where we can explicitly keep track of first '(' and its corresponding ')'
    // and exclude it from final answer.

    public static String removeOuterParentheses1(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int counter = 0;

        for(char ch:s.toCharArray()){
            if(ch == '('){
                if(counter>0){  // counter will be 0 for first '(' hence we will skip this from result.
                    sb.append(ch);
                }
                counter++;
            } else {
                counter--;      // first decrement counter to check if this closing bracket is for first '(' or not.
                if(counter>0){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}