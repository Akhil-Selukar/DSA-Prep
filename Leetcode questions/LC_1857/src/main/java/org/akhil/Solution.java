package org.akhil;

import java.util.ArrayList;
import java.util.List;


// time complexity - O(V+E)*26  i.e. ~O(V+E)
// space complexity - O(V+E) + O(V * 26) + O(V)     ->    O(V+E) for adjacency list, O(V*26) for dp,  O(V) for recursive call stack.

// overall we can say that both space and time complexity is O(V+E)
public class Solution {

    int result = Integer.MIN_VALUE;
    public int largestPathValue(String colors, int[][] edges) {

        int n = colors.length();

        // create the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){                     // O(V)
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges){                      // O(E)
            adj.get(edge[0]).add(edge[1]);
        }

        // 2D array to store color count till that vertex [vertex][color];
        int[][] dp = new int[n][26];        // n -> vertices and 26 because as colors are represented by lowercase letters from a to z hence 26 total.
        boolean[] visited = new boolean[n];
        boolean[] currPath = new boolean[n];

        for(int i=0; i<n; i++){                     // O(V)
            if(!visited[i]){
                if(dfs(i, adj, dp, visited, currPath, colors)){
                    return -1;
                }
            }
        }

        return result;
    }


    // DFS time complexity id O(V+E) * 26, but 26 is constant hence we can remove that so effectively O(V+E)
    // space complexity is O(V) for recursive call stack.
    private boolean dfs(int node, List<List<Integer>> adj, int[][] dp, boolean[] visited, boolean[] currPath, String colors) {
        if(currPath[node]){         // cycle detected - node is already present in current path
            return true;
        }
        if(visited[node]){      // cycle is not detected but adjacent node is already visited by some other path.
            return false;
        }

        visited[node] = true;
        currPath[node] = true;

        for (int neighbor : adj.get(node)) {
            if (dfs(neighbor, adj, dp, visited, currPath, colors)) {
                return true;
            }

            // check for all 26 colors
            for (var i=0; i<26; i++) {
                dp[node][i] = Math.max(dp[node][i], dp[neighbor][i]);       // all colors count for current node = max of adjacent nodes color count and current node's color count.
            }
        }

        // while traversing back mark leaving vertex/node as false.
        currPath[node] = false;
        dp[node][colors.charAt(node) - 'a']++;      // we need to consider color at that vertex/node as well.

        for (int colorCount : dp[node])             // find max colorCount till this vertex/node.
            result = Math.max(result, colorCount);

        return false;
    }
}
