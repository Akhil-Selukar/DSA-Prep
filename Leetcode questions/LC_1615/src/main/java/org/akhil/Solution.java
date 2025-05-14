package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    //Solution 1 - O(N^2 + E)/O(N + E)      dominant factor in time complexity is O(N^2) hence we can say that time complexity is O(N^2) while space complexity is O(N)
//    public int maximalNetworkRank(int n, int[][] roads) {
//        int[] inDegree = new int[n];
//        Set<String> connections = new HashSet<>();
//
//        for(int[] road:roads){                      // O(E)
//            connections.add(road[0]+"-"+road[1]);
//            connections.add(road[1]+"-"+road[0]);
//            inDegree[road[0]]++;
//            inDegree[road[1]]++;
//        }
//
//        int maxRank = Integer.MIN_VALUE;
//
//        // O(N^2)
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//                if(i == j){
//                    continue;
//                }
//                int rank = inDegree[i] + inDegree[j] - (connections.contains(i+"-"+j) ? 1 : 0);
//
//                maxRank = Math.max(maxRank, rank);
//            }
//        }
//
//        return maxRank;
//    }


    // Solution 2 - Replaced set with int[][]
    // Time complexity - O(N^2 + E) even though the time complexity is same but this solution will be much faster as no hashing or string creation is involved.
    // Space complexity - O(N^2) because of 2D matrix of size N.

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] inDegree = new int[n];
        boolean[][] connected = new boolean[n][n];

        for(int[] road:roads){                      // O(E)
            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
            inDegree[road[0]]++;
            inDegree[road[1]]++;
        }

        int maxRank = Integer.MIN_VALUE;

        // O(N^2)
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j){
                    continue;
                }
                int rank = inDegree[i] + inDegree[j] - (connected[i][j] ? 1 : 0);

                maxRank = Math.max(maxRank, rank);
            }
        }

        return maxRank;
    }
}
