package org.akhil;

public class Solution {

    // Here hint is think about converting number with only 1 bit set to 0 (i.e. number like 4, 8, 16, 32 etc). Then think
    // about given number in terms of relationship between such numbers
    // TC -> O(32) ~ O(1) constant
    // SC -> O(32) ~ O(1) constant
    public int minimumOneBitOperations(int n) {
        int[] preComputed = new int[32];        // to store steps required to convert number with only 1 set bit to 0
        preComputed[0] = 1;

        // fill the precomputed array
        for(int i=1; i<32; i++){
            preComputed[i] = 2 * preComputed[i-1] + 1;
        }

        // for given number n
        int result = 0;
        boolean sign = true;        // true -> +ve and false -> -ve

        // start from leftMost set bit
        for(int i=31; i>=0; i--){
            int ithBit = (n & (1<<i));

            if(ithBit == 0){
                continue;
            }

            if(sign) {
                result = result + preComputed[i];
                sign = false;
            } else {
                result = result - preComputed[i];
                sign = true;
            }
        }

        return result;
    }
}
