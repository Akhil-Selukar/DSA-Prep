package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // O(V*4^V)/O(V+E)
    public int[] gardenNoAdj(int n, int[][] paths) {
        if(n == 1){
            return new int[]{1};
        }

        // create adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] path:paths){
            adj.get(path[0]).add(path[1]);
            adj.get(path[1]).add(path[0]);
        }

        int[] result = new int[n+1];        // +1 because graph starts from 1;
        // check for node 1
        solve(adj, 1, result, n);

        // result is 0 indexed so eliminate 0th index
        return Arrays.copyOfRange(result, 1, result.length);        // here from start itself we can do index shifting in that case we will not have to do copyOfRange.
    }

    private boolean solve(List<List<Integer>> adj, int node, int[] result, int n){
        if(node > n){
            return true;
        }

        for(int flower = 1; flower <= 4; flower++){
            if(allowed(adj, node, flower, result)) {
                result[node] = flower;
                if(solve(adj, node+1, result, n)){
                    return true;
                }
                result[node] = 0;
            }
        }
        return false;
    }

    private boolean allowed(List<List<Integer>> adj, int node, int flower, int[] result) {
        for(int neighbour:adj.get(node)){
            if(result[neighbour] == flower){
                return false;
            }
        }
        return true;
    }
}
