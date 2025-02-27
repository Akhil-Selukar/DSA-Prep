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

    public void reverseKGroup(int k) {
//        if(k == 1 || head == null){
//            return head;
//        }
        ListNode head = this.head;
        int size = findSize(head);
        int iterations = size/k;

        ListNode previousNode = null;
        ListNode currentNode = head;

        while(iterations > 0){
            ListNode lastNonReversed = previousNode;
            ListNode newEnd = currentNode;
            ListNode nextNode = currentNode.next;

            for(int i=0; currentNode != null && i<k; i++){
                currentNode.next = previousNode;
                previousNode = currentNode;
                currentNode = nextNode;
                if(nextNode != null){
                    nextNode = nextNode.next;
                }
            }

            if(lastNonReversed != null){
                lastNonReversed.next = previousNode;
            } else {
                this.head = previousNode;
            }

            newEnd.next = currentNode;
            previousNode = newEnd;
            iterations--;
        }
//        return head;
    }

    private int findSize(ListNode head) {
        if(head == null){
            return 0;
        }
        int counter = 0;
        while(head != null){
            counter++;
            head = head.next;
        }
        return counter;
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}


// Better solution with O(N)/O(1)

//    public ListNode reverseKGroup(ListNode head, int k) {
//        if(head == null || k == 1 || head.next == null){
//            return head;
//        }
//
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode startNode = dummy;
//        ListNode endNode = dummy.next;
//        int i=1;                        // endNode is already starting from dummy.next i.e. actual head so 1 node is already considered.
//        while(endNode != null){
//            if(i%k == 0){
//                startNode = reverse(startNode, endNode.next);
//                endNode = startNode.next;
//            } else {
//                endNode = endNode.next;
//            }
//            i++;
//        }
//        return dummy.next;
//    }
//
//    private ListNode reverse(ListNode start, ListNode end){
//        ListNode prevNode = start;
//        ListNode firstNode = start.next;
//        ListNode currNode = start.next;
//        ListNode nextNode;
//
//        while(currNode != end){
//            nextNode = currNode.next;
//            currNode.next = prevNode;
//            prevNode = currNode;
//            currNode = nextNode;
//        }
//
//        start.next = prevNode;
//        firstNode.next = currNode;
//
//        return firstNode;
//    }