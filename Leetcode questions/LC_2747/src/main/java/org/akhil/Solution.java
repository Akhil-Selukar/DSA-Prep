package org.akhil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = logs.length;

        // Sort logs based on time
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int q = queries.length;
        int[][] timeIndex = new int[q][2];  // To save original index of query so that we can rearrange the answer for queries {time, original index}

        for (int i = 0; i < q; i++) {
            timeIndex[i][0] = queries[i];   // query time
            timeIndex[i][1] = i;            // original index
        }

        // Sort timeIndex by time so that we can apply sliding window easily on it
        Arrays.sort(timeIndex, (a, b) -> a[0] - b[0]);

        Map<Integer, Integer> mp = new HashMap<>();  // server_id -> count in window (this is the number of servers which receives the log during the time interval)
        int[] result = new int[q];

        // pointers for sliding window
        int p1 = 0;
        int p2 = 0;

        for (int[] pair : timeIndex) {
            int currTime = pair[0];
            int index = pair[1];        // original query index

            // define the query interval
            int start = currTime - x;
            int end = currTime;

            // move p2 till end of query interval to cover all logs inside the interval
            while (p2 < m && logs[p2][1] <= end) {
                int serverId = logs[p2][0];
                mp.put(serverId, mp.getOrDefault(serverId, 0) + 1);
                p2++;
            }

            // move p1 till start of the interval to remove all logs which are out of range now
            while (p1 < m && logs[p1][1] < start) {
                int serverId = logs[p1][0];
                mp.put(serverId, mp.get(serverId) - 1);

                // if it is log count on any server is 0 then remove that server from consideration
                if (mp.get(serverId) == 0) {
                    mp.remove(serverId);
                }
                p1++;
            }

            // mp.size() = unique servers got requests
            result[index] = n - mp.size();
        }
        return result;
    }
}
