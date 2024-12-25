package org.akhil;

import java.util.ArrayList;

public class DisjointSet {
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0; i<n; i++){
            size.add(0);
            parent.add(i);
        }
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

        if(ultimateParentU == ultimateParentV){
            return;
        }

        if(ultimateParentV < ultimateParentU){
            parent.set(ultimateParentV, ultimateParentU);
            size.set(ultimateParentU, size.get(ultimateParentU)+size.get(ultimateParentV));
        } else {
            parent.set(ultimateParentU, ultimateParentV);
            size.set(ultimateParentV, size.get(ultimateParentU)+size.get(ultimateParentV));
        }
    }
}
