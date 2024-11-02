package org.dsaprep;

public class CustomStack {
    private int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public CustomStack(int size){
        this.data = new int[size];
    }

    public CustomStack(){
        this(DEFAULT_SIZE);
    }

    public boolean push(int value){
        if(isFull()){
            System.out.println("Stack is full..!!");
            return false;
        }
        this.ptr++;
        data[ptr] = value;
        return true;
    }

    public int pop() throws CustomStackException {
        if(isEmpty()){
            throw new CustomStackException("Stack is empty!!");
        }
        return data[this.ptr--];
    }

    public int peek() throws CustomStackException {
        if(isEmpty()){
            throw new CustomStackException("Stack is empty!!");
        }
        return data[this.ptr];
    }

    private boolean isFull() {
        return this.ptr == data.length-1;
    }

    private boolean isEmpty() {
        return this.ptr == -1;
    }
}
