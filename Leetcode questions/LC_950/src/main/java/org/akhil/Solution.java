package org.akhil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // Here we need to make sure that the cards are revealed in ascending order after rearranging. So to rearrange we first
    // need to know the correct order of cards. Hence we will need to sort the cards.
    // Now based on the reveal rule we need to make sure that the correct card is placed at correct index. Hence here we
    // are more concerned about index at which the card is. So we need to figure out the order of index in which the
    // cards will show up on the top. Once we know the index order we can simply place the sorted cards at those indices
    // Now if we observe the operation which we are doing, pick one card, reveal it, pick next card put it at the bottom
    // so the bottom card will be picked last. This is nothing but the queue. (card which is going at the back of deck (bottom)
    // first will come on deck first) (FIFO).
    // so we can simply simulate the indices in queue using the given rule and at revealing indices we can put the cards
    // in sorted order.

    // O(N)/O(N)
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Queue<Integer> queue = new LinkedList<>();

        // add all indices in queue
        for(int i=0; i<n; i++){
            queue.offer(i);
        }

        // sort the deck and simulate the  revealing operation to place correct card in correct position
        Arrays.sort(deck);
        int[] result = new int[n];
        int cardNo = 0;     // card index in sorted deck

        while(!queue.isEmpty()){
            // reveal one card (this will be revealed)
            result[queue.poll()] = deck[cardNo++];

            // put next card and place it at back (by card here we mean index)
            if(!queue.isEmpty()){
                queue.offer(queue.poll());
            }
        }

        return result;
    }
}
