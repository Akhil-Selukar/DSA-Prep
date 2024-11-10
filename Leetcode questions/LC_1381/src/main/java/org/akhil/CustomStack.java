package org.akhil;

public class CustomStack {

    private int[] data;
    private int pointer = -1;

    public CustomStack(int maxSize) {
        data = new int[maxSize];
    }

    public void push(int x) {
        if (isFull()) {
            return;
        }
        this.pointer++;
        this.data[this.pointer] = x;
    }

    public int pop() {
        if(isEmpty()){
            return -1;
        }
        int popped = this.data[this.pointer];
        this.pointer--;
        return popped;
    }

    public void increment(int k, int val) {
        for(int i=0; i<=this.pointer && i<k; i++){
            this.data[i] = this.data[i]+val;
        }
    }

    private boolean isFull() {
        return this.data.length-1 == this.pointer;
    }

    private boolean isEmpty() {
        return this.pointer == -1;
    }

    public void print() {
        for(int i=0; i<=this.pointer; i++){
            System.out.print(this.data[i]+" -> ");
        }
        System.out.println();
    }
}
