package org.akhil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {

    // Solution 1 - bruteforce using 2 stacks
    // O(NlogM) where N is number of elements in nums and M is the largest element in nums.
    // TC is O(NlogM) because each element will be pushed in stack and popped out of stack once now inside while loop we are calculating GCD and LCM using
    // Euclid's algorithm which is O(log(min(a,b)) time complexity. This will contribute in case of log(min(M,x)) where M is second largest and X is largest.
    // So we can say at max O(logM) second largest and largest we can consider as largest itself hence O(NlogM)
//    public List<Integer> replaceNonCoprimes(int[] nums) {
//        Stack<Integer> stack1 = new Stack<>();
//        Stack<Integer> stack2 = new Stack<>();
//
//        for(int num:nums){
//            stack2.push(num);
//        }
//
//        while(!stack2.isEmpty()){
//            if(stack1.isEmpty()){
//                stack1.push(stack2.pop());
//            } else {
//                int num1 = stack1.peek();
//                int num2 = stack2.peek();
//                int gcd = getGCD(num1, num2);
//
//                if(gcd == 1){
//                    stack1.push(stack2.pop());
//                } else {
//                    stack1.pop();
//                    stack2.pop();
//                    int lcm = getLCM(num1, num2);
//                    stack2.push(lcm);
//                }
//            }
//        }
//
//        List<Integer> result = new ArrayList<>();
//
//        while(!stack1.isEmpty()){
//            result.add(stack1.pop());
//        }
//
//        return result;
//    }
//
//    private int getLCM(long a, long b){
//        return (int)((a*b)/getGCD(a, b));
//    }
//
//    private int getGCD(long a, long b){
//        if(a == 0){
//            return (int)b;
//        }
//        return (int)getGCD(b%a, a);
//    }


    // ----------------
    // Solution 2 - similar approach but using only 1 stack

    // Solution 1 - bruteforce using 2 stacks
    // O(NlogM) where N is number of elements in nums and M is the largest element in nums.
    // TC is O(NlogM) because each element will be pushed in stack and popped out of stack once now inside while loop we are calculating GCD and LCM using
    // Euclid's algorithm which is O(log(min(a,b)) time complexity. This will contribute in case of log(min(M,x)) where M is second largest and X is largest.
    // So we can say at max O(logM) second largest and largest we can consider as largest itself hence O(NlogM)
//    public List<Integer> replaceNonCoprimes(int[] nums) {
//        Stack<Integer> stack = new Stack<>();
//
//        for (int num : nums) {
//            while (!stack.isEmpty()) {
//                int topVal = stack.peek();
//                int gcd = getGCD(topVal, num);
//
//                if (gcd == 1) {
//                    break;
//                } else {
//                    stack.pop();
//                    int lcm = getLCM(num, topVal);
//                    num = lcm;
//                }
//            }
//            stack.push(num);
//        }
//
//        List<Integer> result = new ArrayList<>();
//
//        while (!stack.isEmpty()) {
//            result.add(stack.pop());
//        }
//        Collections.reverse(result);
//        return result;
//    }
//
//    private int getLCM(long a, long b) {
//        return (int) ((a * b) / getGCD(a, b));
//    }
//
//    private int getGCD(long a, long b) {
//        if (a == 0) {
//            return (int) b;
//        }
//        return (int) getGCD(b % a, a);
//    }

    // ----------------------
    // Solution 3 - Without using stack
    // O(NlogM)/O(N) - same space and time complexity but still this one is better as no stack is involved
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> result = new ArrayList<>();
        result.add(nums[0]);

        for(int i=1; i<nums.length; i++){
            int num = nums[i];
            boolean lcmAdded = false;
            while(result.size() > 0 && getGCD(num, result.get(result.size()-1)) > 1){
                num = getLCM(result.get(result.size()-1), num);
                result.remove(result.size()-1);
            }
            result.add(num);
        }
        return result;
    }

    private int getLCM(long a, long b){
        return (int)((a*b)/getGCD(a, b));
    }

    private int getGCD(long a, long b){
        if(a == 0){
            return (int)b;
        }
        return (int)getGCD(b%a, a);
    }
}
