package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - using HashMap
    // O(N)/O(1) - Space complexity is constant because at max there can be 6 possible values on domino hence there can be maximum of 6 keys in map
//    public int minDominoRotations(int[] tops, int[] bottoms) {
//        Map<Integer, Integer> count = new HashMap<>();
//        int n = tops.length;
//
//        for(int i=0; i<n; i++){
//            if(tops[i] == bottoms[i]){
//                count.put(tops[i], count.getOrDefault(tops[i], 0)+1);
//            } else {
//                count.put(tops[i], count.getOrDefault(tops[i], 0)+1);
//                count.put(bottoms[i], count.getOrDefault(bottoms[i], 0)+1);
//            }
//        }
//
//        int possibleVal = -1;
//        for(Map.Entry<Integer, Integer> entry:count.entrySet()){
//            if(entry.getValue() == n){
//                possibleVal = entry.getKey();
//                break;
//            }
//        }
//
//        if(possibleVal == -1){
//            return -1;
//        }
//        int bottomValid = 0;
//        int topValid = 0;
//
//        for(int i=0; i<n; i++){
//            if(tops[i] == possibleVal && bottoms[i] == possibleVal){
//                continue;
//            }
//            if(tops[i] == possibleVal){
//                bottomValid++;
//            }
//            if(bottoms[i] == possibleVal){
//                topValid++;
//            }
//        }
//
//        return Math.min(bottomValid, topValid);
//    }

    // Solution 2 - without using HashMap
    // TC and SC will be same but still as we are not using HashMap here and reduced some loops hence this will be a bit faster.
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int count1 = helper(tops, bottoms, tops[0]);
        if(count1 != -1){
            return count1;
        }
        int count2 = helper(tops, bottoms, bottoms[0]);
        return count2;
    }

    private int helper(int[] tops, int[] bottoms, int target) {
        int n = tops.length;
        int bottomValid = 0;
        int topValid = 0;

        for(int i=0; i<n; i++){
            if(tops[i] != target && bottoms[i] != target){
                return -1;
            }
            if(tops[i] == bottoms[i] && tops[i] == target){
                continue;               // if both faces are same and equal to target then no need to flip in any valid scenario.
            }
            if(tops[i] == target){
                bottomValid++;          // if tops[i] is correct then we only have to flip if we want to make bottom faces equal (i.e. bottomValid)
            }
            if(bottoms[i] == target){
                topValid++;             // if bottoms[i] is correct then we only have to flip if we want to make top faces equal (i.e. topValid)
            }
        }

        return Math.min(topValid, bottomValid);
    }
}
