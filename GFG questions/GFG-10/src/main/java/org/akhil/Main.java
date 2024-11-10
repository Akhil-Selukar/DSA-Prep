package org.akhil;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
//        stack.push(6);

//        print(stack);

        removeMiddle(stack);
        print(stack);
    }

    private static void removeMiddle(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        int count = stack.size()/2;
        for(int i = 0; i< count; i++){
            tempStack.push(stack.pop());
        }

        stack.pop();

        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
    }

    private static void print(Stack<Integer> stack) {
        while(!stack.isEmpty()){
            System.out.print(" <- "+stack.pop());
        }
    }
}