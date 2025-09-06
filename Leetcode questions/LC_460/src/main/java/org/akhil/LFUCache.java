package org.akhil;

import java.util.HashMap;

// O(1)/O(1)
public class LFUCache {

    // Node structure to store cache data
    private class Node {
        int key;
        int val;
        Node next;
        Node prev;
        int freq = 1;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // DoublyLinkedList implementation
    private class DoublyLinkedList {
        Node head;
        Node tail;

        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        void addNode(Node node) {
            Node next = head.next;
            head.next = node;
            node.prev = head;
            head.next = node;
            node.next = next;
            next.prev = node;
        }

        Node removeNodeFromTail() {
            Node node = tail.prev;
            node.prev.next = tail;
            tail.prev = node.prev;
            return node;
        }

        Node removeNode(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            return node;
        }

        boolean isEmpty() {
            if (head.next == tail)
                return true;
            return false;
        }
    }


    // Global variables
    HashMap<Integer, DoublyLinkedList> freqList = new HashMap<Integer, DoublyLinkedList>();     // will hold all nodes in ordered fashion with same frequency
    HashMap<Integer, Node> cache = new HashMap<Integer, Node>();
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 1;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        freqList.get(node.freq).removeNode(node);

        // if no node is present for the frequency then clear that entry from map
        if (freqList.get(node.freq).isEmpty()) {
            if (minFreq == node.freq) {       // the freq is gone hence update the minimum freq.
                minFreq = node.freq + 1;
            }
        }

        node.freq = node.freq + 1;

        // put the node at updated frequency in map
        if (freqList.get(node.freq) == null) {
            DoublyLinkedList list = new DoublyLinkedList();
            list.addNode(node);
            freqList.put(node.freq, list);
        } else {
            freqList.get(node.freq).addNode(node);
        }
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (cache.get(key) != null) {
            Node node = cache.get(key);
            node.val = value;
            freqList.get(node.freq).removeNode(node);       // as this node is accessed hence remove it from curr freq and add in next freq.

            // if curr freq list becomes empty remove that entry from freq map.
            if (freqList.get(node.freq).isEmpty()) {
                if (minFreq == node.freq)
                    minFreq = node.freq + 1;
            }

            // update freq of current node
            node.freq = node.freq + 1;
            if (freqList.get(node.freq) == null) {
                DoublyLinkedList list = new DoublyLinkedList();
                list.addNode(node);
                freqList.put(node.freq, list);
            } else {
                freqList.get(node.freq).addNode(node);
            }
        } else {
            if (cache.size() == capacity) {
                Node node = freqList.get(minFreq).removeNodeFromTail();
                cache.remove(node.key);
            }
            Node newNode = new Node(key, value);

            cache.put(key, newNode);

            if (freqList.get(1) != null) {
                freqList.get(1).addNode(newNode);
            } else {
                DoublyLinkedList list = new DoublyLinkedList();
                list.addNode(newNode);
                freqList.put(1, list);
            }
            minFreq = 1;
        }
    }
}
