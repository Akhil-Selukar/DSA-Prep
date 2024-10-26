package org.akhil;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList cll = new CustomLinkedList();
        // decimal 11
        // for edge cases check solution on Leetcode.
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(0);
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(1);

//        cll.display();
        System.out.println();
        System.out.println(cll.getDecimalValue());
    }
}