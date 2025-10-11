package org.akhil;

import java.util.*;

public class Solution {
    // here important thing to note if we have casted a spell with power 1 then we can not cast another spell with power
    // 0 and -1 because of (power[i-1] and power[i]-2 is not allowed) and spell with power 1 and 2 because (power[i]+1 and power[i]+2
    // is not allowed) BUT WE CAN CAST another spell of SAME POWER i.e. 1 (power[i]) if duplicates are there.
    // for example in testcase 1 we have [1,1,3,4] we can cast 1 two times and a 4 to maximize the damage. hence answer is 6.
    // So we can conclude that if there are any duplicates and we can cast that power spell even once then that means we have to consider
    // all duplicates aswell. This indicates us to store frequency of each power i.e. use hashMap.
    // next we have choice to either cast a spell and skip next 2 and previous 2 or skip current spell and case immediate next oe previous.
    // Which is standard pick, not pick problem. In case of pick just skip all the next/previous values which are in the range of power[i]+2
    // and power[i]-2.
    // Now the remaining question is of how to handle the check in both the directions because we can either go to right of power[i]+2 or
    // left of power[i]-2. To solve this we can simply sort the unique powers in given array. (why unique because earlier we have already
    // inferred that if a power is present multiple times and we are considering that power then we have to consider all occurrences of it.
    // so we can simply multiple that power with its frequency and add it in the total damage, we are already storing the frequency so need
    // to worry about duplicates now)
    // And after sorting instead of checking in both the directions we can just check one direction i.e. if we start from lower power first
    // lets say in sorted unique powers [1,2,3,4,5,6,7] if we start from 1 and considered it then there are no lower power available as we are
    // starting from lowest one, and as we have considered it so we cant consider 2 and 3 so we will move to 4. Now if we are considering 4
    // we dont have to worry about left side of 4 because those will be 3 and 2 which we have already skipped because of 1 hence
    // just check in forward direction also if we choose to skip 4 then we will move to 5 in that case left side skip candidates will be 4 and 3
    // both are already skipped 3 because we have chosen 1 and 4 because we decided not to pick that hence only direction we need to consider is
    // forward only.

    // Solution 1 without using binary search
    // O(NlogN + U^2)/O(N) where U is number of unique values in power
    // This will give TLE because we are still going through all index in while loop to skip invalid powers
    // we can use binary search with upper bound there.
//    public long maximumTotalDamage(int[] power) {
//        int n = power.length;
//        Map<Integer, Integer> freq = new HashMap<>();
//        List<Integer> unique = new ArrayList<>();
//
//        // find freq and populate unique
//        for(int val:power){                         // O(N)
//            freq.put(val, freq.getOrDefault(val, 0)+1);
//
//            if(!unique.contains(val)){
//                unique.add(val);
//            }
//        }
//
//        // sort the unique
//        Collections.sort(unique);           // O(UlogU)
//
//        // find the power recursively using pick/not-pick
//        long[] dp = new long[unique.size()];
//        Arrays.fill(dp, -1);
//        return helper(0, unique, freq, dp);
//    }
//
//    private long helper(int index, List<Integer> unique, Map<Integer, Integer> freq, long[] dp) {
//        if(index >= unique.size()){
//            return 0;
//        }
//
//        if(dp[index] != -1){
//            return dp[index];
//        }
//
//        // pick condition
//        long pickPower = unique.get(index);
//        // skip power[i]+1 and power[i]+2
//        int spellDuplicate = freq.get(unique.get(index));
//        int pickIndex = index+1;        // need to keep original index as it is because in not pick case we will need it
//        while(pickIndex < unique.size() && unique.get(pickIndex) <= pickPower+2){
//            pickIndex++;
//        }
//        pickPower = (pickPower*spellDuplicate) + helper(pickIndex, unique, freq, dp);
//
//        // not pick condition
//        long notPickPower = helper(index+1, unique, freq, dp);
//
//        return dp[index] = Math.max(pickPower, notPickPower);
//    }


    //-------------------------
    // Solution 2 - Minor tweak to remove square component in TC
    // O(NlogN + U^2)/O(N) where U is number of unique values in power
    // Accepted
    public long maximumTotalDamage(int[] power) {
        int n = power.length;
        Map<Integer, Integer> freq = new HashMap<>();

        // find freq and populate unique
        for(int val:power){                         // O(N)
            freq.put(val, freq.getOrDefault(val, 0)+1);
        }

        List<Integer> unique = new ArrayList<>(freq.keySet());

        // sort the unique
        Collections.sort(unique);           // O(UlogU)

        // find the power recursively using pick/not-pick
        long[] dp = new long[unique.size()];
        Arrays.fill(dp, -1);
        return helper(0, unique, freq, dp);
    }

    private long helper(int index, List<Integer> unique, Map<Integer, Integer> freq, long[] dp) {
        if(index >= unique.size()){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        // pick condition
        long pickPower = unique.get(index);
        // skip power[i]+1 and power[i]+2
        int spellDuplicate = freq.get(unique.get(index));
        int pickIndex = index+1;        // need to keep original index as it is because in not pick case we will need it
        while(pickIndex < unique.size() && unique.get(pickIndex) <= pickPower+2){
            pickIndex++;
        }
        pickPower = (pickPower*spellDuplicate) + helper(pickIndex, unique, freq, dp);

        // not pick condition
        long notPickPower = helper(index+1, unique, freq, dp);

        return dp[index] = Math.max(pickPower, notPickPower);
    }
}
