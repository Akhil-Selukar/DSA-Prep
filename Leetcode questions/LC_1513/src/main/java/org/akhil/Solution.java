package org.akhil;

public class Solution {

    // Solution 1 -
    // O(N)/O(1)
    final int MOD = 7+(int)1e9;
    public int numSub(String s) {
        int result = 0;
        int continuousOnes = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                continuousOnes++;
            } else {
                continuousOnes = 0;
            }
            result = (result % MOD) + continuousOnes;
        }

        return result;
    }
}
