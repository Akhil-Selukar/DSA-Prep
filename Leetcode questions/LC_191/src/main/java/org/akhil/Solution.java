package org.akhil;

public class Solution {
    // Somple solution but not for interview.
    // public int hammingWeight(int n) {
    //     return Integer.bitCount(n);
    // }

    // ------------------
    // Solution -> for interview
    // O(logN)/O(1)
    public int hammingWeight(int n) {
        int count = 0;
        while(n > 0){
            if(n%2 == 1){
                count++;
            }
            n = n/2;
        }

        return count;
    }
}
