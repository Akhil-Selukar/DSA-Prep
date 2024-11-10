package org.akhil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueSolution {
    Queue<Integer> queue;

    public QueueSolution(){
        queue = new LinkedList<Integer>();
    }

    public void add(int value){
        this.queue.add(value);
    }

    public void reverseFirstK(int k){
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<k; i++){
            stack.push(this.queue.poll());
        }

        while(!stack.isEmpty()){
            this.queue.add(stack.pop());
        }

        for(int i=0; i<this.queue.size()-k; i++){
            queue.add(queue.poll());
        }
    }

    public void print()
    {
        while (!this.queue.isEmpty()) {
            System.out.print(this.queue.peek() + " ");
            this.queue.remove();
        }
    }

}
