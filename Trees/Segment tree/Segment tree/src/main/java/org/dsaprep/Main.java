package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 3, 4, 9, 7, 2};

        SegmentTree tree = new SegmentTree(arr);
//        tree.display();

        System.out.println(tree.query(2,6));

        tree.update(3,7);
//        tree.display();
        System.out.println(tree.query(2,6));

    }
}