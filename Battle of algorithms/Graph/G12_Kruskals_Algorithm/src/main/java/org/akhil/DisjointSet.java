package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    int totalComponents;

    public DisjointSet(int n){
        if (n <= 0) {
            throw new IllegalArgumentException("Number of elements must be positive.");
        }

        totalComponents = n;
        for(int i=0; i<n; i++){
            size.add(1);
            parent.add(i);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return ultimateParent;
    }

    public boolean union(int u, int v){
        int uParent = findParent(u);
        int vParent = findParent(v);

        if(uParent == vParent){
            return false;
        }

        if(size.get(uParent) < size.get(vParent)){
            parent.set(uParent, vParent);
            size.set(vParent, size.get(uParent) + size.get(vParent));
        } else {
            parent.set(vParent, uParent);
            size.set(uParent, size.get(uParent) + size.get(vParent));
        }
        totalComponents--;
        return true;
    }

    public int getTotalComponents(){
        return totalComponents;
    }

    public boolean isConnected(int u, int v){
        return findParent(u) == findParent(v);
    }

}
