package org.akhil;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token:tokens){
            switch(token){
                case "+":{
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second + first);
                    break;
                }
                case "-":{
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second - first);
                    break;
                }
                case "*":{
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second * first);
                    break;
                }
                case "/":{
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second / first);
                    break;
                }
                default:{
                    stack.push(Integer.parseInt(token));
                }
            }
        }
        return stack.pop();
    }
}
