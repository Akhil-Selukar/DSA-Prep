package org.dsaprep;

public class DynamicCustomStack extends CustomStack {
    public DynamicCustomStack(int size){
        super(size);
    }

    public DynamicCustomStack(){
        super();
    }

    @Override
    public boolean push(int value) {
        if(this.isFull()){
            // double the size of array.
            int[] temp = new int[this.data.length*2];

            // copy all elements from old array to new array.
            for(int i=0; i<this.data.length; i++){
                temp[i] = this.data[i];
            }
            this.data = temp;
        }
        // finally add the element
        return super.push(value);
    }
}
