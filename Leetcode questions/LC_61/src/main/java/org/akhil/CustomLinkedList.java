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

    public void rotateRight(int k) {
    if(k<=0 || this.head == null || this.head.next == null){            // base condition if no rotation is required or LinkedList has only 1 or 0 elements (then rotation will not matter)
        return;
    }

    // finding lastNode and length if LinkedList
    ListNode lastNode = head;
    int length = 1;
    while(lastNode.next != null){
        lastNode = lastNode.next;
        length++;
    }

    lastNode.next = this.head;      // set lastNode.next = head i.e. creating relation between lastNode and present head.

    int rotationsRequired = k%length;           // If length of list is 6 and k is also 6 then after rotating 6 times actual effective rotation will be nothing. similarly for 12, 18 rotations as well
                                                // Also if length of list is 6 and K is 7 so effective rotation will be only 1 node. hence k%length.

    int nodesToSkip = length-rotationsRequired; // Now we have already created relation between lastNode and head. So we just have to break the list from specific node so that it will be rotated and non-cyclic again.

    ListNode newLast = this.head;
    for(int i=1; i<nodesToSkip; i++){
        newLast = newLast.next;
    }
    this.head = newLast.next;
    newLast.next = null;
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
