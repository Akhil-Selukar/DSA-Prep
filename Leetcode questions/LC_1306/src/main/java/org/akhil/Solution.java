package org.akhil;

public class Solution {
    // Solution 1 - bruteforce using visited array to prevent from infinite loop
    // O(N)/O(N)
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];

        return helper(arr, visited, start);
    }

    private boolean helper(int[] arr, boolean[] visited, int currIndex){
        if(arr[currIndex] == 0){
            return true;
        }
        visited[currIndex] = true;

        // forward jump
        int newIndex = currIndex + arr[currIndex];
        if(newIndex >= 0 && newIndex < arr.length && !visited[newIndex]){
            if(helper(arr, visited, newIndex)){
                return true;
            }
        }

        // backward jump
        newIndex = currIndex - arr[currIndex];
        if(newIndex >= 0 && newIndex < arr.length && !visited[newIndex]){
            if(helper(arr, visited, newIndex)){
                return true;
            }
        }

        return false;
    }
}
