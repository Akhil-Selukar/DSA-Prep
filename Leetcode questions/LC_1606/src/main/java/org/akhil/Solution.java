package org.akhil;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();   // why treeset? explained below

        // at start all servers are available
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);     // [taskFinishTime, serverId]
        int[] requestsServed = new int[k];

        for(int i=0; i<arrival.length; i++) {
            int arrivalTime = arrival[i];
            int finishTime = arrivalTime + load[i];

            // if any server becomes free then first make it available because this might be the preferred server for the request
            while(!busy.isEmpty() && busy.peek()[0] <= arrivalTime) {
                available.add(busy.poll()[1]);
            }

            // if no server is available then drop the request
            if (available.isEmpty()) {
                continue;
            }

            Integer serverId = available.ceiling(i % k);     // this is why treeset, we can get the exact server which we want or the next closest to it
            if(serverId == null){
                serverId = available.first();
            }

            available.remove(serverId);
            requestsServed[serverId]++;
            busy.offer(new int[]{finishTime, serverId});
        }

        int maxReqs = 0;
        for(int count:requestsServed) {
            maxReqs = Math.max(maxReqs, count);
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<k; i++) {
            if(requestsServed[i] == maxReqs){
                res.add(i);
            }
        }
        return res;
    }
}
