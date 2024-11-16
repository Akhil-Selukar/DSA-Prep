package org.dsaprep;

import java.util.Scanner;

public class BinaryTree {
    private static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public BinaryTree(){}

    public void populate(Scanner sc){
        System.out.println("Enter the root node : ");
        int val = sc.nextInt();
        root = new Node(val);

        populate(sc, root);
    }

    private void populate(Scanner sc, Node root){
        System.out.println("Do you want to insert at the left of node "+root.value);
        boolean left = sc.nextBoolean();

        if(left){
            System.out.println("Enter the value for left node of node "+root.value);
            int value = sc.nextInt();
            root.left = new Node(value);
            populate(sc, root.left);
        }

        System.out.println("Do you want to insert at the right of node "+root.value);
        boolean right = sc.nextBoolean();

        if(right){
            System.out.println("Enter the value for right node of node "+root.value);
            int value = sc.nextInt();
            root.right = new Node(value);
            populate(sc, root.right);
        }
    }

    public void display(){
        prettyDisplay(this.root, 0);
    }

    private void prettyDisplay(Node root, int level) {
        if(root == null){
            return;
        }

        prettyDisplay(root.right, level+1);

        if(level != 0){
            for(int i=0; i<level-1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|--->"+root.value);
        } else {
            System.out.println(root.value);
        }

        prettyDisplay(root.left, level+1);
    }
}
