package org.akhil;

import java.util.*;

public class Solution {

    // Solution 1 - TLE
    // TC - O(N^2 + M^2)
    // SC - O(M + N)
//    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
//        // Create adjacency list for both trees
//        int n = edges1.length+1;
//        int m = edges2.length+1;
//
//        List<List<Integer>> adj1 = generateTree(edges1);
//        List<List<Integer>> adj2  = generateTree(edges2);
//
//        // part 1 - find best node to connect in tree2
//        int maxPossibleInT2 = 0;
//        for(int i=0; i<m; i++){
//            int canVisit = bfs(i, adj2, 1);
//            maxPossibleInT2 = Math.max(maxPossibleInT2, canVisit);
//        }
//
//        // part 2 - traverse through tree1 and populate answer array
//        int[] answer = new int[n];
//        for(int i=0; i<n; i++){
//            answer[i] = bfs(i, adj1, 0) + maxPossibleInT2;
//        }
//
//        return answer;
//
//    }
//
//    private int bfs(int node, List<List<Integer>> adj, int offset) {
//
//        int level = offset;
//        Queue<Integer> queue = new LinkedList<>();
//        boolean[] visited = new boolean[adj.size()];
//        visited[node] = true;
//        queue.offer(node);
//        int nodeCount = 0;
//
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            if(level % 2 == 0){
//                nodeCount += size;
//            }
//            while(size > 0){
//                int polled = queue.poll();
//                for(int neighbour:adj.get(polled)){
//                    if(!visited[neighbour]){
//                        queue.offer(neighbour);
//                        visited[neighbour] = true;
//                    }
//                }
//                size--;
//            }
//            level++;
//        }
//        return nodeCount;
//    }
//
//    private List<List<Integer>> generateTree(int[][] edges) {
//        List<List<Integer>> adj = new ArrayList<>();
//
//        for(int i=0; i<edges.length+1; i++){
//            adj.add(new ArrayList<>());
//        }
//
//        for(int[] edge:edges){
//            adj.get(edge[0]).add(edge[1]);
//            adj.get(edge[1]).add(edge[0]);
//        }
//
//        return adj;
//    }

//--------------------------------------------

    // Solution 2 - only 1 BFS on each tree.
    // O(N + M)
    // O(N + M)

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        // build adjacency lists
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        
        List<List<Integer>> adj1 = generateTree(edges1);
        List<List<Integer>> adj2 = generateTree(edges2);

        // Step-1: Find the best you can do by adding the extra edge in tree-2
        // Here as we are considering alternate rows hence from every node the count will be same for all odd level and even leve nodes (it's just that based on node selected it will be interchanged i.e. odd count can be even for some other node and even can be odd)
        // Hence only 1 iteration will be enough to find the max count.
        int evenCountT2 = bfs(0, adj2, null);            // count of even-level nodes
        int oddCountT2 = m - evenCountT2;                // the rest are odd-level
        int bestT2 = Math.max(evenCountT2, oddCountT2);

        // Step-2: Run BFS on tree-1, and record nodes on even levels
        // Same logic goes here as well hence we can find the counts just by 1 iteration of BFS
        boolean[] atEvenLevel = new boolean[n];             // to keep track of nodes which are at even level.
        int evenCountT1 = bfs(0, adj1, atEvenLevel);

        // Step-3: For each i, if i was even-level in tree-1 we connect it to tree-2's best even-level
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            if (atEvenLevel[i]) {
                // it contributes even_count1 from tree-1 plus best2 from tree-2
                ans[i] = evenCountT1 + bestT2;
            } else {
                // it would be odd in tree-1, so you get (n-evenCountT1) + bestT2
                ans[i] = (n - evenCountT1) + bestT2;         // if node is not at even level then required count will be (n-evenCountT1) + bestT2
            }
        }
        return ans;
    }

    private int bfs(int node, List<List<Integer>> adj, boolean[] atEvenLevel) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        q.add(node);
        visited[node] = true;
        int count = 0;
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            // on even levels we both add to count and (optionally) record the nodes
            if (level % 2 == 0)
                count += size;

            while (size > 0) {
                int curr = q.poll();

                if (atEvenLevel != null && level % 2 == 0) {
                    // mark this node as "atEvenLevel"
                    atEvenLevel[curr] = true;
                }
                for (int neighbour : adj.get(curr)) {
                    if (!visited[neighbour]) {
                        q.add(neighbour);
                        visited[neighbour] = true;
                    }
                }
                size--;
            }
            ++level;
        }
        return count;
    }

    private List<List<Integer>> generateTree(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < edges.length + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return adj;
    }
}
