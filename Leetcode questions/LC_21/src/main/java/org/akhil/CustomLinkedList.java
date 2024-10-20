package org.akhil;

public class CustomLinkedList {

    private ListNode head;
    private ListNode tail;
    private int size;

    public CustomLinkedList(){
        this.size = 0;
    }

    public void addElement(int val){
        ListNode node = new ListNode(val);
        if(this.head == null){
            this.head = node;
            this.tail = node;
            this.size++;
            return;
        }
        this.tail.next = node;
        this.tail = node;
        this.size++;
    }

    public void display(){
        if(this.size == 0){
            System.out.println("END");
            return;
        }

        ListNode temp = this.head;
        while(temp != null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static CustomLinkedList merge(CustomLinkedList list1, CustomLinkedList list2){
        ListNode firstHead = list1.head;
        ListNode secondHead = list2.head;

        CustomLinkedList mergedList = new CustomLinkedList();

        while(firstHead != null && secondHead != null){
            if(firstHead.val < secondHead.val){
                mergedList.addElement(firstHead.val);
                firstHead = firstHead.next;
            } else {
                mergedList.addElement(secondHead.val);
                secondHead = secondHead.next;
            }
        }

        while(firstHead != null){
            mergedList.addElement(firstHead.val);
            firstHead = firstHead.next;
        }

        while(secondHead != null){
            mergedList.addElement(secondHead.val);
            secondHead = secondHead.next;
        }

        return mergedList;
    }

    // for leetcode (Same algorithm just input and output of the method is different)
    /*public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;                  // assigned dummy head to tail hence the first assignment to tail.next will be our head only and tail will keep on going further.
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }

        while(list1 != null){
            tail.next = list1;
            list1 = list1.next;
            tail = tail.next;
        }

        while(list2 != null){
            tail.next = list2;
            list2 = list2.next
            tail = tail.next;
        }
        return dummyHead.next;                 // as we just moved tail in entire loop and dummyHead is still pointing to the first ListNode instance only.
    }*/

    public class ListNode {
        private int val;
        private ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
