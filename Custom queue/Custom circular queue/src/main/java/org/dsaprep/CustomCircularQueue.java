package org.dsaprep;

public class CustomCircularQueue {
    private int[] data;
    private static final int DEFAULT_SIZE = 10;

    private int end = 0;
    private int front = 0;
    private int size = 0;

    public CustomCircularQueue(int size){
        this.data = new int[size];
    }

    public CustomCircularQueue(){
        this(DEFAULT_SIZE);
    }

    public boolean isFull() {
        return this.size == data.length; // ptr is at last index
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean add(int value) {
        if (isFull()) {
            System.out.println("Queue is full..!!");
            return false;
        }
        data[end++] = value;
        end = end % data.length;     // if end index goes beyond size of queue then we want to go in circular manner hence end should again go to index 0.
        size++;
        return true;
    }

    public int remove() throws CustomQueueException {
        if (isEmpty()) {
            throw new CustomQueueException("Queue is empty..!!");
        }
        int removed = data[front++];
        front = front % data.length;     // again implementing circular logic
        size--;
        return removed;
    }

    public int peek() throws CustomQueueException{
        if (isEmpty()) {
            throw new CustomQueueException("Queue is empty..!!");
        }
        return data[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty..!!");
            return;
        }
        int i = front;
        do {
            System.out.print(data[i] + " <- ");
            i++;
            i %= data.length;
        } while (i != end);         // we don't want to print end index because that is where new element will be added.
        System.out.println("END");
    }
}
