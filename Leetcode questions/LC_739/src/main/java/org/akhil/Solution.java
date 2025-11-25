package org.akhil;

import java.util.Stack;

public class Solution {

//    // Solution 1 - Bruteforce
//    // O(N^2)/O(N)
//    public int[] dailyTemperatures(int[] temperatures) {
//        int[] result = new int[temperatures.length];
//
//        for(int i=0; i<temperatures.length; i++){
//            result[i] = getNextMax(temperatures, i);
//        }
//
//        return result;
//    }
//
//    private int getNextMax(int[] temp, int start){
//        for(int i=start; i<temp.length; i++){
//            if(temp[start] < temp[i]){
//                return i-start;
//            }
//        }
//        return 0;
//    }


    // -----------------
    // Solution 2 - Optimized
    // O(N)/O(N)
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){    // this while loop ensures the values in stack are always in decreasing order (i.e. monotonic decreasing stack)
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
