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
        cll.addElementAtEnd(7);

        cll.display();
//        cll.deleteMiddle();
        cll.deleteMiddleImproved();
        cll.display();
    }
}