package org.akhil;

public class Main {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();

        myHashSet.display();
        System.out.println();
        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.display();
        System.out.println();
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        myHashSet.display();
        System.out.println();
        System.out.println(myHashSet.contains(1));
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));

    }
}