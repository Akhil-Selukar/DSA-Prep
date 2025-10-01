package org.akhil;

// Question understanding
// we are given full bottles that we can drink and make them empty and by exchanding them in market get new full bottles to drink.

// explaination for TC
// the number of iterations depends on numExchange (i.e. if exchange rate is higher we will be able to get LESS new bottles reducing the iteration while if exchange rate is lower we will be able to get MORE full bottles and number of iterations will be more.)
// Hence to calculate TC we will go with worst scenario i.e. lower exchange rate (2 is lowest given in constraints)
// So if we have 10 bottles initially then in next iteration we will get 10/2 = 5 bottles then 5/2 i.e. 2 bottles and so on
// so the bottles will be 10, 5, 2, 1, 1 so total 5 iterations (i.e. nothing but we are checking how many times given number of bottles
// can be divided by 2). So it is 'N/2^x = 1' where N is initial number of bottles and x is the number of times we can divide the bottles by 2, i.e. x is the number of iterations. Hence we need to calculate x so we can simplify it like below
// N = 2^x
// taking log on both sides
// logN = log(2^x)
// logN = x*log2
// logN/log2 = x
// hence, logN to the base 2 = x
// Now 2 was the exchange rate so we can say `logN to the base exchange rate = x` i.e TC

class Solution {
    // O(logN to the base M)/O(1)  where N is number of bottles and M is exchange rate.
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;       // whatever full bottles we have we can drink them.
        int emptyBottles = numBottles;    // after drinking full bottles those will be empty and available to trade.

        while(emptyBottles / numExchange != 0){
            numBottles = emptyBottles / numExchange;

            // remaining empty bottles after exchange
            emptyBottles = emptyBottles % numExchange;

            result = result + numBottles;       // drink new full bottles
            emptyBottles = emptyBottles + numBottles;
        }

        return result;
    }
}