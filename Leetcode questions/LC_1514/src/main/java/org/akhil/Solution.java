package org.akhil;

import java.util.*;

public class Solution {


    // Solution 1 - using Dijkstra's algorithm (TLE)
    // Time complexity : O(N + E + E log N), which simplifies to O(E log N) in the typical case where E >= N.
    // Space complexity : O(N + E)
//    class Pair{
//        int node;
//        double probability;
//
//        public Pair(int node, double probability){
//            this.node = node;
//            this.probability = probability;
//        }
//    }
//    public double maxProbability(int n, int[][] edges, double[] prob, int start, int end) {
//        List<List<Pair>> adj = new ArrayList<>();
//
//        for(int i=0; i<n; i++){             // O(N)
//            adj.add(new ArrayList<>());
//        }
//
//        for(int i=0; i<prob.length; i++){           // O(E)
//            int[] edge = edges[i];
//            double probability = prob[i];
//
//            adj.get(edge[0]).add(new Pair(edge[1], probability));
//            adj.get(edge[1]).add(new Pair(edge[0], probability));
//        }
//
//        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b)->{
//            if(a.probability == b.probability){
//                return a.node - b.node;
//            } else {
//                double diff = a.probability - b.probability;
//                if(diff < 0){
//                    return -1;
//                }
//                else {
//                    return 1;
//                }
//            }
//        });
//
//        double[] probability = new double[n];           // O(N)
//        Arrays.fill(probability, -9000000.0);
//
//        queue.offer(new Pair(start, 0));        // O(logN)
//        probability[start] = 1;
//
//        while(!queue.isEmpty()){             // O(N)
//            Pair polled = queue.poll();         // O(logN)
//            int currNode = polled.node;
//            double currProb = polled.probability;
//
//            for(Pair neigh:adj.get(currNode)){
//                int adjNode = neigh.node;
//                double adjProb = neigh.probability;
//
//                double newProb = (currProb == 0.0) ? adjProb : currProb * adjProb;
//
//                if(probability[adjNode] < newProb){
//                    probability[adjNode] = newProb;
//                    queue.offer(new Pair(adjNode, newProb));
//                }
//            }
//        }
//
//        return (probability[end] < 0) ? 0.0 : probability[end];
//    }


    // Solution 2 - Same approach, just a very small change at implementation of priority queue (we are trying to be greedy here and as we need max probability hence we are fetching max first)
    // O(E logN)
    // O(N + E)
    class Pair{
        int node;
        double probability;

        public Pair(int node, double probability){
            this.node = node;
            this.probability = probability;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] prob, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){             // O(N)
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<prob.length; i++){           // O(E)
            int[] edge = edges[i];
            double probability = prob[i];

            adj.get(edge[0]).add(new Pair(edge[1], probability));
            adj.get(edge[1]).add(new Pair(edge[0], probability));
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b)->{
            if(a.probability == b.probability){
                return b.node - a.node;
            } else {
                double diff = b.probability - a.probability;
                if(diff < 0){
                    return -1;
                }
                else {
                    return 1;
                }
            }
        });

        double[] probability = new double[n];           // O(N)
        Arrays.fill(probability, -90000.0);

        queue.offer(new Pair(start, 0));        // O(logN)
        probability[start] = 1;

        while(!queue.isEmpty()){             // O(N)
            Pair polled = queue.poll();         // O(logN)
            int currNode = polled.node;
            double currProb = polled.probability;

            for(Pair neigh:adj.get(currNode)){
                int adjNode = neigh.node;
                double adjProb = neigh.probability;

                double newProb = (currProb == 0.0) ? adjProb : currProb * adjProb;

                if(probability[adjNode] < newProb){
                    probability[adjNode] = newProb;
                    queue.offer(new Pair(adjNode, newProb));
                }
            }
        }

        return (probability[end] < 0) ? 0.0 : probability[end];
    }
}
