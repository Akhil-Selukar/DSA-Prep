package org.akhil;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] arr = {71,18,52,29,55,73,24,42,66,8,80,2};
        int k = 3;

        System.out.println(Arrays.toString(mostCompetitive(arr, k)));
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        int[] ans = new int[k];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[i]<stack.peek() && nums.length - i > k - stack.size()){
                stack.pop();
            }

            if(stack.size()<k){
                stack.push(nums[i]);
            }
        }

        for(int i=k-1; i>=0; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}