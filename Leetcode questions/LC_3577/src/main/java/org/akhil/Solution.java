package org.akhil;

public class Solution {
    // O(N)/O(1)
    final int MOD = (int)(7+1e9);
    public int countPermutations(int[] complexity) {
        // check if complexity[0] is unique and minimum, then only we are able to unlock all computers
        int n = complexity.length;
        for(int i=1; i<n; i++){
            if(complexity[0] >= complexity[i]){
                return 0;
            }
        }

        // if complexity[0] is unique and minimum in given array then for all permutations we can simply use (n-1)!.
        // why (n-1), because 0th indexed computer is already unlocked hence we are allowed to rearrange only (n-1) values
        long result = 1;

        for(int i=1; i<=n-1; i++){
            result = (result * i) % MOD;
        }

        return (int)result;
    }
}
