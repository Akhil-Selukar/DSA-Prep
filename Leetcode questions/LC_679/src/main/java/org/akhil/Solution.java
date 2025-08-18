package org.akhil;

import java.util.ArrayList;
import java.util.List;


// O(1)/O(1) -> constant time and space complexity because it is given in the question that size of cards array will always be 4 and
// recursion depth for 4 values will always be same.
public class Solution {
    private static final double EPSILON = 0.01;        // to handle floating point precision error
    // (as it is mentioned in the question that the division is actual division and not the integer division hence
    // there can be decimal value precision error while comparing)
    public boolean judgePoint24(int[] cards) {

        // convert cards array to List as we want to do manipulations in it which is easy in case of List
        List<Double> cardValues = new ArrayList<>();
        for(int num:cards){
            cardValues.add((double)num);
        }

        return helper(cardValues);

    }

    private boolean helper(List<Double> cardValues) {
        // if only one value is left in cardValues and that is 24 then return true
        if(cardValues.size() == 1){
            // Simply comparing like below will give floating point precision error
            // (5/3 * 3) if we evaluate this it will give 3, but as in question it is mentioned that division is not integer division
            // hence here the answer will be (1.666666 * 2) = 3.33333.. thi precision error we want to handle hence we use Epsilon which is nothing but very small value (i.e. the error margin we are ok with)
//            if(cardValues.get(0) == 24) {
//                return true;
//            } else {
//                return false;
//            }

            if(Math.abs(cardValues.get(0) - 24) <= EPSILON) {
                return true;
            } else {
                return false;
            }
        }

        // we can take any combination of two numbers Hence we will have to create all combinations
        for(int i=0; i<cardValues.size(); i++){
            for(int j=i+1; j<cardValues.size(); j++){
                // as we are starting from j = i+1 hence below if statement will not be required (kept it just for understanding)
                if(i == j){
                    continue;
                }

                double a = cardValues.get(i);
                double b = cardValues.get(j);

                // Now 6 possible operations are possible on the pair which we will have to try one by one
                List<Double> possibleResult = new ArrayList<>();

                possibleResult.add(a + b);          // a+b = b+a hence took only 1.
                possibleResult.add(a * b);          // a*b = b*a
                possibleResult.add(a - b);
                possibleResult.add(b - a);

                // there can be divideByZeroException hence add a check
                if(Math.abs(b) > 0.0) {
                    possibleResult.add(a / b);
                }
                if(Math.abs(a) > 0.0){
                    possibleResult.add(b / a);
                }

                // get the remaining elements from cardValues and combine them with possibleResult one by one to explore all possibilities.
                List<Double> temp = new ArrayList<>();
                for(int k=0; k< cardValues.size(); k++){
                    if(k == i || k == j){
                        continue;
                    }
                    temp.add(cardValues.get(k));
                }

                // explore remaining values with each possible value one by one
                for(double possible:possibleResult){
                    temp.add(possible);
                    if(helper(temp)){       // if we got 24 then return true, no need to check further.
                        return true;
                    }
                    temp.remove(temp.size()-1);         // backtracking
                }
            }
        }
        return false;
    }
}
