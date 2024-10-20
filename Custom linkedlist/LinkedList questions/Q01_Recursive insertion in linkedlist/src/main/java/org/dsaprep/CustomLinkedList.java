package org.dsaprep;

public class CustomLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public CustomLinkedList() {
        this.size = 0;
    }

    public void insert(int value){
        Node node = new Node(value);
        if(this.head == null){
            this.head = node;
            this.tail = node;
            this.size += 1;
            return;
        }

        this.tail.next = node;
        this.tail = node;
        this.size +=1;
    }

    public void recursiveInsert(int value, int index){
        this.head = recursiveInsertValue(value, index, this.head);
    }

    private Node recursiveInsertValue(int value, int index, Node temp) {
        if(index == 0){
            Node node = new Node(value, temp);
            this.size +=1;
            return node;
        }
        temp.next = recursiveInsertValue(value, index-1, temp.next);
        return temp;
    }

    public void display(){
        Node temp = this.head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
