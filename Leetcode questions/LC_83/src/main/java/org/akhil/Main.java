package org.akhil;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList cll = new CustomLinkedList();

        cll.addElement(1);
        cll.addElement(1);
        cll.addElement(1);
        cll.addElement(2);
        cll.addElement(3);
        cll.addElement(3);
        cll.addElement(4);
        cll.addElement(5);

        cll.display();
        System.out.println();
        cll.removeDuplicate();
        cll.display();
    }
}