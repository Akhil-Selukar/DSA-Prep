package org.akhil;

public class DisjointSet {
    int[] parents;
    int[] size;

    public DisjointSet(int n){
        parents = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parents[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int node){
        if(node == parents[node]){
            return node;
        }

        int ultParent = findParent(parents[node]);
        parents[node] = ultParent;
        return ultParent;
    }

    public void union(int u, int v){
        int ultParentOfU = findParent(u);
        int ultParentOfV = findParent(v);

        if(ultParentOfU == ultParentOfV){
            return;
        }

        if(size[ultParentOfU] > size[ultParentOfV]){
            parents[ultParentOfV] = ultParentOfU;
            size[ultParentOfU] = size[ultParentOfU] + size[ultParentOfV];
        } else {
            parents[ultParentOfU] = ultParentOfV;
            size[ultParentOfV] = size[ultParentOfU]+size[ultParentOfV];
        }
    }
}
