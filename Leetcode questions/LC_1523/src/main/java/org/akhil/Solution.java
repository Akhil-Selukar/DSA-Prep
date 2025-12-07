package org.akhil;

public class Solution {
    // // Solution 1 - bruteforce (TLE)
    // // O(N)/O(1)
    // public int countOdds(int low, int high) {
    //     int result = 0;
    //     for(int i=low; i<=high; i++){
    //         if(i%2 == 1){
    //             result++;
    //         }
    //     }

    //     return result;
    // }

    // ---------------
    // Solution 2 - Optimized
    // O(1)/O(1)
    // public int countOdds(int low, int high) {
    //     int result = 0;
    //     result = result + low%2==0 ? 0 : 1;
    //     result = result + high%2==0 ? 0 : 1;

    //     if(result < 2){
    //         result = result + ((high - low)/2);
    //     } else {
    //         result = result + ((high - low)/2) - 1;
    //     }

    //     return result;
    // }

    // ----------------
    // Solution 3 - More clean code
    // O(1)/O(1)
    public int countOdds(int low, int high) {
        int result = 0;
        int diff = high-low;

        result = diff/2 + diff%2;

        if(low%2 == 1 && high%2 == 1){
            result++;
        }
        return result;
    }
}
