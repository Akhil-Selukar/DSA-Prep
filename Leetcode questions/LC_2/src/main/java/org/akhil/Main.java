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

        // The actual method is not called here but written in CustomLinkedList class, for testing and test cases run the method on leencode.
    }
}