package org.akhil;

public class Solution {
    public int minBitFlips(int start, int goal) {
        int xorResult = start ^ goal;       // will give 1's at only places where we have different bits.
        int count = 0;

        while(xorResult > 0){
            count = count + (xorResult & 1);  // 1 & 1 will give 1 else it will give 0, hence count will be increased only when LSB of xorResult is 1.

            xorResult = xorResult >> 1;     // shift xorResult to right by 1 bit as LSB is already considered in above line.
        }

        return count;
    }
}
