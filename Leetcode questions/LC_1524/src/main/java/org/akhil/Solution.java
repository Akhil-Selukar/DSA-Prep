package org.akhil;

public class Solution {
    // Here the most important thing to note is `OddSum + EvenSum = will always give OddSum` and `EvenSum + OddSum = will always give you oddSum`
    // O(N)/O(N)
//    public int numOfSubarrays(int[] arr) {
//        int n = arr.length;
//        final int MOD = (int)(1e9+7);
//        int[] prefixSum = new int[n];
//        prefixSum[0] = arr[0];
//
//        for(int i=1; i<n; i++){
//            prefixSum[i] = prefixSum[i-1] + arr[i];
//        }
//
//        int result = 0;
//        int oddSums = 0;
//        int evenSums = 1;   // initially without considering any element the prefixSum is 0 which is even;
//
//        for(int i=0; i<n; i++){
//            if(prefixSum[i] % 2 == 0){
//                result = (result + oddSums) % MOD;
//                evenSums++;
//            } else {
//                result = (result + evenSums) % MOD;
//                oddSums++;
//            }
//        }
//
//        return result;
//    }


    // ----------------------
    // Same concept with running prefix sum so O(1) space complexity
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        final int MOD = (int)(1e9+7);

        int prefixSum = 0;
        int result = 0;
        int oddSums = 0;
        int evenSums = 1;   // initially without considering any element the prefixSum is 0 which is even;

        for(int i=0; i<n; i++){
            prefixSum = prefixSum + arr[i];

            if(prefixSum % 2 == 0){
                result = (result + oddSums) % MOD;
                evenSums++;
            } else {
                result = (result + evenSums) % MOD;
                oddSums++;
            }
        }

        return result;
    }
}
