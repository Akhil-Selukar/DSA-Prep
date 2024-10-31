package org.akhil;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtLast(1);
        cll.addElementAtLast(4);
        cll.addElementAtLast(3);
        cll.addElementAtLast(2);
        cll.addElementAtLast(5);
        cll.addElementAtLast(2);

        cll.display();
        cll.partition(3);
        cll.display();
    }
}