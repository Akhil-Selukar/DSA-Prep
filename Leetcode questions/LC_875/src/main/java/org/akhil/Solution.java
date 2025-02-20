package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 (TLE)- Bruteforce (O(M*N)/O(1)) where M is largest number in arr and N is length of arr.
//    public int minEatingSpeed(int[] piles, int h) {
//        if(h < piles.length){
//            return -1;
//        }
//
//        int tempHr = h;
//        int k=1;
//        int index = 0;
//        while(tempHr >= 0 && index < piles.length){
//            int hrRequired = piles[index]/k + (piles[index]%k == 0 ? 0 : 1);
//            tempHr = tempHr - hrRequired;
//            if(tempHr<0){
//                k++;
//                index = 0;
//                tempHr = h;
//            } else {
//                index++;
//            }
//        }
//
//        return k;
//    }


    // Solution 2 - Binary search (O(NLog(M)/O(1)) where M is max value in array.
    public int minEatingSpeed(int[] piles, int h) {
        int startK = 1;
//        int endK = Arrays.stream(piles).max().getAsInt();
        int endK = (int)1e9;        // finding max will take O(N) while as given constraints has 10^9 as max value hence we can simply use that to improve response time by eliminating O(N) here.

        while(startK <= endK){
            int k = startK + (endK - startK)/2;
            if(canEatInTime(piles, k, h)){
                endK = k-1;
            } else {
                startK = k+1;
            }
        }
        return startK;
    }

    public boolean canEatInTime(int piles[], int k, int h){
        long hours = 0;
        for(int pile : piles){
            hours = hours + (pile / k + (pile % k == 0 ? 0 : 1));
        }
        return hours <= h;
    }
}
