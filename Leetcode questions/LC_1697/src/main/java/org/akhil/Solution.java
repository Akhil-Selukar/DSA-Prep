package org.akhil;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    // Solution 1 - O(E log(E) + Q log(Q))/O(N+E+Q)
//    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
//        // Sort the edges and queries based on distance (store original index of query as we need it during population of answer)
//
//        PriorityQueue<int[]> edgeQueue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
//        PriorityQueue<int[]> queryQueue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
//
//        for(int[] edge:edgeList){
//            edgeQueue.offer(edge);
//        }
//
//        for(int i=0; i<queries.length; i++){
//            queryQueue.offer(new int[]{queries[i][0], queries[i][1], queries[i][2], i});        // [u, v, dis, originalIndex];
//        }
//
//        DisjointSet ds= new DisjointSet(n);
//        boolean[] result = new boolean[queries.length];
//
//        while(!queryQueue.isEmpty()){
//            int[] query = queryQueue.poll();
//
//            int u = query[0];
//            int v = query[1];
//            int dist = query[2];
//            int index = query[3];
//
//            if(ds.findParent(u) == ds.findParent(v)){
//                result[index] = true;
//                continue;
//            }
//
//            while(!edgeQueue.isEmpty() && edgeQueue.peek()[2] < dist){
//                int[] polled = edgeQueue.poll();
//
//                int start = polled[0];
//                int end = polled[1];
//
//                ds.union(start, end);
//                if(ds.findParent(u) == ds.findParent(v)){
//                    result[index] = true;
//                }
//            }
//        }
//
//        return result;
//    }


    // Solution 2 - Same concept as that of above but without queue (use Arrays.sort())
    // Same complexities but little fast (still not enough)
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        // Sort the edges and queries based on distance (store original index of query as we need it during population of answer)

        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);

        int[][] queriesWithIndex = new int[queries.length][4];      // [u, v, dis, index];
        for(int i=0; i<queries.length; i++){
            queriesWithIndex[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }

        Arrays.sort(queriesWithIndex, (a, b) -> a[2]-b[2]);

        // use disjoint set
        DisjointSet ds= new DisjointSet(n);
        boolean[] result = new boolean[queries.length];

        int edgeIndex = 0;
        for(int i=0; i<queries.length; i++){
            int[] query = queriesWithIndex[i];

            int u = query[0];
            int v = query[1];
            int dist = query[2];
            int index = query[3];

            if(ds.findParent(u) == ds.findParent(v)){
                result[index] = true;
                continue;
            }
            while(edgeIndex<edgeList.length && edgeList[edgeIndex][2] < dist){
                int[] polled = edgeList[edgeIndex++];

                int start = polled[0];
                int end = polled[1];

                ds.union(start, end);
                if(ds.findParent(u) == ds.findParent(v)){
                    result[index] = true;
                }
            }
        }

        return result;
    }


    // Solution 3 - change Disjoint Set to use array in place of List.
    // same complexity but faster.
}
