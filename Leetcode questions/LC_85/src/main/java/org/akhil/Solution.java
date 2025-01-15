package org.akhil;

import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int[] histogram = new int[matrix[0].length];
        for(char[] row:matrix){
            for(int i=0; i<row.length; i++){
                if(row[i] == '1'){
                    histogram[i] = histogram[i]+1;
                } else{
                    histogram[i] = 0;
                }
            }
            int area = largestRectangleInHistogram(histogram);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    // code for largest rectangle in histogram. (i.e. solution for LC-84)
    private int largestRectangleInHistogram(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int[] leftSmallest = new int[heights.length];
        int[] rightSmallest = new int[heights.length];

        // calculate leftSmallest for all histograms
        for(int i = 0; i<heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            if (stack.isEmpty()){
                leftSmallest[i] = 0;
            } else {
                leftSmallest[i] = stack.peek()+1;
            }
            stack.push(i);
        }

        // clear the stack to reuse further
        while(!stack.isEmpty()){
            stack.pop();
        }

        // calculate rightSmallest for all histograms
        for(int i=heights.length-1; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                rightSmallest[i] = heights.length-1;
            } else {
                rightSmallest[i] = stack.peek()-1;
            }
            stack.push(i);
        }

        // find maxArea of rectangle
        int maxArea = 0;
        for(int i=0; i<heights.length; i++){
            int area = heights[i] * (rightSmallest[i] - leftSmallest[i] + 1);

            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
