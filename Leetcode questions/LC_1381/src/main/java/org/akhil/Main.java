package org.akhil;

public class Main {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.print();
        System.out.println(stack.pop());
        stack.print();

        stack.push(6);
        stack.print();

        stack.increment(3,2);
        stack.print();

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.print();

        stack.increment(5,1);
        stack.print();
    }
}