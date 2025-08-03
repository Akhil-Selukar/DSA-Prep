package org.akhil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    // Solution 1 - Using priorityQueue
    // O(N)/O(N) where N is task.length
    public int leastInterval(char[] tasks, int n) {

        int time = 0;

        // Count frequency of each task
        int[] freq = new int[26];
        for (char ch : tasks) {             // O(N)
            freq[ch - 'A']++;
        }

        // PriorityQueue to store frequencies as we need the highest frequency first
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {              // O(26) ~ O(1)
            if (freq[i] > 0) {
                pq.offer(freq[i]);
            }
        }

        // O(N) overall
        while (!pq.isEmpty()) {
            int cycle = n + 1;      // this many task we can perform in 1 cycle.
            List<Integer> temp = new ArrayList<>();  // to store the scheduled task which is currently waiting
            int taskCount = 0;          // taskCount because at last cycle it might happen that we don't have n+1 task left so whatever is left we will have to schedule those only.

            // Execute tasks in each cycle
            while (cycle > 0 && !pq.isEmpty()) {
                int currentFreq = pq.poll();
                if (currentFreq > 1) {
                    temp.add(currentFreq - 1);          // as task is performed/scheduled hence frequency of that task will be reduced.
                }
                taskCount++;
                cycle--;
            }

            // Restore updated frequencies to the heap
            // we can restore all because in above while loop we performed n tasks so whatever task was performed 1st, now the wait for it will be over.
            for(int task:temp){
                pq.offer(task);
            }

            // Add time for the completed cycle
            time = time + (pq.isEmpty() ? taskCount : n + 1);
        }
        return time;
    }
}
