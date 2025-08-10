package org.akhil;

import java.util.Arrays;

public class Solution {
    // O(L+LlogL)/O(logL)
    public boolean reorderedPowerOf2(int n) {
        String sortedNum = getSortedString(n);

        // after 31 it will be out of int range and given n is int
        for(int i=0; i<31; i++){
            int expectedVal = (1<<i);     // every power of 2 using left shift on 1 in binary system
            String stringVal = getSortedString(expectedVal);

            if(sortedNum.equals(stringVal)){
                return true;
            }
        }
        return false;
    }

    private String getSortedString(int n){
        String num = String.valueOf(n);         // O(L)
        char[] numArr = num.toCharArray();      // O(L)
        Arrays.sort(numArr);                    // O(LlogL)

        return new String(numArr);
    }
}
