package org.akhil;

public class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private Node[] buckets;
    private int capacity = 10000;

    public MyHashMap() {
        buckets = new Node[capacity];
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node temp = buckets[index];
        if(temp == null){
            buckets[index] = new Node(key, value);
            return;
        }
        if(temp.key == key){
            temp.val = value;
            return;
        }

        while(temp.next != null){
            if(temp.next.key == key){
                temp.next.val = value;
                break;
            }
            temp = temp.next;
        }

        temp.next = new Node(key, value);
    }

    public int get(int key) {
        int index = hash(key);
        Node temp = buckets[index];
        while(temp != null){
            if(temp.key == key){
                return temp.val;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node temp = buckets[index];
        if(temp == null){
            return;
        }
        if(temp.key == key){
            buckets[index] = temp.next;
            return;
        }

        while(temp.next != null){
            if(temp.next.key == key){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }
}
