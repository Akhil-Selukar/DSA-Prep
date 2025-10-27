package org.akhil;

public class Solution {

    //O(N)/O(1)
    // TC will be O(N*M) where M is max length of string in bank, but it is given that it can be at max 500 chars so considering that as constant.
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        if(n <= 1){
            return 0;
        }

        int currBitCount = 0;
        int i = 0;
        while(currBitCount == 0 && i < n) {
            currBitCount = countBits(bank[i++]);
        }

        int result = 0;

        for(int index = i; index<n; index++){
            int nextBitCount = countBits(bank[index]);
            if(nextBitCount != 0){
                result = result +(currBitCount * nextBitCount);
                currBitCount = nextBitCount;
            }
        }
        return result;
    }

    private int countBits(String s) {
        int bitCount = 0;
        for(char ch:s.toCharArray()){
            if(ch == '1'){
                bitCount++;
            }
        }
        return bitCount;
    }
}
