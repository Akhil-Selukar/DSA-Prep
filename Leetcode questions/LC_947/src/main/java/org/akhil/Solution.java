package org.akhil;

public class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        DisjointSet ds = new DisjointSet(n);

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    ds.unionBySize(i,j);
                }
            }
        }
        return n- ds.getNumberOfComponents();
    }
}
