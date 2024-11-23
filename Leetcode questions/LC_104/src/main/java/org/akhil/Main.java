package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] arr = {8,12,4,3,7,10,11,9,5,14,6};  // add 6

        BinarySearchTree bst = new BinarySearchTree();

        for(int val:arr){
            bst.insert(val);
        }

        System.out.println(bst.maxDepth());

    }
}