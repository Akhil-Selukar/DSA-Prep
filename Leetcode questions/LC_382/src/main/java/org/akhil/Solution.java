package org.akhil;

import java.util.Random;

public class Solution {
    ListNode head;
    Random rand;

    public Solution(ListNode head) {
        this.head = head;
        rand = new Random();
    }

    public int getRandom() {
        int result = -1;    // we will store result in this variable
        ListNode temp = head;
        int valSeen = 1;      //the current head (i.e. temp in this method)

        while(temp != null){
            // if we have only 1 value seen then its probability will be 1/1 i.e. 1. if we have seen 2 values then probability of each value will be
            // 1/2, in case of 3 values seen it will be 1/3 hence rand(valSeen) returning valSeen-1 (because rand(x) return values from [0, x-1]) will be
            // 1/valSeen i.e. every time equal probability will be ensured. (see readme for more understanding)
            if(rand.nextInt(valSeen) == valSeen-1){
                result = temp.val;
            }
            temp = temp.next;
            valSeen++;
        }

        return result;
    }
}
