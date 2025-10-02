package org.akhil;

public class Solution {

    // Solution 1 - Using 2 while loops
//    public int maxBottlesDrunk(int numBottles, int numExchange) {
//        int result = 0;
//        int numEmpty = 0;
//
//        while(numBottles != 0){
//            result = result + numBottles;           // drink all full bottles first
//            numEmpty = numEmpty + numBottles;
//            numBottles = 0;
//
//            while(numEmpty/numExchange != 0) {
//                numBottles++;
//                numEmpty = numEmpty - numExchange;
//                numExchange++;
//            }
//        }
//        return result;
//    }


    // -------------------
    // Solution 2 - using only 1 while loop

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int result = numBottles;
        int numEmpty = numBottles;
        numBottles = 0;

        while(numEmpty >= numExchange){
            numEmpty = numEmpty - numExchange;          // perform the exchange
            numExchange++;                              // change the exchange rate
            numBottles++;                               // bottles got after exchange
            // after drinking the bottle got from exchange the empty bottles will increase by 1
            numEmpty++;
        }

        return result + numBottles;             // initial bottles + bottles we can get by exchange process
    }
}
