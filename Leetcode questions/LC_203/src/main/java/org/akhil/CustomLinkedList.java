package org.akhil;

public class CustomLinkedList {

    private ListNode head;
    private ListNode tail;

    public void addElementAtEnd(int value){
        ListNode node = new ListNode(value);
        if(this.head == null){
            this.head = node;
            this.tail = node;
            return;
        }
        this.tail.next = node;
        this.tail = node;
    }

    public void display(){
        ListNode temp = this.head;
        while(temp != null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    public void removeElements(int val) {
        ListNode temp = new ListNode(0);
        temp.next = this.head;
        ListNode currentNode = temp;
        while(currentNode.next != null){
            if(currentNode.next.value == val){
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
        this.head = temp.next;
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}


/*
if(head == null){
            return head;
        }
        if(head.val == val){
            head = head.next;
        }

        ListNode previousNode = head;
        ListNode currentNode = head.next;
        ListNode nextNode = null;
        if(currentNode != null){
            nextNode  = currentNode.next;
        }

        while(currentNode != null){
            if(currentNode.val == val){
                previousNode.next = nextNode;
                currentNode = nextNode;
                if(nextNode != null){
                    nextNode = nextNode.next;
                }
            } else {
                previousNode = currentNode;
                currentNode = nextNode;
                if(nextNode != null){
                    nextNode = nextNode.next;
                }
            }
        }
        return head;
 */