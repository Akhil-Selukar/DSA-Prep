package org.akhil;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtTheEnd(1);
        cll.addElementAtTheEnd(2);
        cll.addElementAtTheEnd(3);
        cll.addElementAtTheEnd(4);
        cll.addElementAtTheEnd(5);

        cll.display();
        cll.reverseBetween(2,4);
        System.out.println();
        cll.display();
    }
}