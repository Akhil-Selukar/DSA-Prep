package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertElement(7);
        cll.insertElement(10);
        cll.insertElement(6);
        cll.insertElement(3);

        cll.display();
        System.out.println("\nSize of LinkedList is "+cll.size());

        System.out.println("Deleted "+cll.deleteElement(6));
        cll.display();
        System.out.println("\nSize of LinkedList is "+cll.size());

        System.out.println("Deleted "+cll.deleteElement(10));
        cll.display();
        System.out.println("\nSize of LinkedList is "+cll.size());
    }
}