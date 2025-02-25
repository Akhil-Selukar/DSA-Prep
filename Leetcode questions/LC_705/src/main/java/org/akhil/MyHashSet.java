package org.akhil;


/*
 * IMPORTANT NOTE: Even though this is not the fastest solution on leetcode but this is the correct solution.
 * Other solution which take much less time and give correct result uses one or the other existing data structure.
 * Here the expectation is to implement this without using any data structure.
 */
public class MyHashSet {
    class Node{
        public int val;
        public Node next;

        public Node(int val){
            this.val = val;
        }
    }

    private Node head;

    public MyHashSet() {
        this.head = null;
    }

    public void add(int key) {
        if(this.head == null){
            this.head = new Node(key);
            return;
        }

        if(!contains(key)){
            Node temp = this.head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(key);
        }
    }

    public void remove(int key) {
        Node temp = this.head;
        if(temp == null){
            return;
        }
        if(temp.val == key){
            this.head = this.head.next;
            return;
        }

        while(temp.next != null){
            if(temp.next.val == key){
                temp.next = temp.next.next;
            } else {
                temp =temp.next;
            }
        }


    }

    public boolean contains(int key) {
        Node temp = this.head;
        if(temp == null){
            return false;
        }
        if(temp.val == key){
            return true;
        }
        while(temp.next != null){
            if(temp.next.val == key){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void display() {
        Node temp = this.head;

        while(temp != null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }
}
