package org.akhil;

import java.util.*;

public class Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        int ans = initial[0];
        int max = 0;

        boolean[] infected = new boolean[n];
        for(int u: initial){
            infected[u] = true;
        }

        DisjointSet ds = new DisjointSet(n);

        // find union i.e. components without considering (skipping) infected nodes
        for(int i = 0; i < n; i++) {
            if(!infected[i]) {
                for(int j = i + 1; j < n; j++) {
                    if(!infected[j] && graph[i][j] == 1){
                        ds.unionBySize(i, j);
                    }
                }
            }
        }

        int[] count = new int[n];
        Set<Integer>[] component = new Set[n];

        for(int i:initial) {
            component[i] = new HashSet<>();

            // considering i node is not infected and adding it in the graph.
            for(int node = 0; node < n; node++) {
                if(!infected[node] && graph[i][node] == 1) component[i].add(ds.findParent(node));
            }

            for(int v: component[i]){
                count[v]++;
            }
        }

        for(int u:initial) {
            int save = 0;
            for(int v: component[u]) {
                if(count[v] == 1) save += ds.size.get(v);
            }
            if(save > max || save == max && u < ans) {
                max = save;
                ans = u;
            }
        }
        return ans;
    }
}
