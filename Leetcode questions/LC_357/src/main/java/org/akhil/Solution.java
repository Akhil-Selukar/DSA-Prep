package org.akhil;

public class Solution {

    // O(n)/O(1)
    public int countNumbersWithUniqueDigits(int n) {
        // edge case
        if(n == 0){
            return 1;
        }

        int total = 10;  // in case of n=1 all digit from 0 to 9 will be unique digit numbers.
        int availableOptions = 9;       // for 2 digit numbers available options for 2nd digits are 0 to 9 minus digit at 1st place hence 9.

        for(int i=2; i<=n; i++){        // starting from 2 because we have already considered single digit numbers in total.
            total = total + availableOptions * (10-i+1);        // earlier uniques * available options (total + unique options at n-1 * unique options at n)
            availableOptions = availableOptions * (10-i+1);        // +1 because consider at i=2 we are looking for 2 digit numbers and hence available options at second place will be 9 (i.e. 10-i+1) (10-2+1)
        }
        return total;
    }
}
