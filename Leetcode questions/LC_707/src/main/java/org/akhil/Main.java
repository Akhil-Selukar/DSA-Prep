package org.akhil;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();

//        myList.deleteAtIndex(0);
//        myList.display();

        myList.addAtHead(7);
        myList.addAtHead(2);
        myList.addAtHead(1);
        myList.addAtTail(5);
        myList.addAtTail(4);
        myList.display();
        System.out.println(myList.get(0));
        System.out.println(myList.get(2));
        System.out.println(myList.get(-1));
        System.out.println(myList.get(4));
        System.out.println(myList.get(5));
        myList.addAtIndex(1, 3);
        myList.display();
        myList.addAtIndex(0, 10);
        myList.display();
        myList.addAtIndex(7, 6);
        myList.display();
        myList.deleteAtIndex(0);
        myList.display();
        myList.deleteAtIndex(6);
        myList.display();
        myList.deleteAtIndex(2);
        myList.display();
    }
}