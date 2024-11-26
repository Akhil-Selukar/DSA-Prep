package org.dsaprep;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
    private ArrayList<T> list;

    public Heap() {
        list = new ArrayList<>();
    }

    private void swap(int firstIndex, int secondIndex) {
        T temp = this.list.get(firstIndex);
        this.list.set(firstIndex, this.list.get(secondIndex));
        this.list.set(secondIndex, temp);
    }

    private int parentIndex(int i) {
        return (i - 1) / 2;         // (i-1)/2 (and not i/2 as mentioned in README.md) because here we are starting index value with 0.
    }

    private int leftIndex(int i) {
        return (i * 2) + 1;
    }

    private int rightIndex(int i) {
        return (i * 2) + 2;
    }

    public void insert(T val){
        this.list.add(val);         // step 1 : add element at last index.
        upheap(list.size()-1);      // step 2 : start comparing with parent and move upward.
    }

    private void upheap(int index){
        if(index == 0){         // if this is top node then no need to go up.
            return;
        }

        int parentIndex = parentIndex(index);
        if(list.get(index).compareTo(list.get(parentIndex)) > 0){       // checking parent < added element because we are implementing maxHeap. (will be reversed in case of minHeap)
            swap(index, parentIndex);
            upheap(parentIndex);
        }
    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Heap is empty..!!");
        }

        T temp = list.get(0);

        // moving last element to the top
        T last = list.remove(list.size()-1);

        if(!list.isEmpty()){
            list.set(0, last);
            downheap(0);            // start checking from top till bottom and swap if required.
        }

        return temp;
    }

    private void downheap(int parentIndex){
        int maxIndex = parentIndex;
        int leftIndex = leftIndex(parentIndex);
        int rightIndex = rightIndex(parentIndex);

        if(leftIndex < list.size() && list.get(maxIndex).compareTo(list.get(leftIndex)) < 0){
            maxIndex = leftIndex;
        }
        if(rightIndex < list.size() && list.get(maxIndex).compareTo(list.get(rightIndex)) < 0){
            maxIndex = rightIndex;
        }

        if(maxIndex != parentIndex){    // if swap is required.
            swap(maxIndex, parentIndex);
            downheap(maxIndex);
        }
    }

    public ArrayList<T> heapSort() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Heap is Empty..!!");
        }

        ArrayList<T> sortedList = new ArrayList<>();
        while(!list.isEmpty()){
            sortedList.add(this.remove());          // here we are calling this.remove because we want to call remove function from this class and not from List interface.
        }

        return sortedList;      // here the sortedList will be in descending order because we have implemented maxHeap.
    }
}
