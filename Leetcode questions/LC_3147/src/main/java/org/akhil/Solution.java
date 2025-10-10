package org.akhil;

public class Solution {
    // Solution 1 - Bruteforce
    // O(N^2)/O(1)
//    public int maximumEnergy(int[] energy, int k) {
//        int result = Integer.MIN_VALUE;
//
//        int start = 0;
//        while(start < energy.length) {
//            int sum = 0;
//            for (int i = start; i < energy.length; i = i + k) {
//                sum = sum + energy[i];
//            }
//            start++;
//            result = Math.max(result, sum);
//        }
//
//        return result;
//    }

    // --------------------
    // As in above code we are going from start to end, hence for every start point we need to check till end.
    // At any index there will be only 1 max value which we can calculate if we move from end to start.
    // Solution 2 - Using DP
    // O(N)/O(N)
    public int maximumEnergy(int[] energy, int k) {
        int result = Integer.MIN_VALUE;
        int n = energy.length;
        int[] dp = new int[n];

        for(int i=n-1; i>=0; i--){
            dp[i] = energy[i];
            if(i + k < n){          // meaning there is another element to the right of current index which can be added to this index
                dp[i] = dp[i] + dp[i+k];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
