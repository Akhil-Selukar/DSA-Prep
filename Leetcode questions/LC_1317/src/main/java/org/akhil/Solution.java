package org.akhil;

public class Solution {
    // O(N)/O(1)
    public int[] getNoZeroIntegers(int n) {
        for(int i=1; i<=n; i++){
            if(!hasZeros(n-i) && !hasZeros(i)){
                return new int[]{n-i, i};
            }
        }
        return new int[]{-1, -1};
    }

    private boolean hasZeros(int num){
        while(num > 0){
            if(num % 10 == 0){
                return true;
            }
            num = num/10;
        }

        return false;
    }
}
