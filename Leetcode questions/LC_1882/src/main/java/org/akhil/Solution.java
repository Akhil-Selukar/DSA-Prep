package org.akhil;

import java.util.PriorityQueue;

public class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        // free servers: [weight, index] smallest weight first
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        // busy servers: [finishTime, weight, index] smallest finishTime first
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            if (a[1] != b[1]){
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });

        // at first all servers are free
        for (int i = 0; i < n; i++) {
            freeServers.add(new int[]{servers[i], i});
        }

        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            // If at this point any busy server is getting free then free the server first
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= i) {
                int[] cur = busyServers.poll();
                freeServers.add(new int[]{cur[1], cur[2]});
            }

            // assign the task to the top free server available
            // if no server is free then free up the 1st server from busy server list which is going to get free.
            if (freeServers.isEmpty()) {
                int[] cur = busyServers.poll();
                result[i] = cur[2];
                busyServers.add(new int[]{cur[0] + tasks[i], cur[1], cur[2]});
            } else {
                // assign task to free server and add it in busy server queue.
                int[] cur = freeServers.poll();
                result[i] = cur[1];
                busyServers.add(new int[]{i + tasks[i], cur[0], cur[1]});
            }
        }
        return result;
    }
}
