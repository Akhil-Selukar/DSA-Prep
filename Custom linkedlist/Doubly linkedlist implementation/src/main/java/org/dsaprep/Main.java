package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList cll = new CustomLinkedList();

        cll.addElementAtStart(5);
        cll.addElementAtStart(3);
        cll.addElementAtEnd(10);
        cll.addElementAtStart(9);
        cll.addElementAtStart(7);
        cll.insert(1, 3);

        cll.display();
//        System.out.println();
//        cll.displayReverse();
        System.out.println("\nSize of LinkedList is "+cll.size());

        System.out.println("Deleted "+cll.deleteFirst());
        System.out.println("New size of LinkedList is "+cll.size());
        cll.display();

        System.out.println("\nDeleted "+cll.deleteLast());
        System.out.println("New size of LinkedList is "+cll.size());
        cll.display();

        System.out.println("\nDeleted "+cll.delete(2));
        System.out.println("New size of LinkedList is "+cll.size());
        cll.display();

        System.out.println("\n"+cll.contains(10));
        System.out.println(cll.contains(3));
    }
}