package org.akhil;

public class Solution {
    // Solution 1
    // O(Log(N))/O(1)   -> as any integer can atmax go till 32 bit hence while loop will at amx run 32 times which makes TC as O(1)
    // public int binaryGap(int n) {
    //     int lastOne = -1;
    //     int result = 0;
    //     int count = -1;

    //     while(n > 0){
    //         int bit = n%2;
    //         count++;
    //         if(bit == 1){
    //             if(lastOne == -1){
    //                 lastOne = count;
    //                 n=n/2;
    //                 continue;
    //             } else {
    //                 result = Math.max(result, count-lastOne);
    //                 lastOne = count;
    //             }
    //         }
    //         n=n/2;
    //     }

    //     return result;
    // }

    // -----------------------
    // Solution 2 - Simplified
    // O(1)/O(1)
    public int binaryGap(int n) {
        int lastOne = -1;
        int result = 0;

        // as we know that there can be at max 32 bits hence we can use for loop.
        for(int i=0; i<32; i++){
            int currBit = (n & 1);
            if(currBit == 1){
                if(lastOne == -1){
                    lastOne = i;
                } else {
                    result = Math.max(result, i-lastOne);
                    lastOne = i;
                }
            }
            // shift the n.
            // n = n>>1;
            n = n/2;
        }
        return result;
    }
}
