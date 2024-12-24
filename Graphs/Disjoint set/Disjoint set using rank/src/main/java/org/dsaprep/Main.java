package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(8);

        ds.unionByRank(1,2);
        ds.unionByRank(1,3);
        ds.unionByRank(3,4);
        ds.unionByRank(0,5);
        ds.unionByRank(5,6);
        ds.unionByRank(5,7);

        int parentU = ds.findParent(6);
        int parentV = ds.findParent(4);
        if(parentU == parentV){
            System.out.println("In same component");
        }else{
            System.out.println("In Different component");
        }

        ds.unionByRank(0, 1);

        parentU = ds.findParent(6);
        parentV = ds.findParent(4);
        if(parentU == parentV){
            System.out.println("In same component");
        }else{
            System.out.println("In Different component");
        }
    }
}