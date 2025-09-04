package org.akhil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {

    // structure of LinkedList node
    private class Node{
        int count;
        Node prev;
        Node next;
        Set<String> keys;       // set of keys because for multiple keys count can become same and we need to do operations in O(1)

        public Node(int count, String key){
            this.count = count;
            this.keys = new HashSet<>();
            keys.add(key);
            this.prev = null;
            this.next = null;
        }
    }

    // global variables to track keys and their corresponding nodes
    Map<String, Node> map;
    private Node head;
    private Node tail;

    // initialize global variables
    public AllOne() {
        map = new HashMap<String, Node>();
        head = null;        // we cant define head and tail as dummy here because in dummy what key we will give? ("" can also be a valid key from input)
        tail = null;        // this is different that LRU cache here, and hence during other function small changes will be there (handling null pointer)
    }

    // simple to implement
    // as any key will work having max value hence from set of head we will return one key
    public String getMaxKey() {
        if(head == null){
            return "";
        }
        return tail.keys.iterator().next();
    }

    // similar to head for min key we will return any key from tail node
    public String getMinKey() {
        if(head == null){
            return "";
        }
        return head.keys.iterator().next();
    }

    // increment/addition of new key
    public void inc(String key) {
        // if key already present, then based on incremented count put the key is appropriate node's set and modify map accordingly
        if(map.containsKey(key)){
            Node node = map.get(key);
            // remove key from this node
            node.keys.remove(key);

            int count = node.count;

            if(node.next == null){
                // need to create a new node
                Node newNode = new Node(count+1, key);
                newNode.prev = node;
                node.next = newNode;
                tail = newNode;
                map.put(key, newNode);
            } else {
                // add current key in next node if immediate next count is present
                Node nextNode = node.next;
                // if immediate next count node is present
                if(nextNode.count == count+1){
                    nextNode.keys.add(key);
                    map.put(key, nextNode);
                } else {
                    // create a new node and place it between current and next node
                    Node newNode = new Node(count+1, key);
                    newNode.next = nextNode;
                    nextNode.prev = newNode;
                    node.next = newNode;
                    newNode.prev = node;
                    map.put(key, newNode);
                }
            }

            // IMPORTANT - After this shifting if the current node's key became empty, then we have to remove that node
            if(node.keys.size() == 0){
                removeNode(node);
            }
        } else {
            // if the key is new and first ever key in data structure
            if(head == null){       // means no key was added earlier
                head = new Node(1, key);
                tail = head;        // only 1 node hence head and tail are same
                map.put(key, head);
            } else {
                if(head.count == 1){
                    head.keys.add(key);
                    map.put(key, head);
                } else {
                    Node newNode = new Node(1, key);
                    newNode.next = head;
                    head.prev = newNode;
                    head = newNode;
                    map.put(key, newNode);
                }
            }
        }
    }

    public void dec(String key) {
        // if key is not present in map the no need to do anything
        if(!map.containsKey(key)){
            return;
        }

        Node node = map.get(key);
        node.keys.remove(key);
        int count = node.count;

        if(count == 1){
            // after decrement the count will be 0 so we will have to remove the key.
            map.remove(key);
        } else if (node == head) {      // we only have to handle head condition because decrementing from tail will have some node before tail (unless head == tail)
            Node newNode = new Node(count-1, key);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            map.put(key, newNode);
        } else {
            if(node.prev.count == count-1){
                node.prev.keys.add(key);
                map.put(key, node.prev);
            } else {
                Node newNode = new Node(count-1, key);
                Node prev = node.prev;
                prev.next = newNode;
                newNode.prev = prev;
                newNode.next = node;
                node.prev = newNode;
                map.put(key, newNode);
            }
        }

        // IMPORTANT - After this shifting if the current node's key became empty, then we have to remove that node
        if(node.keys.size() == 0){
            removeNode(node);
        }
    }

    private void removeNode(Node node){
        if(node == head){
            Node next = node.next;
            if(next != null) {
                next.prev = null;
            }
            node.next = null;
            head = next;
        } else if (node == tail){
            Node prev = node.prev;
            if(prev != null) {
                prev.next = null;
            }
            node.prev = null;
            tail = prev;
        } else {
            // the node to delete is a middle node
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            node.next = null;
            node.prev = null;
        }
    }

}
