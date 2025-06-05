package org.akhil;

import java.util.Arrays;

public class DisjointSet {
    int[] parent = new int[26];

    public DisjointSet(){
        Arrays.fill(parent, -1);
    }

    public int findParent(int node){
        if(parent[node] == -1){
            return node;
        }
        int ultParent = findParent(parent[node]);
        parent[node] = ultParent;
        return ultParent;
    }

    public void union(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu == pv){
            return;
        }
        if(pu > pv){
            parent[pu] = pv;
        } else {
            parent[pv] = pu;
        }
    }
}
