package org.akhil;

public class CustomQueue {

    private int[] data;
    private int start = -1;
    private int end = -1;
    private int size = 0;

    public CustomQueue(int k) {
        this.data = new int[k];
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        } if(this.start == -1){
            this.start++;
        }
        this.end++;
        this.end = this.end % this.data.length;
        this.data[this.end] = value;
        this.size++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        this.start++;
        this.start = this.start % this.data.length;
        this.size--;
        return true;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return this.data[this.start];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return this.data[this.end];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.data.length;
    }
}
