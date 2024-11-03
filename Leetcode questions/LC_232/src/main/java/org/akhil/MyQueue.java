package org.akhil;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> firstStack;
    private Stack<Integer> secondStack;

    public MyQueue() {
        firstStack = new Stack<>();
        secondStack = new Stack<>();
    }

    public void push(int x) {
        firstStack.push(x);
    }

    public int pop() {
        while(!firstStack.empty()){
            secondStack.push(firstStack.pop());
        }
        int removed = secondStack.pop();
        while(!secondStack.empty()){
            firstStack.push(secondStack.pop());
        }
        return removed;
    }

    public int peek() {
        while(!firstStack.empty()){
            secondStack.push(firstStack.pop());
        }
        int peeked = secondStack.peek();
        while(!secondStack.empty()){
            firstStack.push(secondStack.pop());
        }
        return peeked;
    }

    public boolean empty() {
        return firstStack.empty();
    }
}


// Pop efficient implementation
//public class MyQueue {
//
//    private Stack<Integer> firstStack;
//    private Stack<Integer> secondStack;
//
//    public MyQueue() {
//        firstStack = new Stack<>();
//        secondStack = new Stack<>();
//    }
//
//    public void push(int x) {
//        while(!firstStack.empty()){
//            secondStack.push(firstStack.pop());
//        }
//        firstStack.push(x)
//        while(!secondStack.empty()){
//            firstStack.push(secondStack.pop());
//        }
//    }
//
//    public int pop() {
//        return firstStack.pop();
//    }
//
//    public int peek() {
//        return firstStack.peek();
//    }
//
//    public boolean empty() {
//        return firstStack.empty();
//    }
//}