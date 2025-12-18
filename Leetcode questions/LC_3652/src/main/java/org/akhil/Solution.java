package org.akhil;

public class Solution {
    // O(N)/O(N)
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long[] strategySum = new long[n+1];
        long[] allSellSum = new long[n+1];

        strategySum[0] = 0;
        allSellSum[0] = 0;
        for(int i=0; i<n; i++){
            strategySum[i+1] = strategySum[i] + ((long) prices[i] *strategy[i]);
            allSellSum[i+1] = allSellSum[i] + prices[i];
        }

        long maxProfit = strategySum[n];
        int end = k;

        while(end<=n){
            int start = end-k;
            long firstHalfProfit = strategySum[start] - strategySum[0];
            int convertedStart = start + (k/2);
            long midPortionProfit = allSellSum[end] - allSellSum[convertedStart];
            long lastHalfProfit = strategySum[n] - strategySum[end];

            maxProfit = Math.max(maxProfit, firstHalfProfit+midPortionProfit+lastHalfProfit);
            end++;
        }

        return maxProfit;
    }
}
