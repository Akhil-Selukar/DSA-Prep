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

        // The actual method is not called here but the method is written in CustomLinkedList class and actual testcases can be checked at Leetcode.
    }
}