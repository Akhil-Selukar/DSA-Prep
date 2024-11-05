package org.akhil;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(0);

        for(int i=1; i<heights.length; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                max = getMax(heights, stack, i, max);
            }
            stack.push(i);
        }

        int i = heights.length;
        while (!stack.isEmpty()) {
            max = getMax(heights, stack, i, max);
        }

        return max;
    }

    private static int getMax(int[] heights, Stack<Integer> stack, int i, int max) {
        int area;
        int poppedIndex = stack.pop();
        if(stack.isEmpty()){
            area = heights[poppedIndex] * i;
        } else {
            area = heights[poppedIndex] * (i-1-stack.peek());
        }
        return Math.max(area, max);
    }
}