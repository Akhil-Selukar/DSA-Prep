package org.akhil;

public class Solution {
    // O(1)/O(1)
    public boolean canAliceWin(int n) {
        int toRemove = 10;
        boolean aliceTurn = true;

        while(toRemove > 0 && n >= toRemove){
            n = n - toRemove;
            toRemove--;
            aliceTurn = !aliceTurn;
        }

        return !aliceTurn;
    }
}
