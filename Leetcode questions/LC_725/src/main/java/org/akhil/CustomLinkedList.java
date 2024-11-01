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
        System.out.println();
    }

    public ListNode[] splitListToParts(int k) {

        ListNode[] answer = new ListNode[k];

        ListNode temp = this.head;
        int size = 0;
        // Find the size of LinkedList
        while(temp != null){
            size++;
            temp = temp.next;
        }

        int splitSize = size/k;
        int remainder = size%k;

        temp = this.head;
        ListNode previousNode = temp;
        for(int i=0; i<k; i++){
            // create a part
            ListNode newPartHead = temp;

            int currentPartSize = splitSize;
            if(remainder>0){
                remainder--;
                currentPartSize++;
            }

            // traverse to the end of this part
            int j=0;
            while(j<currentPartSize){
                previousNode = temp;
                temp = temp.next;
                j++;
            }
            // cutoff the remaining linkedList
            if(previousNode != null){
                previousNode.next = null;
            }
            answer[i] = newPartHead;
        }
        return answer;
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
