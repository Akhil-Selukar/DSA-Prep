package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Solution 1 - Binary Search on result and disjoint set
    //T.C : O(Nlog(maxStability - minStability))
    //S.C : O(N+E)
    // where N -> number of nodes and E -> number of edges
    public int maxStability(int n, int[][] edges, int k) {
        DisjointSet ds = new DisjointSet(n);

        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            int must = edge[3];

            if(must == 1){      // the edge has to be in MST and we can not change the weight for this edge
                if(ds.findParent(u) == ds.findParent(v)){        // if taking the edge is mandatory but the nodes of that edge are already in connected
                    return -1;
                }
                ds.union(u, v);
            }
        }

        // As we want to find Maximum of all minimum hence we can apply binary search on answer
        int result = -1;
        int start = 1;
        int end = (int)2e5;     // twice the max range because we can multiply the weight by 2 making is 2e5.

        while(start <= end){
            int mid = start + (end-start)/2;

            if(checkStability(n, edges, k, mid)){
                result = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return result;
    }

    private boolean checkStability(int n, int[][] edges, int k, int mid){
        DisjointSet ds = new DisjointSet(n);

        List<int[]> canUpdate = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            int must = edge[3];


            if (must == 1) {
                if (weight < mid) { // weight is less than mid that means this mid can not be the answer
                    return false;
                } else {
                    ds.union(u, v);
                }
            } else {
                if (weight >= mid) {
                    ds.union(u, v);
                } else if (2 * weight >= mid) {     // after doubling the weight it is valid then this can be a potential update
                    canUpdate.add(new int[]{u, v});
                }
            }
        }

        // try updates
        for(int[] updateEdge:canUpdate){
            int u = updateEdge[0];
            int v = updateEdge[1];

            if(ds.findParent(u) != ds.findParent(v)) {      // nodes are not connected
                if (k <= 0) {       // and updates are not allowed
                    return false;
                } else {
                    ds.union(u, v);
                    k--;        // used one update
                }
            }
        }

        if(ds.getNoOfComponents() > 1){     // not a MST
            return false;
        }
        return true;
    }
}

class DisjointSet {
    private List<Integer> parent = new ArrayList<>();
    private List<Integer> size = new ArrayList<>();
    int noOfComponents;

    public DisjointSet(int n){
        if (n <= 0) {
            throw new IllegalArgumentException("Number of elements must be positive.");
        }

        for(int i=0; i<n; i++){
            size.add(1);        // initial size for all vertices
            parent.add(i);      // initially each vertex is parent to itself
        }

        noOfComponents = n;
    }

    // findParent method to get parent of any vertex
    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int uParent = findParent(parent.get(node));
        parent.set(node, uParent);
        return uParent;
    }

    public boolean union(int u, int v){
        int uParentU = findParent(u);
        int uParentV = findParent(v);

        if(uParentU == uParentV){
            return false;
        }

        if(size.get(uParentU) < size.get(uParentV)){
            parent.set(uParentU, uParentV);
            size.set(uParentV, size.get(uParentU) + uParentV);
        } else {
            parent.set(uParentV, uParentU);
            size.set(uParentU, size.get(uParentU) + uParentV);
        }
        noOfComponents--;
        return true;
    }

    public int getNoOfComponents(){
        return noOfComponents;
    }
}
