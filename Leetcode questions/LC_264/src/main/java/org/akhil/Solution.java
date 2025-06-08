package org.akhil;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    // Solution 1 - Using Priority queue
    // TC - O(NlogM)    where M is size os set
    // SC - O(M)    where M is size os set
//    public int nthUglyNumber(int n) {
//        if(n == 1){
//            return 1;
//        }
//
//        PriorityQueue<Long> pq = new PriorityQueue<>();
//        Set<Long> visited = new HashSet<>();
//        pq.offer(1L);
//        visited.add(1L);
//        n--;
//
//        while(n>0){
//            long currNo = pq.poll();
//
//            if(!visited.contains(currNo*2)){
//                pq.offer(currNo*2);
//                visited.add(currNo*2);
//            }
//            if(!visited.contains(currNo*3)){
//                pq.offer(currNo*3);
//                visited.add(currNo*3);
//            }
//            if(!visited.contains(currNo*5)){
//                pq.offer(currNo*5);
//                visited.add(currNo*5);
//            }
//            n--;
//        }
//        long ans = pq.poll();
//        return (int) ans;
//    }


    // Solution 1.1 - Using TreeSet
    // same time and space complexity
//    public int nthUglyNumber(int n) {
//        if(n == 1){
//            return 1;
//        }
//
//        TreeSet<Long> pq = new TreeSet<>();
//        pq.add(1L);
//        n--;
//
//        while(n>0){
//            long currNo = pq.pollFirst();
//
//            pq.add(currNo*2);
//            pq.add(currNo*3);
//            pq.add(currNo*5);
//
//            n--;
//        }
//        long ans = pq.pollFirst();
//        return (int) ans;
//    }

    //---------------
    // Solution 2 - 3 points (DP bottoms-up)
    // O(N)/O(1)

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1; // 1st Ugly number

        int i2 = 1;
        int i3 = 1;
        int i5 = 1;

        for (int i = 2; i <= n; i++) {
            int i2thUgly = dp[i2] * 2;
            int i3rdUgly = dp[i3] * 3;
            int i5thUgly = dp[i5] * 5;

            dp[i] = Math.min(Math.min(i2thUgly, i3rdUgly), i5thUgly);

            if (dp[i] == i2thUgly) {
                i2++;
            }

            if (dp[i] == i3rdUgly) {
                i3++;
            }

            if (dp[i] == i5thUgly) {
                i5++;
            }
        }

        return dp[n];
    }
}
