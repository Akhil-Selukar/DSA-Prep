package org.akhil;

public class Solution {
    // O(logN)/O(1)
    public boolean hasAlternatingBits(int n) {
        int prev = -1;
        while(n>0){
            int curr = n%2;
            if(prev == -1){
                prev = curr;
                n=n/2;
                continue;
            }
            if(prev == curr){
                return false;
            }

            prev = curr;
            n=n/2;
        }
        return true;
    }
}
