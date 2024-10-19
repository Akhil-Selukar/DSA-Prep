package org.dsaprep;

public class CustomLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public CustomLinkedList(){      // constructor to create a new LinkedList. We can create empty LinkedList hence only size is set, head and tail will be null (i.e. default value) as no element is stored yet
        this.size = 0;
    }

    public void addElementAtStart(int value){       // to add element at the start of LinkedList
        Node node = new Node(value);
        node.next = this.head;
        this.head = node;
        if(this.tail == null){
            this.tail = node;
        }
        this.size +=1;
    }

    public void display(){          // to display the LinkedList
        Node temp = this.head;

        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    public void addElementAtEnd(int value){             // To add element at the end of LinkedList
        if(tail == null){           // means this is the first element in the LinkedList
            addElementAtStart(value);
            return;
        }

        Node node = new Node(value);
        this.tail.next = node;      // setting next value of current tail element node new node
        this.tail = node;           // updating the tail of entire LinkedList to new node
        this.size +=1;
    }

    public void insert(int value, int index){       // to insert element at given index
        if(index == 0){                         // means we have to add element at first index.
            addElementAtStart(value);
            return;
        }
        if(index == size){                      // means add element at last index
            addElementAtEnd(value);
            return;
        }

        Node temp = this.head;                      // starting from first node in LinkedList i.e. head.
        for(int i=1; i<index; i++){
            temp = temp.next;                       // moving till node at index-1, because we need to update the next of that node to newly created node.
        }

        Node node = new Node(value, temp.next);
        temp.next = node;
        this.size +=1;
    }

    public int deleteFirst(){
        int value = this.head.value;
        this.head = this.head.next;

        if(this.head == null){      // means there was only 1 element and that was deleted hence new head is null hence tail should also become null.
            this.tail = null;
        }

        this.size -=1;
        return value;
    }

    public int deleteLast(){
        if(this.size <= 1){
            return deleteFirst();
        }

        Node secondLastNode = getNodeAtIndex(this.size-2);       // size-2 because index is 0 based but size starts from 1.
        int value = this.tail.value;                             // value at node which will be deleted.
        this.tail = secondLastNode;
        this.tail.next = null;                                  // because now tail is at secondLastNode, so we can directly set its next to null
        this.size -=1;
        return value;
    }

    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == this.size-1){
            return deleteLast();
        }

        Node previousNode = getNodeAtIndex(index-1);
        int valueTobeDeleted = previousNode.next.value;

        previousNode.next = previousNode.next.next;
        previousNode.next.next = null;

        this.size -=1;
        return valueTobeDeleted;
    }

    public boolean contains(int value){
        Node temp = this.head;
        while(temp != null){
            if(temp.value == value){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    private Node getNodeAtIndex(int index){
        Node temp = this.head;
        for(int i=1; i<=index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public int size(){              // to get the current size of LinkedList
        return this.size;
    }
    private class Node{             // class which will represent each node in linkedlist. We don't want to allow access to the node from outside hence we created a private class inside CustomLinkedList
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
