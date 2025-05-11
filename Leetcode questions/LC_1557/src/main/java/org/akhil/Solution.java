package org.akhil;

import java.util.*;

public class Solution {

    // Solution - 1 using BFS ((O(N+E)/O(N+E))
//    Set<Integer> ans = new HashSet<>();
//    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
//        List<List<Integer>> adj = new ArrayList<>();
//        for(int i=0; i<n; i++){
//            adj.add(new ArrayList<>());
//        }
//
//        for(List<Integer> edge:edges){
//            int u = edge.get(0);
//            int v = edge.get(1);
//
//            adj.get(u).add(v);
//        }
//
//        boolean[] visited = new boolean[n];
//
//        for(int i=0; i<n; i++){
//            if(!visited[i]){
//                ans.add(i);
//                bfs(i, adj, visited);
//            }
//        }
//
//        return new ArrayList<>(ans);
//    }
//
//    private void bfs(int i, List<List<Integer>> adj, boolean[] visited) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(i);
//
//        while(!queue.isEmpty()){
//            int polled = queue.poll();
//            visited[polled] = true;
//            for(int adjNode:adj.get(polled)){
//                if(!visited[adjNode]){
//                    queue.offer(adjNode);
//                }
//                ans.remove(adjNode);
//            }
//        }
//    }


    // Solution 2 - Without BFS (O(V+E)/O(N)
    // Here simple observation is if any node does not have any indegree then that node will not be visited in any path so we will have to start
    // from that node, hence that node will be the part of our answer.
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        boolean[] hasInDeg = new boolean[n];

        for(List<Integer> edge: edges)
        {
            hasInDeg[edge.get(1)]=true;
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++) if(hasInDeg[i]==false) res.add(i);
        return res;
    }
}
