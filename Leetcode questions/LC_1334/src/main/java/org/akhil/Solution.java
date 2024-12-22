package org.akhil;

import java.util.Arrays;

public class Solution {
    public int findTheCity(int noOfCities, int[][] edges, int distanceThreshold) {
        // create adj/dist matrix using edges details.
        int[][] dist = new int[noOfCities][noOfCities];
        for(int[] arr:dist){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for(int i=0; i<edges.length; i++){
            int startNode = edges[i][0];
            int endNode = edges[i][1];
            int edgeWeight = edges[i][2];

            // bidirectional graph
            dist[startNode][endNode] = edgeWeight;
            dist[endNode][startNode] = edgeWeight;
        }
        for(int i=0; i<noOfCities; i++){
            dist[i][i] = 0;
        }

        // Floyd warshall algorithm
        for(int k=0; k<noOfCities; k++){
            for(int i=0; i<noOfCities; i++){
                for(int j=0; j<noOfCities; j++){
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }

        int cityNumber = -1;
        int cityCount = noOfCities;
        for(int i=0; i<dist.length; i++){
            int count = 0;
            for(int j=0; j<dist.length; j++){
                if(dist[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=cityCount){
                cityCount = count;
                cityNumber = i;
            }
        }
        return cityNumber;
    }
}
