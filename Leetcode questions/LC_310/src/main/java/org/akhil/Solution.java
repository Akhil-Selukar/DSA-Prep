package org.akhil;

import java.util.*;

public class Solution {

    // O(V+E)/O(V+E) where V is number fo vertices and E is number of edges
    // In this case as there is no cycle and graph is in the form of Tree hence E will always be (V-1) i.e. (N-1) or less than V
    // Hence we can say that time and space complexity as O(V)/O(V) (i.e. O(N)/O(N) where N is number of vertices)
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(0);
            return ans;
        }

        // build adj and in-degree
        int[] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            int source = edge[0];
            int destination = edge[1];

            adj.get(source).add(destination);
            adj.get(destination).add(source);       // bidirectional graph

            indegree[destination]++;
            indegree[source]++;         // bidirectional graph
        }

        // eliminate all the leaf nodes till we remain with only 2 or 1 node (why 2 or 1 because that is the base case.
        // in case of 2 nodes the only possible/minimum height will be 1 and both the nodes will be root node and in case
        // of 1 node well that only cen be the root

        // identify the leaf
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 1){
                queue.offer(i);
            }
        }

        // remove the leaf
        while(n > 2){
            int totalLeaf = queue.size();
            n = n-totalLeaf;             // remaining nodes after removing leafs

            for(int i=0; i<totalLeaf; i++){
                int leafToRemove = queue.poll();
                for(int neighbour : adj.get(leafToRemove)){
                    indegree[neighbour]--;
                    if(indegree[neighbour] == 1){
                        queue.offer(neighbour);         // if found new neighbour add it in queue.
                    }
                }
            }
        }

        ans.addAll(queue);
        return ans;
    }
}
