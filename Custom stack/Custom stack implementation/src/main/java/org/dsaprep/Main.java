package org.dsaprep;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws CustomStackException{
        CustomStack stack = new CustomStack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
//        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
//        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}