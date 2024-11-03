package org.dsaprep;

public class CustomCircularQueue {

    protected int[] data;
    private static final int DEFAULT_VALUE = 10;

    protected int start = 0;
    protected int end = 0;
    protected int size = 0;

    public CustomCircularQueue(int size){
        this.data = new int[size];
    }

    public CustomCircularQueue(){
        this(DEFAULT_VALUE);
    }

    public boolean isFull() {
        return this.size == data.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean add(int value){
        if(isFull()){
            System.out.println("Queue is full..!!");
            return false;
        }
        this.data[end++] = value;
        end = end % this.data.length;
        this.size++;
        return true;
    }


    public int remove() throws CustomQueueException{
        if(isEmpty()){
            throw new CustomQueueException("Queue is empty..!!");
        }
        int removed = this.data[start++];
        start = start % this.data.length;
        this.size--;
        return removed;
    }

    public int peek() throws CustomQueueException{
        if(isEmpty()){
            throw new CustomQueueException("Queue is empty..!!");
        }
        return this.data[start];
    }

    public void display(){
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        int i = start;
        do {
            System.out.print(data[i] + " -> ");
            i++;
            i = i % this.data.length;
        } while (i != end);
        System.out.println("END");
    }
}
