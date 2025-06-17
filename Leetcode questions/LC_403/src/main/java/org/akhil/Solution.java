package org.akhil;

import java.util.*;

public class Solution {

    // Solution 1 - without memoization O(3^N) i.e. exponential so (TLE)
//    public boolean canCross(int[] stones) {
//        Set<Integer> set = new HashSet<>();
//
//        for(int stone:stones){
//            set.add(stone);
//        }
//
//        return helper(0, 1, set, stones[stones.length-1]);
//    }
//
//    private boolean helper(int position, int jump, Set<Integer> set, int destination) {
//        if(!set.contains(position + jump) || (jump == 0 && position != destination)){
//            return false;
//        }
//
//        if(position + jump == destination){
//            return true;
//        }
//
//        return helper(position + jump, jump-1, set, destination)
//                || helper(position + jump, jump, set, destination)
//                || helper(position + jump, jump+1, set, destination);
//    }


    // Solution 1.1 - a bit clean code without memoization (TLE)
//    public boolean canCross(int[] stones) {
//        if(stones[1] != 1){
//            return false;
//        }
//
//        Map<Integer, Integer> map = new HashMap<>();        // [stone number, stone index in stones array]
//        for(int i=0; i<stones.length; i++){
//            map.put(stones[i], i);
//        }
//
//        return helper(stones, 0, 0, map);
//    }
//
//    private boolean helper(int[] stones, int currStoneIndex, int prevJump, Map<Integer, Integer> map) {
//        if(currStoneIndex == stones.length-1){
//            return true;
//        }
//
//        boolean result = false;
//        for(int i=-1; i<=1; i++){
//            int nextJump = prevJump + i;
//            if(nextJump > 0){
//                int nextStone = stones[currStoneIndex] + nextJump;
//                if(map.containsKey(nextStone)) {
//                    result = result || helper(stones, map.get(nextStone), prevJump + i, map);
//                }
//            }
//        }
//        return result;
//    }

    public boolean canCross(int[] stones) {
        if(stones[1] != 1){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();        // [stone number, stone index in stones array]
        for(int i=0; i<stones.length; i++){
            map.put(stones[i], i);
        }

        Boolean[][] dp = new Boolean[2001][2001];

        return helper(stones, 0, 0, map, dp);
    }

    private boolean helper(int[] stones, int currStoneIndex, int prevJump, Map<Integer, Integer> map, Boolean[][] dp) {
        if(currStoneIndex == stones.length-1){
            return true;
        }

        if(dp[currStoneIndex][prevJump] != null){
            return dp[currStoneIndex][prevJump];
        }

        boolean result = false;
        for(int i=-1; i<=1; i++){
            int nextJump = prevJump + i;
            if(nextJump > 0){
                int nextStone = stones[currStoneIndex] + nextJump;
                if(map.containsKey(nextStone)) {
                    result = result || helper(stones, map.get(nextStone), prevJump + i, map, dp);
                }
            }
        }
        return dp[currStoneIndex][prevJump] = result;
    }
}
