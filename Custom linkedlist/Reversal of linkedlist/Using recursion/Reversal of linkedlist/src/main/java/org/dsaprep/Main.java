package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList cll = new CustomLinkedList();

        cll.addNumberAtEnd(5);
        cll.addNumberAtEnd(3);
        cll.addNumberAtEnd(1);
        cll.addNumberAtEnd(4);
        cll.addNumberAtEnd(7);

        cll.display();
        cll.reverse();
        System.out.println();
        cll.display();
    }
}