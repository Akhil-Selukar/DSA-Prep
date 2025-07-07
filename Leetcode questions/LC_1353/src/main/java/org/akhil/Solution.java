package org.akhil;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    // TC -> O(NlogN)
    // SC -> O(N)
    public int maxEvents(int[][] events) {
        // sort the array of events so that we get event starting first before the event starting at last.
        Arrays.sort(events, (a, b) -> a[0]-b[0] );          // O(NlogN)

        int n = events.length;
        int index = 0;
        int currDay = 1;
        int attended = 0;

        PriorityQueue<Integer> activeEvents = new PriorityQueue<>();    // PriorityQueue because we want events ending sooner first as that need to be attended first.

        // O(N)
        while(index < n || !activeEvents.isEmpty()){        // active events condition because last event can still be active for long after we are out of bound for index.

            // skip the days when there are no events active
            if(activeEvents.isEmpty()){
                currDay = Math.max(currDay, events[index][0]);
            }

            // add events starting at current day to active events
            while(index < n && events[index][0] == currDay){
                activeEvents.offer(events[index][1]);       // O(logN)      here almost all times N will be less than actual N
                index++;
            }

            // Remove all ended events from active events (these will be unattended events)
            while(!activeEvents.isEmpty() && activeEvents.peek() < currDay){
                activeEvents.poll();            // O(N)
            }

            // attend 1 active event on currDay
            if(!activeEvents.isEmpty()){
                activeEvents.poll();            // O(N)
                attended++;
            }
            currDay++;      // move to next day
        }
        return attended;
    }
}
