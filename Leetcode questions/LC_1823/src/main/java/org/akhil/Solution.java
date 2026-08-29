package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // This is simple queue simulation.
    // O(N*K)/O(N)
//    public int findTheWinner(int n, int k) {
//        Queue<Integer> queue = new LinkedList<>();
//
//        // add all friends
//        for(int i=1; i<=n; i++){
//            queue.offer(i);
//        }
//
//        // simulate the game till we have only 1 friend left
//        while(queue.size() > 1){
//            for(int i=1; i<k; i++){
//                queue.offer(queue.poll());
//            }
//            queue.poll();   // this friend leaves the game
//        }
//
//        return queue.peek();    // last one in the queue is winner
//    }

    // --------------------------------------

    // Using simple maths
    // O(N)/O(1)
    public int findTheWinner(int n, int k) {
        int winner = 0;
        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }

        return winner + 1;
    }
}
