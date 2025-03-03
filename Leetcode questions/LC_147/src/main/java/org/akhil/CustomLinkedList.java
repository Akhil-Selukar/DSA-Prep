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


    // O(N^2)/O(1)
    public void insertionSortList() {
        if( this.head == null ){
            return;
        }

        ListNode dummyOfSortedList = new ListNode(0);
        ListNode previousNode = dummyOfSortedList;
        ListNode currentNode = this.head;
        ListNode nextNode = null;

        while(currentNode != null){
            nextNode = currentNode.next;
            //find the right place to insert
            while(previousNode.next != null && previousNode.next.value < currentNode.value ){
                previousNode = previousNode.next;
            }
            //insert between pre and pre.next
            currentNode.next = previousNode.next;
            previousNode.next = currentNode;
            previousNode = dummyOfSortedList;
            currentNode = nextNode;
        }

        this.head = dummyOfSortedList.next;
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


    // Another sorting (NOT INSERTON SORT) O(Nlog(N))/ O(N)
//    public ListNode insertionSortList(ListNode head) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        ListNode dummy = head;
//        while(dummy != null){
//            queue.offer(dummy.val);
//            dummy = dummy.next;
//        }
//
//        dummy = head;
//        while(dummy != null){
//            dummy.val = queue.poll();
//            dummy = dummy.next;
//        }
//
//        return head;
//    }


