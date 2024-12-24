package org.dsaprep;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0; i<n; i++){
            rank.add(0);
            parent.add(i);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node)){     // parent of node is that node itself
            return node;
        }

        int ultParent = findParent(parent.get(node));
        parent.set(node, ultParent);    // path compression
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int uParentU = findParent(u);
        int uParentV = findParent(v);

        if(uParentU == uParentV) return;

        if(rank.get(uParentU) < rank.get(uParentV)){
            parent.set(uParentU, uParentV);
        } else if(rank.get(uParentV) < rank.get(uParentU)){
            parent.set(uParentV, uParentU);
        } else {
            parent.set(uParentV, uParentU);
            int rankOfU = rank.get(uParentU);
            rank.set(uParentU, rankOfU+1);
        }
    }
}
