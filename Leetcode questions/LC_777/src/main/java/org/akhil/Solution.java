package org.akhil;

// Here important thing to note is even after doing the operations relative order of L and R has to be same in start and result.
// Second important thing to note is XL can be converted to LX but reverse is NOT possible
// Same in case of RX can be converted to XR but reverse IS NOT POSSIBLE.

public class Solution {

    // Solution - using 2 pointers
    // O(N)/O(1)
    public boolean canTransform(String start, String result) {
        int startPointer = 0;
        int resultPointer = 0;
        int startLen = start.length();
        int resultLen = result.length();

        while (startPointer < startLen || resultPointer < resultLen)
        {
            // skip all 'X'
            while (startPointer < startLen && start.charAt(startPointer) == 'X') {
                startPointer++;
            }
            while (resultPointer < resultLen && result.charAt(resultPointer) == 'X') {
                resultPointer++;
            }

            if (startPointer >= startLen || resultPointer >= resultLen) {
                break;
            }

            // relative order for 'R' and 'L' in 2 strings should be the same
            if (start.charAt(startPointer) != result.charAt(resultPointer)) {
                return false;
            }
            // R can only move to right
            // i.e. if we have XR in start then that can not be changed to RX
            // Hence the char we are checking is R and j<i i.e. in result R is before ith index in start then that can not be reversed
            // so we can not form the result string
            if (start.charAt(startPointer) == 'R' && startPointer > resultPointer) {
                return false;
            }
            // L can only move to left
            // i.e. if we have LX in start then we can noyt change it to XL
            // hence if the char we are comparing is L and i<j i.e. in strat string L is appearing before jth index of result String
            // we can not switch and make it correct.
            if (start.charAt(startPointer) == 'L' && startPointer < resultPointer) {
                return false;
            }

            // check next
            startPointer++;
            resultPointer++;
        }

        return startPointer == resultPointer;
    }
}
