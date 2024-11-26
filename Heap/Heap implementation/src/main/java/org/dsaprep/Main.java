package org.dsaprep;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();

        heap.insert(18);
        heap.insert(2);
        heap.insert(5);
        heap.insert(4);
        heap.insert(20);
        heap.insert(21);
        heap.insert(7);
        heap.insert(9);
        heap.insert(22);

        System.out.println(heap.remove());      // 22 -> largest of all number

        heap.insert(25);

        System.out.println(heap.remove());      // 25 -> modified largest of all number
        System.out.println(heap.remove());      // 21 -> second largest of all number (22 was already removed above)
        System.out.println(heap.remove());      // 20 -> third largest of all number

        ArrayList<Integer> sortedList = heap.heapSort();
        System.out.println(sortedList);         // remaining elements in sorted order.
    }
}