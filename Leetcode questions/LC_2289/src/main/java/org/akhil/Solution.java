package org.akhil;

import java.util.Stack;

public class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 0;
        }

        Stack<Pair> stack = new Stack();
        int maxSteps = 0;

        for(int i=n-1; i>=0; i--){
            int steps = 0;
            while(!stack.isEmpty() && nums[i] > stack.peek().val){
                steps++;
                Pair pair = stack.pop();
                if(steps < pair.count){
                    steps = steps + (pair.count - steps);
                }
            }
            stack.push(new Pair(nums[i], steps));
            maxSteps = Math.max(maxSteps, steps);
        }

        return maxSteps;
    }

    private class Pair{
        int val;
        int count;

        public Pair(int val, int count){
            this.val = val;
            this.count = count;
        }
    }
}
