package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(5);
        cll.addElementAtEnd(3);
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(2);
        cll.addElementAtEnd(5);
        cll.addElementAtEnd(1);
        cll.addElementAtEnd(2);

        cll.display();
        System.out.println(Arrays.toString(cll.nodesBetweenCriticalPoints()));
    }
}