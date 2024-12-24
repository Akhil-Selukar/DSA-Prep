package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(8);

        ds.unionBySize(1,2);
        ds.unionBySize(1,3);
        ds.unionBySize(3,4);
        ds.unionBySize(0,5);
        ds.unionBySize(5,6);
        ds.unionBySize(5,7);

        int parentU = ds.findParent(6);
        int parentV = ds.findParent(4);

        if(parentU == parentV){
            System.out.println("From same component of the graph..!!");
        } else {
            System.out.println("From different component of the graph..!!");
        }

        ds.unionBySize(0,1);

        parentU = ds.findParent(6);
        parentV = ds.findParent(4);

        if(parentU == parentV){
            System.out.println("From same component of the graph..!!");
        } else {
            System.out.println("From different component of the graph..!!");
        }
    }
}