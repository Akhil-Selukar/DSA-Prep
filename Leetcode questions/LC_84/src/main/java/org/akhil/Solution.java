package org.akhil;

import java.util.Stack;

public class Solution {

    // O(N)/O(N)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] leftBoundary = new int[n];
        int[] rightBoundary = new int[n];
        Stack<Integer> stack = new Stack<>();

        // calculate left boundary for all heights
        for(int i=0; i<n; i++){
            // if there is nothing in stack then that means there is no smaller height to the left of current height,
            // and we can go all the way till index 0
            if(stack.isEmpty()){
                leftBoundary[i] = 0;
            } else {
                while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                    stack.pop();
                }
                leftBoundary[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            }
            stack.push(i);
        }

        // calculate right boundary for all heights
        stack.clear();
        for(int i=n-1; i>=0; i--){
            if(stack.isEmpty()){
                rightBoundary[i] = n-1;
            } else {
                while(!stack.isEmpty() && heights[stack.peek()]>= heights[i]){
                    stack.pop();
                }

                rightBoundary[i] = stack.isEmpty() ? n-1 : stack.peek() - 1;
            }
            stack.push(i);
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int area = heights[i] * (rightBoundary[i] - leftBoundary[i] + 1);
            max = Math.max(max, area);
        }
        return max;
    }
}
