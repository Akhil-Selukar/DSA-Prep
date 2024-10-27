package org.akhil;

public class CustomLinkedList {

    private Node head;
    private Node tail;

    public Node copyRandomList(Node head) {

        Node currentNode = head;
        while(currentNode != null){
            Node copyNode = new Node(currentNode.val);      // create a copy with value
            copyNode.next = currentNode.next;               // place the copied node next to original node in same list
            currentNode.next = copyNode;
            currentNode = copyNode.next;
        }

        // Copy random relations of original nodes in copyNodes
        currentNode = head;
        while(currentNode != null){
            if(currentNode.random != null){
                currentNode.next.random = currentNode.random.next;
            }
            currentNode = currentNode.next.next;
        }

        // separate original and copied nodes
        currentNode = head;
        Node copyNodeHead = head.next;
        Node currentCopy = copyNodeHead;
        while(currentNode != null){
            currentNode.next = currentNode.next.next;
            if(currentCopy.next != null){
                currentCopy.next = currentCopy.next.next;
            }
            currentNode = currentNode.next;
            currentCopy = currentCopy.next;
        }
        return copyNodeHead;
    }

    private class Node{
        private int val;
        private Node next;
        private Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
