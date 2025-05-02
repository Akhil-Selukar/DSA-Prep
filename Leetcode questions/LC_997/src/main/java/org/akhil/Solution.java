package org.akhil;

public class Solution {

    // O(V+E)/O(V)
    public int findJudge(int n, int[][] trust) {
        int[] degree = new int[n+1];        // +1 because our graph is 1 indexed

        for(int[] people:trust){
            degree[people[0]]--;
            degree[people[1]]++;
        }

        for(int i=1; i<=n; i++){
            if(degree[i] == (n-1)){
                return i;
            }
        }
        return -1;
    }
}
