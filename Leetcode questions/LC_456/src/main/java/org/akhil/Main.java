package org.akhil;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,1,4,2};

        System.out.println(find132pattern(nums));
    }

    public static boolean find132pattern(int[] nums) {
        Stack<Integer> maxStack = new Stack<>();
        int secondMax = Integer.MIN_VALUE;

        for(int i=nums.length-1; i>=0; i--){
            if(secondMax > nums[i]){
                return true;
            }
            while(!maxStack.isEmpty() && maxStack.peek() < nums[i]){
                secondMax = maxStack.pop();
            }
            maxStack.push(nums[i]);
        }
        return false;
    }
}