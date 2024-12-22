package org.dsaprep;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    // here we are asked only the tree weight hence in pair we can exclude parent.
    private class Pair{
        private int weight;
        private int node;
        private int parent;

        public Pair(int weight, int node, int parent){
            this.weight = weight;
            this.node = node;
            this.parent = parent;
        }
    }

    public int spanningTree(int noOfNodes, int noOfEdges, List<List<int[]>> adj) {
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((x, y) -> x.weight-y.weight);

        boolean[] visited = new boolean[noOfNodes];
        queue.offer(new Pair(0,0, -1));
        int sum = 0;
        List<int[]> mst = new ArrayList<>();

        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            int weight = temp.weight;
            int node = temp.node;
            int parent = temp.parent;

            if(visited[node]){
                continue;
            }

            visited[node] = true;
            sum = sum+weight;
            if(parent >=0){
                mst.add(new int[]{parent, node});
            }

            for(int i=0; i<adj.get(node).size(); i++){
                int adjNode = adj.get(node).get(i)[1];
                int adjWeight = adj.get(node).get(i)[2];

                if(!visited[adjNode]){
                    queue.offer(new Pair(adjWeight, adjNode, node));
                }
            }
        }
        for(int[] temp:mst){
            System.out.println(Arrays.toString(temp));
        }
        return sum;
    }
}
