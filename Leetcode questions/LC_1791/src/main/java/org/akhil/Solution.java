package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - O(N)/O(N)
//    public int findCenter(int[][] edges) {
//        Map<Integer, Integer> inDegree = new HashMap<>();
//
//        for(int[] edge:edges){
//            inDegree.put(edge[0], inDegree.getOrDefault(edge[0], 0)+1);
//            inDegree.put(edge[1], inDegree.getOrDefault(edge[1], 0)+1);
//        }
//
//        for(int node : inDegree.keySet()){
//            if(inDegree.get(node) == edges.length){
//                return node;
//            }
//        }
//
//        return -1;
//    }

    // --------------------
    // Solution 2 - O(1)/O(1)
    public int findCenter(int[][] edges) {
        int[] firstEdge = edges[0];
        int[] secondEdge = edges[1];

        return (firstEdge[0] == secondEdge[0] || firstEdge[0] == secondEdge[1])
                ? firstEdge[0]
                : firstEdge[1];
    }
}
