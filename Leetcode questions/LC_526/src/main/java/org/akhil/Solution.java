package org.akhil;

// O(K) where K is number of valid/beautiful permutations
// This is because we are eliminating the entire branch in recursion tree as soon as we found first non-beautiful element.
public class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];

        helper(1, n, visited);

        return count;
    }

    private void helper(int position, int n, boolean[] visited) {
        if(position > n){
            count++;
            return;
        }

        for(int i=1; i<=n; i++){
            if(!visited[i] && (i % position == 0 || position % i == 0)){
                visited[i] = true;
                helper(position+1, n, visited);
                visited[i] = false;
            }
        }
    }
}
