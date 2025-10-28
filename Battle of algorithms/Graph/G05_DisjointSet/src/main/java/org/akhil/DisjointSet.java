package org.akhil;

import java.util.ArrayList;
import java.util.List;

/*
    Implement Disjoint set

    1. Constructor to initialize the disjoint set
    2. findParent(int node) method to find parent of any vertex
    3. Union(int u, int v) method to perform union of two vertices
    4. getTotalComponents() will return total components in the graph
    5. isConnected(int u, int v) return true if u and v are part of same component, else false.

 */
public class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    int totalComponents;

    // constructor to initialize disjoint set
    public DisjointSet(int n){
        if (n <= 0) {
            throw new IllegalArgumentException("Number of elements must be positive.");
        }

        totalComponents = n;
        for(int i=0; i<n; i++){
            size.add(1);        // initial size for all vertices
            parent.add(i);      // initially each vertex is parent to itself
        }
    }

    // findParent method to get parent of any vertex
    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int ultParent = findParent(parent.get(node));
        parent.set(node, ultParent);        // path compression
        return ultParent;
    }

    // method for union by size
    public boolean union(int u, int v){
        int ultParentU = findParent(u);
        int ultParentV = findParent(v);

        // already in same component so no union is performed
        if(ultParentU == ultParentV){
            return false;
        }

        if(size.get(ultParentU) < size.get(ultParentV)){
            parent.set(ultParentU, ultParentV);
            size.set(ultParentV, size.get(ultParentV) + size.get(ultParentU));
        } else {
            parent.set(ultParentV, ultParentU);
            size.set(ultParentU, size.get(ultParentV) + size.get(ultParentU));
        }
        totalComponents--;  // every time two vertices unite a component is reduced.
        return true;
    }

    public int getTotalComponents(){
        return totalComponents;
    }

    public boolean isConnected(int u, int v){
        return findParent(u) == findParent(v);
    }
}
