package org.akhil;

import java.util.Stack;

public class Solution {

    // Solution 1 - Bruteforce
    // O(N)/O(N) Even though the time and space complexity is O(N)/O(N) still this is not optimized solution.
//    public String makeFancyString(String s) {
//        int n = s.length();
//        if(n <= 2){
//            return s;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        Stack<Character> stack = new Stack<>();
//        int index = 0;
//
//        while(index < n){
//            stack.push(s.charAt(index++));
//
//            int repeatCount = 1;
//            while(index < n && stack.peek() == s.charAt(index)){
//                if(repeatCount < 2) {
//                    stack.push(s.charAt(index++));
//                    repeatCount++;
//                } else {
//                    index++;
//                }
//            }
//        }
//
//        while(!stack.isEmpty()){
//            sb.append(stack.pop());
//        }
//
//        return sb.reverse().toString();
//    }


    // Solution 2 - Iterative approach
    // O(N)/O(N)    - better than first one but still not completely optimized
//    public String makeFancyString(String s) {
//        int n = s.length();
//        if(n <= 2){
//            return s;
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        for(char ch:s.toCharArray()){
//            if(sb.length() < 2){
//                sb.append(ch);
//            } else {
//                if(sb.charAt(sb.length()-1) == ch && sb.charAt(sb.length()-2) == ch){
//                    continue;
//                }
//                sb.append(ch);
//            }
//        }
//        return sb.toString();
//    }


    // Solution 3 - Much more optimized (as we are not reading from sb)
    // O(N)/O(N)
    public String makeFancyString(String s) {
        int n = s.length();
        if(n <= 2){
            return s;
        }

        StringBuilder sb = new StringBuilder();
        char first = ' ';
        char second = ' ';

        for(char ch:s.toCharArray()){
            if(sb.length() < 2){
                sb.append(ch);
                first = second;
                second = ch;
            } else {
                if(first == ch && second == ch){
                    first = second;
                    second = ch;
                    continue;
                }
                sb.append(ch);
                first = second;
                second = ch;
            }
        }
        return sb.toString();
    }
}
