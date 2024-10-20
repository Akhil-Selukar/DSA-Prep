package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList cll = new CustomLinkedList();
        cll.insert(2);
        cll.insert(3);
        cll.insert(4);
        cll.insert(5);

        cll.display();
        System.out.println();
        cll.recursiveInsert(1, 3);

        cll.display();
    }
}