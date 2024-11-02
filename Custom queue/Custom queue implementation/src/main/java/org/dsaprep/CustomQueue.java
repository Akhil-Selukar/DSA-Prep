package org.dsaprep;

public class CustomQueue {
    private int[] data;
    private static final int DEFAULT_SIZE = 10;

    private int endPtr =0;

    public CustomQueue(int size){
        this.data = new int[size];
    }

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public boolean add(int value){
        if(isFull()){
            System.out.println("Queue is full..!!");
            return false;
        }
        this.data[this.endPtr++] = value;
        return true;
    }

    public int remove() throws CustomQueueException {
        if(isEmpty()){
            throw new CustomQueueException("Queue is empty..!!");
        }
         int removed = this.data[0];

        // Shift other elements to left
        for(int i=1; i<this.endPtr; i++){
            this.data[i-1] = this.data[i];
        }
        this.endPtr--;
        return removed;
    }

    public int peek() throws CustomQueueException {
        if(isEmpty()){
            throw new CustomQueueException("Queue is empty..!!");
        }

        return this.data[0];
    }

    public void display(){
        for(int i=0; i<this.endPtr; i++){
            System.out.print(this.data[i] + " <- ");
        }
        System.out.print("END");
        System.out.println();
    }

    private boolean isFull(){
        return this.endPtr == this.data.length;
    }

    private boolean isEmpty(){
        return this.endPtr == 0;
    }

}
