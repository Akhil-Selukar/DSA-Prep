package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] arr = {8,12,4,3,7,10,11,9,5,14};

        BinarySearchTree bst = new BinarySearchTree();

        for(int num:arr){
            bst.insert(num);
        }

//        bst.display();
        System.out.println(bst.levelOrderBottom());
    }
}