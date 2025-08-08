package org.akhil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - Using simple recursion
    // O(4^(N/25))/O(N)     will give TLE
//    int[][] servings = {{100, 0}, {75, 25}, {50, 50}, {25, 75}};
//    public double soupServings(int n) {
//        // we have N ml fo both A and B soup
//        return helper(n, n);
//    }
//
//    private double helper(int typeA, int typeB) {
//        if (typeA <= 0 && typeB <= 0) {
//            return 0.5;     // in case of both soups become empty we have to take only half probability.
//        }
//
//        if (typeA <= 0) {
//            return 1.0;       // if only A type soup becomes empty first we have to take full probability.
//        }
//
//        if (typeB <= 0) {
//            return 0.0;       // if only type B soup becomes empty first we dont need to take this probability in account.
//        }
//
//        double probability = 0.0;
//        for (int[] serving : servings) {
//            int remainingA = typeA - serving[0];
//            int remainingB = typeB - serving[1];
//
//            probability = probability + 0.25 * helper(remainingA, remainingB);      // multiplied by 0.25 because that is the probability of each option
//        }
//        return probability;
//    }


    // Solution 2 - using memoization
    // O(N^2)/O(N^2)     will give memory limit exceed
//    int[][] servings = {{100, 0}, {75, 25}, {50, 50}, {25, 75}};
//    public double soupServings(int n) {
//        // we have N ml fo both A and B soup
//        double dp[][] = new double[n+1][n+1];
//        for(double[] row:dp){
//            Arrays.fill(row, -1.0);
//        }
//
//        return helper(n, n, dp);
//    }
//
//    private double helper(int typeA, int typeB, double[][] dp) {
//        if (typeA <= 0 && typeB <= 0) {
//            return 0.5;     // in case of both soups become empty we have to take only half probability.
//        }
//
//        if (typeA <= 0) {
//            return 1.0;       // if only A type soup becomes empty first we have to take full probability.
//        }
//
//        if (typeB <= 0) {
//            return 0.0;       // if only type B soup becomes empty first we dont need to take this probability in account.
//        }
//
//        if(dp[typeA][typeB] != -1.0){
//            return dp[typeA][typeB];
//        }
//
//        double probability = 0.0;
//        for (int[] serving : servings) {
//            int remainingA = typeA - serving[0];
//            int remainingB = typeB - serving[1];
//
//            probability = probability + 0.25 * helper(remainingA, remainingB, dp);      // multiplied by 0.25 because that is the probability of each option
//        }
//        return dp[typeA][typeB] = probability;
//    }


//    // Solution 3 - just by adding a condition in solution 2 it will work
//    // O(N^2)/O(N^2)
//    int[][] servings = {{100, 0}, {75, 25}, {50, 50}, {25, 75}};
//    public double soupServings(int n) {
//
//        // There is a line given in question 'There is no operation that pours 0 mL from A and 100 mL from B.'
//        // Meaning as value of N increases we can take more and more 100ml of A (i.e. 0ml of B) so A will be reduced much faster
//        // and B will be reduced much slower. This will lead us to the point where A finishes before B. (so taking full probability)
//        // Hence as N increases the overall result approaches to 1, and in question it is mentioned that 'Answers within 10-5 of the actual answer will be accepted.'
//        // Hence, after some large value of N we can simply return 1 and we dont need to actually calculate the answer.
//        // This specific value of N can be calculated mathematically, but it is not expected in an interview, so we can simply
//        // say after some large value of N, the result will be very near to 1.
//        // (here for leetcode to accept the solution 4500 value is obtained by trying out different values)
//        if(n >= 4500){
//            return 1.0;
//        }
//
//        // we have N ml fo both A and B soup
//        double dp[][] = new double[n+1][n+1];
//        for(double[] row:dp){
//            Arrays.fill(row, -1.0);
//        }
//
//        return helper(n, n, dp);
//    }
//
//    private double helper(int typeA, int typeB, double[][] dp) {
//        if (typeA <= 0 && typeB <= 0) {
//            return 0.5;     // in case of both soups become empty we have to take only half probability.
//        }
//
//        if (typeA <= 0) {
//            return 1.0;       // if only A type soup becomes empty first we have to take full probability.
//        }
//
//        if (typeB <= 0) {
//            return 0.0;       // if only type B soup becomes empty first we dont need to take this probability in account.
//        }
//
//        if(dp[typeA][typeB] != -1.0){
//            return dp[typeA][typeB];
//        }
//
//        double probability = 0.0;
//        for (int[] serving : servings) {
//            int remainingA = typeA - serving[0];
//            int remainingB = typeB - serving[1];
//
//            probability = probability + helper(remainingA, remainingB, dp);      // multiplied by 0.25 because that is the probability of each option
//        }
//        return dp[typeA][typeB] = 0.25 * probability;
//    }


    // ----------------------------

    // Solution 4 - Slight optimization
    // O(N^2)/O(N^2)

    // Here in Memoization solution if we observe the soup is getting reduced by either 100, 75, 50 or 25 ml, so all values
    // in between will never occur, Hence if we take 2D array for memoization then out of 100 places only 4 will be useful and rest will be always
    // empty. So instead of wasting that much space we can use Map<String, Double> for memoization (this might add up fraction of second for hashing but
    // memory wise it will be much better.
    int[][] servings = {{100, 0}, {75, 25}, {50, 50}, {25, 75}};
    public double soupServings(int n) {

        // There is a line given in question 'There is no operation that pours 0 mL from A and 100 mL from B.'
        // Meaning as value of N increases we can take more and more 100ml of A (i.e. 0ml of B) so A will be reduced much faster
        // and B will be reduced much slower. This will lead us to the point where A finishes before B. (so taking full probability)
        // Hence as N increases the overall result approaches to 1, and in question it is mentioned that 'Answers within 10-5 of the actual answer will be accepted.'
        // Hence, after some large value of N we can simply return 1 and we dont need to actually calculate the answer.
        // This specific value of N can be calculated mathematically, but it is not expected in an interview, so we can simply
        // say after some large value of N, the result will be very near to 1.
        // (here for leetcode to accept the solution 4500 value is obtained by trying out different values)
        if(n >= 4500){
            return 1.0;
        }

        // we have N ml fo both A and B soup
        Map<String, Double> dp = new HashMap<>();

        return helper(n, n, dp);
    }

    private double helper(int typeA, int typeB, Map<String, Double> dp) {
        if (typeA <= 0 && typeB <= 0) {
            return 0.5;     // in case of both soups become empty we have to take only half probability.
        }

        if (typeA <= 0) {
            return 1.0;       // if only A type soup becomes empty first we have to take full probability.
        }

        if (typeB <= 0) {
            return 0.0;       // if only type B soup becomes empty first we dont need to take this probability in account.
        }

        String key = typeA + "-" + typeB;
        if(dp.containsKey(key)){
            return dp.get(key);
        }

        double probability = 0.0;
        for (int[] serving : servings) {
            int remainingA = typeA - serving[0];
            int remainingB = typeB - serving[1];

            probability = probability + helper(remainingA, remainingB, dp);      // multiplied by 0.25 because that is the probability of each option
        }
        dp.put(key, 0.25 * probability);

        return 0.25 * probability;
    }
}
