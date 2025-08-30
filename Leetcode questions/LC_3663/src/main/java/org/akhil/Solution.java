package org.akhil;

public class Solution {
    // O(N)/O(1) where N is number of digits in givn number (i.e. logN (base 10 log))
    public int getLeastFrequentDigit(int n) {
        int[] freq = new int[10];

        while(n != 0){
            int digit = n%10;
            freq[digit]++;
            n = n/10;
        }

        int result = 0;
        int f = Integer.MAX_VALUE;
        for(int i=9; i>=0; i--){
            if(freq[i] !=0 && f >= freq[i]){
                result = i;
                f = freq[i];
            }
        }

        return result;
    }
}
