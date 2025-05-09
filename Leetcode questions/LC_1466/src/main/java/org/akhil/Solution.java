package org.akhil;

import java.util.*;

public class Solution {

    // Time Complexity: O(N + E), where N is the number of cities and E is the number of connections.
    // Space Complexity: O(N + E), for the adjacency list, visited array, and existingDir set.
//    public int minReorder(int n, int[][] connections) {
//        Set<String> existingDir = new HashSet<>();      // to store actual directions.
//        List<List<Integer>> adj = new ArrayList<>();
//        boolean[] visited = new boolean[n];
//        int count = 0;
//
//        for(int i=0; i<n; i++){
//            adj.add(new ArrayList<>());
//        }
//
//        for(int[] conn:connections){
//            adj.get(conn[0]).add(conn[1]);
//            adj.get(conn[1]).add(conn[0]);
//
//            existingDir.add(conn[0]+"-"+conn[1]);
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(0);
//
//        while(!queue.isEmpty()){
//            int polled = queue.poll();
//            visited[polled] = true;
//
//            for(int neighbor:adj.get(polled)){
//                if(!visited[neighbor]){
//                    String dir = polled+"-"+neighbor;       // node to its child (0 is ultimate parent)
//                    if(existingDir.contains(dir)){
//                        count++;
//                    }
//                    queue.offer(neighbor);
//                }
//            }
//        }
//        return count;
//    }

    //---------------------

    // Solution 2 - without using set
    // even though the time complexity will be same here but as we are not using set so all hashing and all will be eliminated which will save some time.
    public int minReorder(int n, int[][] connections) {
        boolean[] visit = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int[] nums : connections) {
            graph.get(nums[0]).add(nums[1]);
            graph.get(nums[1]).add(-nums[0]);
        }

        int count = 0;

        visit[0] = true;
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int pop = Math.abs(queue.pop());
            for (Integer num : graph.get(pop)) {
                if (!visit[Math.abs(num)]) {
                    if (num > 0) {
                        count++;
                    }
                    visit[Math.abs(num)] = true;
                    queue.offer(num);
                }
            }
        }

        return count;
    }
}
