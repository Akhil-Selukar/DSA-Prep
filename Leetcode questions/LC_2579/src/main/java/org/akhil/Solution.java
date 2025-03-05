package org.akhil;

public class Solution {
    // Solution 1 - O(N)/O(1)
    // public long coloredCells(int n) {
    //     if(n == 0){
    //         return 0;
    //     }

    //     long coloredCells = 1;
    //     for(int i=2; i<=n; i++){
    //         coloredCells = coloredCells + (4 * (i-1));
    //     }

    //     return coloredCells;
    // }

    // Solution 2 - O(1)/O(1)
    public long coloredCells(int n) {
        if(n == 0){
            return 0;
        }

        return ((long) n * n) + ((long) (n - 1) * (n - 1));
    }
}
