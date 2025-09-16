package org.dsaprep;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0; i<n; i++){
            size.add(1);
            parent.add(i);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int ultParent = findParent(parent.get(node));
        parent.set(node, ultParent);
        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int ultParentU = findParent(u);
        int ultParentV = findParent(v);

        if(ultParentU == ultParentV){
            return;
        }

        if(size.get(ultParentV) < size.get(ultParentU)){
            parent.set(ultParentV, ultParentU);
            size.set(ultParentU, size.get(ultParentU)+size.get(ultParentV));
        }else {
            parent.set(ultParentU, ultParentV);
            size.set(ultParentV, size.get(ultParentV)+size.get(ultParentU));
        }
    }
}
