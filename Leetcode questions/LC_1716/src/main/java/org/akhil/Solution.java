package org.akhil;

public class Solution {
//    // Solution 1 - Bruteforce (Simulation)
//    // O(N)/O(1)
//    public int totalMoney(int n) {
//        int previousMonday = 1;
//        int totalMoney = 0;
//
//        while(n > 0){
//            int todayContribution = previousMonday;
//            for(int i=0; i<Math.min(n, 7); i++){
//                totalMoney = totalMoney + todayContribution;
//                todayContribution++;
//            }
//            previousMonday = previousMonday+1;      // next week will start with previousMonday+1 $
//            n = n-7;        // 1 week is considered;
//        }
//
//        return totalMoney;
//    }


    // Solution 2 - Using arithmetic progression
    // O(1)/O(1)
    /*
        arithmetic progression formulas
        a -> first term
        d -> common difference
        l -> last term

        sum of n terms = n*(a+l)/2;
        last term (l) = a + (numOfTerms - 1)*d

     */
    public int totalMoney(int n) {
        int fullWeeks = n/7;
        int partialDays = n%7;

        // total money in full weeks
        int totalMoney = 0;
        if(n >= 7) {
            int lastTerm = 28 + (fullWeeks - 1) * 7;
            // in below calculation (28+lastTerm) can be odd so we need to handle decimal value as well.
            totalMoney = (int)((long)fullWeeks * ((28 + lastTerm) / 2.0));
        }
        // money collected in remaining days
        int startOfThatWeek = fullWeeks + 1;
        for(int start = 1; start <= partialDays; start++){
            totalMoney = totalMoney + startOfThatWeek;
            startOfThatWeek++;
        }

        return totalMoney;
    }
}
