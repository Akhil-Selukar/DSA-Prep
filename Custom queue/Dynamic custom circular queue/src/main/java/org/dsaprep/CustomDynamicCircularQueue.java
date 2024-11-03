package org.dsaprep;

public class CustomDynamicCircularQueue extends CustomCircularQueue {

    public CustomDynamicCircularQueue(int size){
        super(size);
    }

    public CustomDynamicCircularQueue(){
        super();
    }

    @Override
    public boolean add(int value) {
        if(isFull()){
            int[] temp = new int[this.data.length * 2];

            for(int i=0; i<this.data.length; i++){
                temp[i] = this.data[(start+i) % this.data.length];
            }
            start = 0;
            end = data.length;
            data = temp;
        }
        return super.add(value);
    }
}
