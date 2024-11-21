package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int[] arr = {8,12,4,3,7,10,11,9,5,14};

        BinarySearchTree bst = new BinarySearchTree();

        for(int i=0; i<arr.length; i++){
            bst.insert(arr[i]);
        }

//        bst.display();
        System.out.println(bst.levelOrder());
    }
}