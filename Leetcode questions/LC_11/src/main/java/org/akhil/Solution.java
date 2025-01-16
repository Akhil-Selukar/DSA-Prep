package org.akhil;

public class Solution {
    public int maxArea(int[] height) {
        int startPointer = 0;
        int endPointer = height.length-1;
        int maxArea = 0;

        while(startPointer < endPointer){
            int width = endPointer-startPointer;
            int ht = Math.min(height[startPointer], height[endPointer]);
            int area = ht * width;

            maxArea = Math.max(maxArea, area);
            if(height[startPointer] < height[endPointer]){
                startPointer++;
            } else {
                endPointer--;
            }
        }
        return maxArea;
    }
}
