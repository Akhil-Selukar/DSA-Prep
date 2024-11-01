package org.akhil;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(3);
        cll.addElementAtEnd(2);
        cll.addElementAtEnd(5);
        cll.addElementAtEnd(4);
        cll.addElementAtEnd(1);

        cll.display();
        cll.insertionSortList();
        cll.display();
    }
}