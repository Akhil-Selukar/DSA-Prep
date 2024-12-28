package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    int noOfComponents = 0;

    public DisjointSet(int n){
        for(int i=0; i<n; i++){
            size.add(0);
            parent.add(i);
        }
        noOfComponents = n; // initially all nodes will be parented to itself hence N components.
    }

    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int ultimateParentU = findParent(u);
        int ultimateParentV = findParent(v);

        if(ultimateParentV == ultimateParentU){
            return;
        }

        if(ultimateParentV < ultimateParentU){
            parent.set(ultimateParentV, ultimateParentU);
            size.set(ultimateParentU, size.get(ultimateParentV)+size.get(ultimateParentU));
        } else {
            parent.set(ultimateParentU, ultimateParentV);
            size.set(ultimateParentV, size.get(ultimateParentV)+size.get(ultimateParentU));
        }
        noOfComponents--;
    }

    public int getNumberOfComponents(){
        return this.noOfComponents;
    }
}
