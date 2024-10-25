package org.akhil;

public class CustomLinkedList {

    private ListNode head;
    private ListNode tail;

    public void addElementAtTheEnd(int value){
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

    public ListNode reverseBetween(int left, int right) {
        if(left == right){
            return this.head;
        }

        // skip nodes till left
        ListNode previousNode = null;           // first pointer
        ListNode currentNode = this.head;       // second pointer
        for(int i=0; i<left-1;i++){
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        ListNode lastLeftUnReversedNode = previousNode;
        ListNode newEndInReversed = currentNode;

        // reverse nodes between left and right
        ListNode nextNode = currentNode.next;      // third pointer
        for(int i=0; i<right-left+1; i++){
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            if(nextNode != null){
                nextNode = nextNode.next;
            }
        }

        if(lastLeftUnReversedNode != null) {
            lastLeftUnReversedNode.next = previousNode;
        } else {
            this.head = previousNode;
        }
        newEndInReversed.next = currentNode;

        return head;
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
