package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> parent;
    List<Integer> size;
    int components;

    public DisjointSet(int n){
        parent = new ArrayList<>(n+1);
        size = new ArrayList<>(n+1);
        components = n;
        for(int i=0; i<=n; i++){
            parent.add(i);
            size.add(1);
        }

        // It's better to only consider nodes 1 to n initially
        parent.set(0, 0); // Keep index 0 as is or avoid using it
        size.set(0, 0);
    }

    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int ultParent = findParent(parent.get(node));
        parent.set(node, ultParent);
        return ultParent;
    }

    public boolean unionBySize(int u, int v){
        int ultParentU = findParent(u);
        int ultParentV = findParent(v);

        if(ultParentV == ultParentU){
            return false;
        }

        if(size.get(ultParentV) > size.get(ultParentU)){
            parent.set(ultParentU, ultParentV);
            size.set(ultParentV, size.get(ultParentU)+size.get(ultParentV));
        } else {
            parent.set(ultParentV, ultParentU);
            size.set(ultParentU, size.get(ultParentU)+size.get(ultParentV));
        }
        components--;
        return true;
    }

    public boolean isConnected(){
        return components == 1;
    }
}
