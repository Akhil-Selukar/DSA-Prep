package org.akhil;

class MyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int size;
    public MyLinkedList() {
        this.size = 0;
    }

    public int get(int index) {
        if(index<0 || index>this.size-1){
            return -1;
        }
        ListNode temp = this.head;
        for(int i=0; temp!= null && i<index; i++){
            temp = temp.next;
        }
        return temp.value;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        if(this.head == null){
            this.head = node;
            this.tail = node;
            this.size++;
            return;
        }
        node.next = this.head;
        this.head = node;
        this.size++;
    }

    public void addAtTail(int val) {
        if(this.head == null){
            addAtHead(val);
            return;
        }
        ListNode node = new ListNode(val);
        this.tail.next = node;
        this.tail = node;
        this.size++;
    }

    public void addAtIndex(int index, int val) {
        if(index < 0 || index > this.size){
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index == this.size){
            addAtTail(val);
            return;
        }
        ListNode node = new ListNode(val);
        ListNode previousNode = getNodeAtIndex(index-1);

        node.next = previousNode.next;
        previousNode.next = node;
        this.size++;
    }

    private ListNode getNodeAtIndex(int index) {
        if(index < 0 || index >= this.size){
            return null;
        }
        ListNode temp = this.head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= this.size)
            return;
        else if(this.size == 1){
            this.head = null;
            this.tail = null;
        } else if(index == 0){
            head = head.next;
        } else if(index == this.size-1){
            ListNode previousNode = getNodeAtIndex(index-1);
            previousNode.next = null;
            this.tail = previousNode;
        } else {
            ListNode previousNode = getNodeAtIndex(index-1);
            previousNode.next = previousNode.next.next;
        }
        this.size--;
    }

    public void display(){
        ListNode temp = this.head;
        while(temp != null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
