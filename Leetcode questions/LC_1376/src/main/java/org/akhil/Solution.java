package org.akhil;

public class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int totalTime = 0;
        int[] considered = new int[n];

        for(int i=0; i<n; i++){
            int mgr = manager[i];
            if(mgr == -1){
                continue;
            }
            if(considered[mgr] == 0){
                considered[mgr] = 1;
                totalTime += informTime[mgr];
            }
        }
        return totalTime;
    }
}
