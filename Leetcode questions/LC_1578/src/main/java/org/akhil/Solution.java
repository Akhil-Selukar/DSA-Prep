package org.akhil;

public class Solution {

    // O(N)/O(1)
    public int minCost(String colors, int[] neededTime) {
        int leftPointer = 0;
        int rightPointer = 1;

        int count = 0;

        while(rightPointer < colors.length()){
            if(colors.charAt(leftPointer) == colors.charAt(rightPointer)){
                if(neededTime[leftPointer] <= neededTime[rightPointer]){
                    count = count + neededTime[leftPointer];
                    leftPointer = rightPointer;
                    rightPointer++;
                } else {
                    count = count + neededTime[rightPointer];
                    rightPointer++;
                }
            } else {
                leftPointer = rightPointer;
                rightPointer++;
            }
        }

        return count;
    }
}
