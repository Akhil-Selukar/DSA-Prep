package org.dsaprep;

public class Main {
    public static void main(String[] args) throws CustomQueueException {
        CustomQueue queue = new CustomQueue(5);          // we have implemented CustomQueue as class to understand the working, but actually Queue is an interface.

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        queue.display();
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.display();

        queue.add(6);
        queue.add(7);
        queue.display();

        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        queue.display();
    }
}