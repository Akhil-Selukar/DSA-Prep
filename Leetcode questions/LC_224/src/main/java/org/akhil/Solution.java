package org.akhil;

import java.util.Stack;

public class Solution {

    // Solution - using stack
    // O(N)/O(N)
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int number = 0;
        int sign = 1;       // 1 means +ve and -1 means -ve
        int result = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            // if it is a space then skip it
            if(ch == ' '){
                continue;
            }

            // if it is a digit then construct number out of it.
            if(Character.isDigit(ch)){
                number = number * 10 + ch-'0';          // this is because we might have 13 + 2 so to form 13 we have to do this.
            } else if(ch == '+'){
                result = result + (sign * number);
                sign = 1;
                number = 0;     // because earlier number is now added into result.
            } else if(ch == '-'){
                result = result + (sign * number);
                sign = -1;
                number = 0;
            } else if(ch == '('){
                // store current value of result and sign in stack
                stack.push(result);
                stack.push(sign);

                // start new computation
                number = 0;
                result = 0;
                sign = 1;
            } else if(ch == ')'){
                result = result + (sign*number);
                // if we have closing bracket, that means the bracket is resolved so we have to pull result stored in stack and add it to current result from bracket
                int stackSign = stack.pop();
                result = (result * stackSign) + stack.pop();
                number = 0;
            }
        }
        result += (sign*number);
        return result;
    }
}
