package org.akhil;

public class Solution {

    // O(N)/O(1)
    public int minOperations(String s) {
        int startWithZero = 0;
        int startWithOne = 0;

        for(int i=0; i<s.length(); i++){
            char bit = s.charAt(i);

            if(i%2 == 0){
                if(bit == '0'){
                    startWithOne++;
                } else {
                    startWithZero++;
                }
            } else {
                if(bit == '0'){
                    startWithZero++;
                } else {
                    startWithOne++;
                }
            }
        }

        return Math.min(startWithOne, startWithZero);
    }
}
