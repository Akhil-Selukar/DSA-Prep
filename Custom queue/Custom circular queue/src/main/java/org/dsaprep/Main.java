package org.dsaprep;

public class Main {
    public static void main(String[] args) throws CustomQueueException {
        CustomCircularQueue queue = new CustomCircularQueue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.display();
        queue.add(6);

        System.out.println(queue.remove());
        queue.display();
        queue.add(6);
        queue.display();

        System.out.println(queue.peek());
        System.out.println(queue.peek());
        queue.add(7);
        queue.display();

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        System.out.println(queue.remove());
        System.out.println(queue.remove());

    }
}