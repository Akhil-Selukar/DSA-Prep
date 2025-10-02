package org.akhil;

public class Solution {

    // Solution 1 - bruteforce
    // O(N)/O(1)
    public long maxNumber(long n) {
        long andResult = n;

        for(long i=n-1; i>=0; i--){
            andResult = andResult & i;
            if(andResult == 0){
                return i;
            }
        }
        return 0;
    }
}
