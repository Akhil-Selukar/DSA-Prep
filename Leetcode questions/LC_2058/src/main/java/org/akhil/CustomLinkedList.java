package org.akhil;

public class CustomLinkedList {

    private ListNode head;
    private ListNode tail;

    public void addElementAtEnd(int value) {
        ListNode node = new ListNode(value);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        this.tail.next = node;
        this.tail = node;
    }

    public void display() {
        ListNode temp = this.head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
    }

    public int[] nodesBetweenCriticalPoints() {
        if (this.head == null || this.head.next == null) {
            return new int[]{-1, -1};
        }

        int firstCriticalNodeIndex = -1;
        int lastCriticalNodeIndex = -1;
        int currentIndex = 1;
        int minDistance = Integer.MAX_VALUE;

        ListNode previousNode = this.head;
        ListNode currentNode = this.head.next;
        ListNode nextNode = this.head.next.next;

        while (nextNode != null) {
            // check if currentNode is a critical node or not
            if (((previousNode.value < currentNode.value) && (currentNode.value > nextNode.value))
                    || ((previousNode.value > currentNode.value) && (currentNode.value < nextNode.value))) {
                if (firstCriticalNodeIndex == -1) {
                    firstCriticalNodeIndex = currentIndex;
                } else {
                    minDistance = Math.min(minDistance,(currentIndex - lastCriticalNodeIndex));
                }
                lastCriticalNodeIndex = currentIndex;
            }
            currentIndex++;
            previousNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.next;
        }

        if (firstCriticalNodeIndex != -1 && firstCriticalNodeIndex != lastCriticalNodeIndex ) {
            return new int[]{minDistance, lastCriticalNodeIndex - firstCriticalNodeIndex};
        }
        return new int[]{-1, -1};
    }

    private class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
