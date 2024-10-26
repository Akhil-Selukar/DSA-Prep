package org.akhil;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(2);
        cll.addElementAtEnd(3);
        cll.addElementAtEnd(4);
        cll.addElementAtEnd(5);

        cll.display();

        CustomLinkedList cll1 = new CustomLinkedList();

        cll1.addElementAtEnd(7);
        cll1.addElementAtEnd(8);
        cll1.addElementAtEnd(4);
        cll1.addElementAtEnd(5);

        System.out.println();
        cll1.display();

        // Here the actual method is not called but it is written in CustomLinkedList class. Actual testcases are checked in Leetcode.
    }
}