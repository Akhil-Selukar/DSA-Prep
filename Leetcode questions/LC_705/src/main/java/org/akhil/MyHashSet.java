package org.akhil;


/*
 * IMPORTANT NOTE: Even though this is not the fastest solution on leetcode but this is the correct solution.
 * We can optimize the time using Buckets concept which will reduce the iterations to contains and add method, but it is
 * worth mentioning in interview that the optimized solution will use array data structure. (check solution 2 below)
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


//-------------------
// Solution 2 - with buckets logic

//class MyHashSet {
//
//    // Node structure class
//    private class Node{
//        int val;
//        Node next;
//
//        public Node(int val){
//            this.val = val;
//        }
//    }
//
//    // global variable to track the head of linkedList
//    Node[] buckets;
//    final int BUCKET_COUNT = 1000;
//
//    public MyHashSet() {
//        buckets = new Node[BUCKET_COUNT];
//    }
//
//    public void add(int key) {
//        int bucketIndex = Integer.hashCode(key) % BUCKET_COUNT;
//        Node head = buckets[bucketIndex];
//
//        if(contains(key)){
//            return;
//        }
//        if(head == null){
//            head = new Node(key);
//            buckets[bucketIndex] = head;
//            return;
//        }
//
//        while(head.next != null){
//            head = head.next;
//        }
//
//        Node newNode = new Node(key);
//        head.next = newNode;
//    }
//
//    public void remove(int key) {
//        int bucketIndex = Integer.hashCode(key) % BUCKET_COUNT;
//        Node head = buckets[bucketIndex];
//
//        // Handle case where the head node is the one to be removed
//        if (head != null && head.val == key) {
//            buckets[bucketIndex] = head.next;
//            return;
//        }
//
//        // Traverse to find the node and remove it
//        Node current = head;
//        while (current != null && current.next != null) {
//            if (current.next.val == key) {
//                current.next = current.next.next;
//                return;
//            }
//            current = current.next;
//        }
//    }
//
//    public boolean contains(int key) {
//        int bucketIndex = Integer.hashCode(key) % BUCKET_COUNT;
//        Node node = buckets[bucketIndex];
//
//        while(node != null){
//            if(node.val == key){
//                return true;
//            }
//            node = node.next;
//        }
//        return false;
//    }
//}