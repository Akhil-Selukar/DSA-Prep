package org.akhil;

import java.util.Stack;

public class Solution {
    // Solution 1 - Greedy bruteforce (TLE)
    // O(L^2)/O(L) where L is length of string
//    public int maximumGain(String s, int x, int y) {
//        int maxGain = 0;
//
//        if(y > x) {
//            while (s.contains("ba")) {          // O(L) where L is length of string
//                maxGain = maxGain + y;
//                s = s.replaceFirst("ba", "");   // O(L) where L is length of string
//            }
//
//            while(s.contains("ab")){
//                maxGain = maxGain + x;
//                s = s.replaceFirst("ab", "");
//            }
//        } else {
//            while(s.contains("ab")){
//                maxGain = maxGain + x;
//                s = s.replaceFirst("ab", "");
//            }
//            while (s.contains("ba")) {
//                maxGain = maxGain + y;
//                s = s.replaceFirst("ba", "");
//            }
//        }
//
//        return maxGain;
//    }


    //---------------------------
    // Solution 2 - Using stack
    // O(N)/O(N)
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        int maxGain = 0;
        Stack<Character> stack = new Stack<>();
        // the pair which gives us max point will be processed first (greedy)
        String firstPriority = (x > y) ? "ab" : "ba";
        String secondPriority = (x > y) ? "ba" : "ab";

        // first iteration for firstPriority
        for(int i=0; i<n; i++){
            if(s.charAt(i) == firstPriority.charAt(1) && !stack.isEmpty() && stack.peek() == firstPriority.charAt(0)){
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        String remainingString = getString(stack);
        int pairsFound = (n - remainingString.length())/2;
        maxGain = maxGain + (pairsFound * Math.max(x, y));

        // second iteration for secondPriority -> this will be on remaining string as priority pair is already removed
        for(int i=0; i<remainingString.length(); i++){
            if(remainingString.charAt(i) == secondPriority.charAt(1) && !stack.isEmpty() && stack.peek() == secondPriority.charAt(0)){
                stack.pop();
            } else {
                stack.push(remainingString.charAt(i));
            }
        }

        int lengthOfRemainingString = stack.size();
        pairsFound = (remainingString.length() - lengthOfRemainingString)/2;
        maxGain = maxGain + (pairsFound * Math.min(x, y));

        return maxGain;
    }

    private String getString(Stack<Character> stack){
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
