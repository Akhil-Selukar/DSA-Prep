package org.akhil;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList cll = new CustomLinkedList();

        cll.addElementAtEnd(1);
        cll.addElementAtEnd(2);
        cll.addElementAtEnd(3);
        cll.addElementAtEnd(4);
        cll.addElementAtEnd(5);
        cll.addElementAtEnd(6);

        cll.display();

        CustomLinkedList cll2 = new CustomLinkedList();

        cll2.addElementAtEnd(11);
        cll2.addElementAtEnd(12);
        cll2.addElementAtEnd(13);
        cll2.addElementAtEnd(14);

        cll2.display();

        cll.mergeInBetween(2, 3, cll2);

        cll.display();
    }
}