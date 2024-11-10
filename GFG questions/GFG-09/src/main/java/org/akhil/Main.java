package org.akhil;

public class Main {
    public static void main(String[] args) {
        QueueSolution queue = new QueueSolution();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);

//        queue.print();

        queue.reverseFirstK(5);
        System.out.println();
        queue.print();
    }


}