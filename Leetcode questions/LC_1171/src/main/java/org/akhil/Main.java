package org.akhil;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(2);
        cll.addElementAtEnd(3);
        cll.addElementAtEnd(-3);
        cll.addElementAtEnd(-2);

        cll.display();
        cll.removeZeroSumSublists();
        cll.display();
    }
}