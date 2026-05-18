package org.akhil;

import java.util.*;

public class Solution {
    // Intuition - Here first 2 jumping conditions are simple but for 3rd jumping condition to implement we need to know
    // beforehand at which other locations/indices the same value (i.e. arr[i]) is present which hint us to use map and
    // store all values and the indices where we can find that value.
    // Now 2nd thing to note is, from one index we can move to multiple other location and from there again multiple other
    // which makes a graph structure from (1 node we can visit 2 or more nodes) And in graph shortest path between from
    // root to any other node can be calculated using BFS (the number of levels present between those two nodes is shortest
    // path) hence we can use BFS here.
    // Try drawing the graph and simulate a BFS. From root all other nodes which are connected to root can be covered in
    // 1 jump (i.e. 1 edge between those nodes and root) and from there further nodes can be covered by 1 more jump and
    // so on.
    // Solution 1 - using BFS
    // O(N)/O(N)
    public int minJumps(int[] arr) {
        int n = arr.length;
        int jumps = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int val = arr[i];
            if(!map.containsKey(val)){
                map.put(val, new ArrayList<>());
            }
            map.get(val).add(i);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                int polled = queue.poll();
                if(polled == n-1){      // last node was reached in last level (here last level is important hence we are doing jump++ at the end)
                    return jumps;
                }

                // can jump to i-1 position (i.e. backward jump)
                int backJump = polled-1;
                if(backJump >=0 && !visited[backJump]){
                    queue.offer(backJump);
                    visited[backJump] = true;
                }
                // can jump to i+1 position (i.e. forward jump)
                int forwardJump = polled+1;
                if(forwardJump < n && !visited[forwardJump]){
                    queue.offer(forwardJump);
                    visited[forwardJump] = true;
                }
                // can jump to jth index if i!=j and arr[i] == arr[j]
                if(map.containsKey(arr[polled])) {
                    for (int val : map.get(arr[polled])) {
                        if (polled != val && !visited[val]) {
                            queue.offer(val);
                            visited[val] = true;
                        }
                    }
                    map.remove(arr[polled]); // as current node and all its adjacent nodes with same value are added in queue.
                }
            }
            jumps++;        // next level means 1 jump (all index in this level can be covered using 1 jump from prev index
        }

        return -1;
    }
}
