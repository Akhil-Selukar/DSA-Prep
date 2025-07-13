package org.akhil;

import java.util.Arrays;

public class Solution {
    // O(NlogN + MlogM)/O(1)
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int perfectMatch = 0;

        if(players.length == 0 || trainers.length == 0){
            return perfectMatch;
        }

        Arrays.sort(players);
        Arrays.sort(trainers);

        int playerIndex = players.length-1;
        int trainerIndex = trainers.length-1;

        while(playerIndex >= 0 && trainerIndex >= 0){
            if(players[playerIndex] <= trainers[trainerIndex]){
                perfectMatch++;
                playerIndex--;
                trainerIndex--;
            } else {
                playerIndex--;
            }
        }

        return perfectMatch;
    }
}
