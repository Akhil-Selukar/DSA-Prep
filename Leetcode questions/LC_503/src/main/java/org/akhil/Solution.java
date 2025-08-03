package org.akhil;

import java.util.Stack;

public class Solution {
    // Solution 1 - Bruteforce
    // O(N^2)/O(N)
//    public int[] nextGreaterElements(int[] nums) {
//        int n = nums.length;
//        int[] result = new int[n];
//
//        for(int i=0; i<n; i++){
//            result[i] = nextGreater(nums, n, i);
//        }
//
//        return result;
//    }
//
//    private int nextGreater(int[] nums, int n, int i) {
//        int index = i+1;
//
//        while(index % n != i){
//            if(nums[index % n] > nums[i]){
//                return nums[index % n];
//            }
//            index++;
//        }
//        return -1;
//    }

    //-----------------------
    // Solution 2 - Slight modification in bruteforce
    // O(N^2)/O(N)
//    public int[] nextGreaterElements(int[] nums) {
//        int n = nums.length;
//        int[] result = new int[n];
//        int greaterToRight = 0;
//
//        for(int i=0; i<n; i++){
//            if(nums[i] >= greaterToRight) {
//                greaterToRight = nextGreater(nums, n, i);
//            }
//            result[i] = greaterToRight;
//        }
//
//        return result;
//    }
//
//    private int nextGreater(int[] nums, int n, int i) {
//        int index = i+1;
//
//        while(index % n != i){
//            if(nums[index % n] > nums[i]){
//                return nums[index % n];
//            }
//            index++;
//        }
//        return -1;
//    }

    //---------------------------
    // Solution 2 - Using stack
    // O(N)/O(N)
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // add elements in stack starting from rightmost first
        // (rightmost first because we want array to be circular so for last index we want next to be 0th index)
        for(int i=n-1; i>=0; i--){
            stack.push(nums[i]);
        }

        // populate the result array using stack
        for(int i=n-1; i>=0; i--){
            int temp = nums[i];

            while(!stack.isEmpty() && nums[i] >= stack.peek()){
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(temp);
        }

        return result;
    }
}
