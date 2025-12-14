package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    final int MOD = (int)(7+1e9);
    public int numberOfWays(String corridor) {
        int n = corridor.length();

        List<Integer> seatIndex = new ArrayList<>();

        for(int i=0; i<corridor.length(); i++){
            if(corridor.charAt(i) == 'S') {
                seatIndex.add(i);
            }
        }

        // we can only divide the corridor if there are even number of seats
        if(seatIndex.size()%2 != 0 || seatIndex.size() == 0){
            return 0;
        }

        // now partitions can only be added in the empty spaces between second seat of previous partition and first chair of next partition.
        long result = 1;
        int secondIndexOfPrev = seatIndex.get(1);

        for(int firstIndexOfCurr = 2; firstIndexOfCurr < seatIndex.size(); firstIndexOfCurr += 2){
            int allowedPlacesToPartition = seatIndex.get(firstIndexOfCurr) - secondIndexOfPrev;
            result = (result * allowedPlacesToPartition) % MOD;
            secondIndexOfPrev = seatIndex.get(firstIndexOfCurr + 1);
        }

        return (int)result;
    }
}
