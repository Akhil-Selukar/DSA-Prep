package org.akhil;

import java.util.Stack;

public class Solution {
    // Solution 1 - bruteforce (TLE)
    // O(N^2)/O(N) -> in worst case we might have to remove N/2 stars and result will be empty string (hence N^2)
    // while loop will run N/2 times and each time to compare and identify the index we need O(N)
    // public String removeStars(String s) {
    //     StringBuilder sb = new StringBuilder(s);

    //     while(sb.toString().contains("*")){
    //         int startIndex = sb.toString().indexOf("*");
    //         sb.delete(startIndex-1, startIndex+1);
    //     }

    //     return sb.toString();
    // }

    //----------------

    // Solution 2 - Using stack
    // O(N)/O(N)
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch:s.toCharArray()){
            if(ch == '*'){
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
