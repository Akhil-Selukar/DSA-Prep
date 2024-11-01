package org.akhil;

public class CustomLinkedList {

    private ListNode head;
    private ListNode tail;

    public void addElementsAtEnd(int value){
        ListNode node = new ListNode(value);

        if(this.head == null){
            this.head = node;
            this.tail = node;
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
        System.out.println();
    }

    public void reverseEvenLengthGroups() {
        if(this.head.next == null || this.head.next.next == null){
            return;
        }

        // first group will never be reversed
        ListNode node = this.head;
        int group = 1;

        while(node != null && node.next != null){
            group++;                // because we will be starting from second group

            int numberOfNodes = 0;
            ListNode temp = node.next;          // because second group will start from second node.
            while(temp != null && numberOfNodes<group){
                temp = temp.next;
                numberOfNodes++;
            }

            if(numberOfNodes%2 == 0){
                ListNode currentNode = node.next;
                ListNode previousNode = node;
                ListNode nextNode = null;

                for(int i=0; i<numberOfNodes; i++){
                    nextNode = currentNode.next;
                    currentNode.next = previousNode;
                    previousNode = currentNode;
                    currentNode = nextNode;
                }

                ListNode newTail = node.next;
                newTail.next = currentNode;
                node.next = previousNode;
                node = newTail;
            } else {
                for(int i=0; i<numberOfNodes; i++){
                    node = node.next;
                }
            }
        }

    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
