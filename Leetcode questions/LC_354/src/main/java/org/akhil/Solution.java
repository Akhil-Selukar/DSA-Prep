package org.akhil;

import java.util.Arrays;

public class Solution {

//    // Solution - Using concept of LIS (TLE)
//    // O(N^2)/O(N)
//    public int maxEnvelopes(int[][] envelopes) {
//        int result = 1;     // by default single envelope can be considered as a russian dall envelope.
//
//        // sort the envelopes (you can sort based on anything height or width)
//        Arrays.sort(envelopes, (a,b) -> a[0]-b[0]);
//
//        // at each index we will store how many envelopes we can enclose in it
//        int[] dp = new int[envelopes.length];
//        Arrays.fill(dp, 1);             // even if no other envelope can be encased but the envelope itself will be counted as 1 envelope
//
//        for(int i=1; i<envelopes.length; i++){
//            int width1 = envelopes[i][0];
//            int height1 = envelopes[i][1];
//
//            for(int j=0; j<i; j++){
//                int width2 = envelopes[j][0];
//                int height2 = envelopes[j][1];
//
//                if(width2 < width1 && height2 < height1){
//                    dp[i] = Math.max(dp[i], dp[j]+1);
//                    result = Math.max(result, dp[i]);
//                }
//            }
//        }
//        return result;
//    }


    // -----------------

    // Solution - same concept as that of above just a little change to reduce the complexity
    // instead sorting in ascending order using both width and height we are sorting in ascending order by width and descending order by height
    // O(NlogN)/O(N)
    public int maxEnvelopes(int[][] envelopes) {
        int result = 0;

        // sort the envelopes (you can sort based on anything height or width)
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]){
                return b[1]-a[1];
            } else {
                return a[0]-b[0];
            }
        });

        // at each index we will store how many envelopes we can enclose in it
        int[] dp = new int[envelopes.length];

        for(int[] envelope:envelopes){
            int height1 = envelope[1];

            int index = Arrays.binarySearch(dp, 0, result, height1);
            if (index < 0) {
                index = -index - 1;         // for not found, binarySearch returns -(possible index)-1;
            }
            if (result == index) {
                result += 1;
            }

            dp[index] = height1;
        }
        return result;
    }
}
