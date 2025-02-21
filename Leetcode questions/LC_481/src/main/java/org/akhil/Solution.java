package org.akhil;

public class Solution {
    public int magicalString(int n) {
        if(n == 0) return 0;
        if(n <= 3) return 1;

        int[] magicString = new int[n+1];   // +1 because if nth number (1 or 2) has to be repeated 2 times then if we don't add 1 it might go out of bounds.
        magicString[0] = 1;
        magicString[1] = 2;
        magicString[2] = 2;

        int lastPartIndex = 2;
        int currentPartIndex = 3;
        int digit = 1;
        int count = 1;

        while(currentPartIndex < n){
            for(int i=0; i<magicString[lastPartIndex]; i++){
                magicString[currentPartIndex] = digit;
                if(digit == 1 && currentPartIndex < n){
                    count++;
                }
                currentPartIndex++;
            }
            digit = 3-digit;
            lastPartIndex++;
        }

        return count;
    }
}
