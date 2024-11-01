package org.akhil;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementsAtEnd(1);
        cll.addElementsAtEnd(2);
        cll.addElementsAtEnd(3);
        cll.addElementsAtEnd(4);
        cll.addElementsAtEnd(5);
        cll.addElementsAtEnd(6);
        cll.addElementsAtEnd(7);
        cll.addElementsAtEnd(8);
        cll.addElementsAtEnd(9);
        cll.addElementsAtEnd(10);
        cll.addElementsAtEnd(11);
        cll.addElementsAtEnd(12);
        cll.addElementsAtEnd(13);
        cll.addElementsAtEnd(14);
//        cll.addElementsAtEnd(15);

        cll.display();
        cll.reverseEvenLengthGroups();
        cll.display();
    }
}