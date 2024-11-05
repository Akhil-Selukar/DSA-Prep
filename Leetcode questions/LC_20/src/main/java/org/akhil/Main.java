package org.akhil;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "()[]{}";

        System.out.println(isValid(s));
    }

    // Approach 1: brute force

//    public static boolean isValid(String s) {
//        while (true) {
//            if (s.contains("()")) {
//                s = s.replace("()", "");
//            } else if (s.contains("{}")) {
//                s = s.replace("{}", "");
//            } else if (s.contains("[]")) {
//                s = s.replace("[]", "");
//            } else {
//                return s.isEmpty();
//            }
//        }
//    }

    // Approach 2: using stack

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char ch:s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            } else {
                if(ch == ')'){
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                }
                if(ch == '}'){
                    if(stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                }
                if(ch == ']'){
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}