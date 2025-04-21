package org.akhil;

import java.util.ArrayList;
import java.util.List;

// Here in this example as we are not using size so we can remove size from DS. (check solution on leetcode for this)
// this will not change the time and space complexity but for sure reduce the computation time and space required.
public class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0; i<n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int ultiParent = findParent(parent.get(node));
        parent.set(node, ultiParent);
        return ultiParent;
    }

    public boolean unionBySize(int u, int v){
        int ultiParentU = findParent(u);
        int ultiParentV = findParent(v);

        if(ultiParentU == ultiParentV){
            return false;
        }

        if(size.get(ultiParentU) < size.get(ultiParentV)){
            parent.set(ultiParentU, ultiParentV);
            size.set(ultiParentV, size.get(ultiParentV) + size.get(ultiParentU));
            return true;
        } else {
            parent.set(ultiParentV, ultiParentU);
            size.set(ultiParentU, size.get(ultiParentU) + size.get(ultiParentV));
            return true;
        }
    }
}
