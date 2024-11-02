package org.dsaprep;

public class Main {
    public static void main(String[] args) throws CustomStackException {
        DynamicCustomStack stack = new DynamicCustomStack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        for(int i=0; i<7; i++){
            System.out.println(stack.pop());
        }

    }
}