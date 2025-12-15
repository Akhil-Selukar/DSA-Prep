package org.akhil;

public class Solution {
    // O(N)/O(1)
    public long getDescentPeriods(int[] prices) {
        int result = 0;
        int count = 0;      // count of current continuous smooth descent period
        int previous = -1;

        for(int i=0; i<prices.length; i++){
            if(previous != -1 && previous - prices[i] == 1){
                count++;
            } else {
                count = 1;
            }
            previous = prices[i];
            result = result + count;
        }
        return result;
    }
}
