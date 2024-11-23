package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] arr = {8,4,12,3,10,7};

        for(int i=0; i<arr.length; i++){
            bst.insert(arr[i]);
        }

        bst.preOrderTraversal();
        System.out.println();
        bst.inOrderTraversal();
        System.out.println();
        bst.postOrderTraversal();
    }
}