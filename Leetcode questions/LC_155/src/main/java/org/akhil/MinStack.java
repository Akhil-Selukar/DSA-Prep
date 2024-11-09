package org.akhil;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(0);
            min = val;
        } else {
            stack.push(val-min);
            if(val<min){
                min = val;
            }
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int popped = stack.pop();
        if(popped < 0){
            min = min - popped;
        }
    }

    public int top() {
        int peeked = stack.peek();
        if(peeked >=0){
            return min+peeked;
        } else {
            return min;
        }
    }

    public int getMin() {
        return min;
    }
}
