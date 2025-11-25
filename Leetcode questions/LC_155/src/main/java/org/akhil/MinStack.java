package org.akhil;

import java.util.Stack;

public class MinStack {

    // Solution 1
//    private Stack<Integer> stack;
//    private int min = Integer.MAX_VALUE;
//
//    public MinStack() {
//        stack = new Stack<>();
//    }
//
//    public void push(int val) {
//        if(stack.isEmpty()){
//            stack.push(0);
//            min = val;
//        } else {
//            stack.push(val-min);
//            if(val<min){
//                min = val;
//            }
//        }
//    }
//
//    public void pop() {
//        if(stack.isEmpty()){
//            return;
//        }
//        int popped = stack.pop();
//        if(popped < 0){
//            min = min - popped;
//        }
//    }
//
//    public int top() {
//        int peeked = stack.peek();
//        if(peeked >=0){
//            return min+peeked;
//        } else {
//            return min;
//        }
//    }
//
//    public int getMin() {
//        return min;
//    }


    // ------------------------
    // Solution 2 - More intuitive
    // Just use normal stack and store min at each step in either another stack or in same stack using array
    private Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new int[]{val, val});
        } else {
            int prevMin = stack.peek()[1];
            if(val < prevMin){
                stack.push(new int[]{val, val});
            } else {
                stack.push(new int[]{val, prevMin});
            }
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
        }
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
