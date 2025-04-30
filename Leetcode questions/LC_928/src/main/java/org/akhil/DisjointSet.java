package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int ultParent = findParent(parent.get(node));
        parent.set(node, ultParent);
        return ultParent;
    }

    public void unionBySize(int u, int v){
        int ultParentU = findParent(u);
        int ultParentV = findParent(v);

        if(ultParentV == ultParentU){
            return;
        }

        if(ultParentU > ultParentV){
            parent.set(ultParentV, ultParentU);
            size.set(ultParentU, size.get(ultParentV) + size.get(ultParentU));
        } else {
            parent.set(ultParentU, ultParentV);
            size.set(ultParentV, size.get(ultParentV) + size.get(ultParentU));
        }
    }
}
