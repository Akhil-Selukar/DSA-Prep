package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(5);
        cll.addElementAtEnd(3);
        cll.addElementAtEnd(2);
        cll.addElementAtEnd(4);
        cll.addElementAtEnd(7);

        cll.display();
        cll.reverse();
        System.out.println();
        cll.display();
    }
}