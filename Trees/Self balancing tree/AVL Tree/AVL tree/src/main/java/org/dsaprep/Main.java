package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        for(int i=0; i<=1000; i++){
            avl.insert(i);
        }
        System.out.println(avl.getTreeHeight());
    }
}