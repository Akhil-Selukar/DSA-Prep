package org.akhil;

public class Solution {
    public int reverseBits(int n) {
        int[] bits = new int[32];
        int index = 31;
        while(n > 0){
            bits[index--] = n%2;
            n=n/2;
        }

        index = 0;
        int result = 0;
        while(index < 32){
            result = result + (bits[index] * (int)Math.pow(2, index));
            index++;
        }
        return result;
    }
}
