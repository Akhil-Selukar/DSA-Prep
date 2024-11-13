package org.akhil;

import java.util.ArrayList;

public class FrontMiddleBackQueue {

    private ArrayList<Integer> queue;

    public FrontMiddleBackQueue() {
        this.queue = new ArrayList<>();
    }

    public void pushFront(int val) {
        queue.add(0, val);
    }

    public void pushMiddle(int val) {
        queue.add((queue.size())/2, val);
    }

    public void pushBack(int val) {
        queue.add(queue.size(), val);
    }

    public int popFront() {
        return queue.isEmpty() ? -1 : queue.remove(0);
    }

    public int popMiddle() {
        return queue.isEmpty() ? -1 : queue.remove((queue.size()-1)/2);
    }

    public int popBack() {
        return queue.isEmpty() ? -1 : queue.remove(queue.size()-1);
    }
}
