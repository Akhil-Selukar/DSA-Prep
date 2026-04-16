package org.akhil;

import java.util.*;

public class Solution {
//    // Bruteforce
//    // O(M*N)/O(M+N)
//    // TLE
//    public List<Integer> solveQueries(int[] nums, int[] queries) {
//        Map<Integer, List<Integer>> indices = new HashMap<>();
//        int n = nums.length;
//
//        for(int i=0; i<nums.length; i++){
//            int num = nums[i];
//            if(!indices.containsKey(num)){
//                indices.put(num, new ArrayList<>());
//            }
//            indices.get(num).add(i);
//        }
//
//        List<Integer> result = new ArrayList<>();
//        for(int i=0; i<queries.length; i++){
//            int qIndex = queries[i];
//            int start = nums[qIndex];
//            int minDist = Integer.MAX_VALUE;
//            for(int index:indices.get(start)){
//                if(queries[i] != index) {
//                    int currentMin = Math.min(Math.abs(qIndex - index), n - (Math.abs(qIndex - index)));
//                    minDist = Math.min(minDist, currentMin);
//                }
//            }
//            result.add(minDist == Integer.MAX_VALUE ? -1 : minDist);
//        }
//        return result;
//    }


    // ----------------------
    // Optimized using precomputed distance
    // O(M+N)/O(M)
    // TLE
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> indices = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!indices.containsKey(num)) {
                indices.put(num, new ArrayList<>());
            }
            indices.get(num).add(i);
        }

        int[] precomputedDist = new int[n];
        Arrays.fill(precomputedDist, -1);

        for (List<Integer> list : indices.values()) {
            int len = list.size();

            if (len == 1) {
                continue;
            }

            for (int i = 0; i < len; i++) {
                int curr = list.get(i);
                int prev = list.get((i - 1 + len) % len); // i-1
                int next = list.get((i + 1) % len); //i+1

                int dist1 = Math.abs(curr - prev); // n-dist1
                int dist2 = Math.abs(curr - next); // n-dist2

                precomputedDist[curr] = Math.min(Math.min(Math.min(dist1, dist2), n - dist1), n - dist2);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            result.add(precomputedDist[q]);
        }
        return result;
    }
}
