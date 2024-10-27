package org.akhil;

public class CustomLinkedList {

    private Node head;
    private Node tail;

    public Node flatten(Node head) {
        if(head == null){
            return head;
        }

        Node currentNode = head;
        while(currentNode != null){
            // check if currentNode has child or not
            if(currentNode.child == null){
                currentNode = currentNode.next;
                continue;
            }
            // if child is present then traverse till the end of child node.
            Node childNode = currentNode.child;

            while(childNode.next != null){
                childNode = childNode.next;
            }

            // attach tail of childNode to next element in current list.
            childNode.next = currentNode.next;
            if(currentNode.next != null){
                currentNode.next.prev = childNode;
            }

            // remove the child from current and add as next node
            currentNode.next = currentNode.child;
            currentNode.next.prev = currentNode;
            currentNode.child = null;
        }
        return head;
    }

    private class Node{
        private int value;
        private Node next;
        private Node prev;
        private Node child;

        public Node(int value){
            this.value = value;
        }
    }
}
