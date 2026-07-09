package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Solution 1 - using disjoint set
    // Here what we are asked is to find out two nodes given in queries array are connected or not.
    // We can find this easily by using disjoint set, if both the nodes have sameparent then they are connected.
    // So what we need basically is to create a disjoint set and connect all nodes and then check the queries
//    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
//        DisjointSet ds = new DisjointSet(n);
//
//        for(int i=1; i<n; i++){
//            if(Math.abs(nums[i] - nums[i-1]) <= maxDiff){
//                ds.union(i, i-1);
//            }
//        }
//
//        boolean[] result = new boolean[queries.length];
//
//        for(int i=0; i<queries.length; i++){
//            if(ds.findParent(queries[i][0]) == ds.findParent(queries[i][1])){
//                result[i] = true;
//            }
//        }
//        return result;
//    }
//
//    class DisjointSet{
//        List<Integer> parent = new ArrayList<>();
//        List<Integer> size = new ArrayList<>();
//
//        public DisjointSet(int n){
//            for(int i=0; i<n; i++){
//                parent.add(i);
//                size.add(0);
//            }
//        }
//
//        public int findParent(int node){
//            if(node == parent.get(node)){
//                return node;
//            }
//            int uParent = findParent(parent.get(node));
//            parent.set(node, uParent);
//            return uParent;
//        }
//
//        public void union(int u, int v){
//            int uParentU = findParent(u);
//            int uParentV = findParent(v);
//
//            if(uParentU == uParentV){
//                return;
//            }
//
//            if(size.get(uParentU) < size.get(uParentV)){
//                parent.set(uParentU, uParentV);
//                size.set(uParentU, size.get(uParentU) + size.get(uParentV));
//            } else {
//                parent.set(uParentV, uParentU);
//                size.set(uParentV, size.get(uParentU) + size.get(uParentV));
//            }
//        }
//    }


    // ------------------------
    // Solution 2 - Without disjoint set but similar concept
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] groupNo = new int[n];

        for(int i=1; i<n; i++){
            if(Math.abs(nums[i]-nums[i-1]) <= maxDiff){
                groupNo[i] = groupNo[i-1];
            } else {
                groupNo[i] = i;
            }
        }

        boolean[] result = new boolean[queries.length];
        for(int i=0; i<queries.length; i++){
            if(groupNo[queries[i][0]] == groupNo[queries[i][1]]){
                result[i] = true;
            }
        }

        return result;
    }
}
