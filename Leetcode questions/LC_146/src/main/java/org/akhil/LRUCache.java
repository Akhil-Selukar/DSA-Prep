package org.akhil;

import java.util.HashMap;
import java.util.Map;

/*
 * Time complexity for this code will be O(1) and space complexity will be O(Capacity)
 */

// Structure of node for double LinkedList
class Node{
    int key;        // to store key
    int value;      // to store value
    Node previous;  // to store previous Node
    Node next;      // to store next node

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.previous = null;
        this.next = null;
    }
}

public class LRUCache {

    private int capacity;
    private Map<Integer, Node> cache;
    // previous and next will be kind of dummy nodes to store reference LRU and MRU cache.
    private Node latest = null;
    private Node oldest = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.latest = new Node(0,0);      // dummy
        this.oldest = new Node(0,0);      // dummy
        this.latest.previous = this.oldest;     // ensure to form LinkedList using latest and oldest
        this.oldest.next = this.latest;
    }

    public int get(int key) {
        // if the key is present in cache map return the value (i.e. node) also make the node as MRU
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            // remove the node from its current position
            remove(node);
            // insert it at top as MRU node
            insert(node);

            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node temp = cache.get(key);
            remove(temp);   // remove the existing node as we need to add new one.
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);    // update the cache map
        // add the node in LinkedList
        insert(newNode);

        // if cache is size is greater than capacity then delete the LRU
        if(cache.size() > capacity){
            Node lru = oldest.next;     // this is why we need dummy (oldest is a dummy and next to it will be always LRU)
            cache.remove(lru.key);      // remove from cache map
            remove(lru);                // remove from LinkedList
        }
    }

    private void remove(Node node){
        // bypass the received node in LinkedList
        Node prevNode = node.previous;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.previous = prevNode;
    }

    private void insert(Node node){
        Node prevNode = latest.previous;
        Node nextNode = latest; // this is nothing but the dummy

        prevNode.next = node;
        nextNode.previous = node;

        node.next = nextNode;       // dummy in front of newly added node
        node.previous = prevNode;
    }
}
