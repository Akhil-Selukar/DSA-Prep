package org.dsaprep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int noOfNodes = 5;
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0; i<noOfNodes; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new int[]{2,0,1});
        adj.get(0).add(new int[]{1,0,2});
        adj.get(1).add(new int[]{1,1,2});
        adj.get(2).add(new int[]{2,2,4});
        adj.get(0).add(new int[]{2,2,3});
        adj.get(0).add(new int[]{1,3,4});

        // Kruskal's algorithm
        List<Edge> edges = new ArrayList<>();

        for(int i=0; i<noOfNodes; i++){
            for(int[] temp:adj.get(i)){
                int weight = temp[0];
                int source = temp[1];
                int destination = temp[2];

                edges.add(new Edge(weight, source, destination));
            }
        }

        Collections.sort(edges);

        DisjointSet ds = new DisjointSet(noOfNodes);
        int mstWeight = 0;
        List<int[]> mst = new ArrayList<>();

        for(int i=0; i<edges.size(); i++){
            int weight = edges.get(i).getWeight();
            int u = edges.get(i).getSource();
            int v = edges.get(i).getDestination();

            if(ds.findParent(u) != ds.findParent(v)){
                ds.unionBySize(u, v);
                mstWeight += weight;
                mst.add(new int[]{u, v});
            }
        }

        System.out.println("MST : "+mst);
        System.out.println("MST Weight : "+mstWeight);
    }
}