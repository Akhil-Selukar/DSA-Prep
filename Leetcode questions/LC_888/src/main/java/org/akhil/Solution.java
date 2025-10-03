package org.akhil;

import java.util.HashSet;
import java.util.Set;

// First we calculate what is the difference i.e. how many candies Alice is short or surplus than Bob.
// then after receiving or giving that many (diff amount) of candies alice and bob must have same amount of candies
// Hence we are looking for amount of candies with Bob which can satisfy this condition.
public class Solution {
    // O(N)/O(N)
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceTotal = 0;
        int bobTotal = 0;
        Set<Integer> bobsCandies = new HashSet<>();

        for(int candy:aliceSizes){
            aliceTotal = aliceTotal + candy;
        }

        for(int candy:bobSizes){
            bobTotal = bobTotal + candy;
            bobsCandies.add(candy);
        }

        int diff = (aliceTotal - bobTotal)/2;

        for(int aliceCandies:aliceSizes){
            int target = aliceCandies - diff;
            if(bobsCandies.contains(target)){
                return new int[]{aliceCandies, target};
            }
        }

        return new int[] {-1, -1};
    }
}
