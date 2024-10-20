package org.dsaprep;

public class CircularLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList() {
        this.size = 0;
    }

    public void insertElement(int value) {
        Node node = new Node(value);
        if (head == null) {
            this.head = node;
            this.tail = node;
            this.size += 1;
            return;
        }
        this.tail.next = node;
        node.next = this.head;
        this.tail = node;
        this.size += 1;
    }

    public void display() {
        Node temp = this.head;
        if (temp != null) {
            do {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            } while (temp != this.head);
        }
        System.out.print("END");
    }

    public int deleteElement(int value) {
        Node temp = this.head;
        if(temp == null) {      // nothing to delete
            return -1;
        }

        if(temp.value == value){        // deleting head itself
            this.head = temp.next;
            this.tail.next = this.head;
            this.size -= 1;
            return value;
        }

        Node previousNode = getPreviousNode(value);
        if (previousNode != null) {
            if(previousNode.next.equals(this.tail)){
                this.tail = previousNode;
            }
            previousNode.next = previousNode.next.next;
            this.size -= 1;
        }
        return value;
    }

    private Node getPreviousNode(int value) {
        Node temp = this.head;
        if (temp != null) {
            do {
                if (temp.next.value == value) {
                    return temp;
                }
                temp = temp.next;
            } while (temp != this.head);
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
