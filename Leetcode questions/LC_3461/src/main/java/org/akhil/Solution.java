package org.akhil;

public class Solution {

    // O(N)/O(N)
    public boolean hasSameDigits(String s) {
        int n = s.length();
        int [] digits = new int[n];
        int iteration = 1;

        for(int i=0; i<n; i++){
            digits[i] = Character.getNumericValue(s.charAt(i));
        }

        while(iteration < (n-1)) {
            for (int i = 0; i <n-iteration; i++){
                digits[i] = (digits[i]+digits[i+1]) % 10;
            }
            iteration++;
        }

        return digits[0] == digits[1];
    }
}
