package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // (O(N*2^N)/O(2^N))
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> answer = new ArrayList();

        // iterate over string
        for(int i=0; i<expression.length(); i++){

            // if String is numbers only string then do nothing
            if(Character.isDigit(expression.charAt(i))){
                continue;
            }

            char operation = expression.charAt(i);      // if not number, then find the operator

            if (operation == '+' || operation == '-' || operation == '*') {
                String leftStr = expression.substring(0, i);                        // split the string (left part of operator)
                String rightStr = expression.substring(i+1, expression.length());   // Split the string (right part of operator)

                List<Integer> leftAns = diffWaysToCompute(leftStr);             // Solve left part individually
                List<Integer> rightAns = diffWaysToCompute(rightStr);           // Solve right part individually

                // Operate on result of left and right part based on operator.
                for (int val1 : leftAns) {
                    for (int val2 : rightAns) {
                        if (operation == '+') answer.add(val1 + val2);
                        if (operation == '-') answer.add(val1 - val2);
                        if (operation == '*') answer.add(val1 * val2);
                    }
                }
            }
        }

        // if the expression string has no operator then the entire string is a number and parenthesis can not be added.
        // Hence the answer will be the number which has in the string.
        if(answer.isEmpty()){
            answer.add(Integer.parseInt(expression));
        }

        // Finally return the answer.
        return answer;
    }
}
