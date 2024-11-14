package org.akhil;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanner {

//    private ArrayList<Integer> arr;
//
//    public StockSpanner() {
//        arr = new ArrayList<>();
//    }
//
//    public int next(int price) {
//        if(this.arr.size() == 0){
//            this.arr.add(price);
//            return 1;
//        }
//        this.arr.add(price);
//        int count = 0;
//        for(int i = this.arr.size()-1; i>=0; i--){
//            if(this.arr.get(i)<=price){
//                count++;
//            } else {
//                return count;
//            }
//        }
//        return count;
//    }

//    -----------------------------------

    private ArrayList<Integer> arr;
    private Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack();
    }

    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek()[0]<=price){
            span = span + stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }
}
