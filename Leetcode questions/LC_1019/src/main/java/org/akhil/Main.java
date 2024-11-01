package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList cll = new CustomLinkedList();
        cll.addElementAtEnd(2);
        cll.addElementAtEnd(7);
        cll.addElementAtEnd(4);
        cll.addElementAtEnd(3);
        cll.addElementAtEnd(5);

        cll.display();
        // This could be better solved using stack
        int[] arr = cll.nextLargerNodes();
        System.out.println(Arrays.toString(arr));
    }
}