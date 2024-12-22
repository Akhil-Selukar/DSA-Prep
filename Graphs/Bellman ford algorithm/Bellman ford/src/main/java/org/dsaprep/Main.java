package org.dsaprep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] edges = {{0,1,5}, {1,0,3}, {1,2,-1}, {2,0,1}};
        int source = 2;
        int noOfNodes = 3;

        BellmanFord bmf = new BellmanFord();
        System.out.println(Arrays.toString(bmf.bellmanFord(noOfNodes, edges, source)));
    }
}