package org.akhil;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    // Solution using priority queue
    // O(M*logM + M*logN)/O(M+N) where M is length of meetings and N is number of rooms
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];

        // it is given that each start time will be unique hence no need to handel case where a[0] == b[0].
        Arrays.sort(meetings, (a, b)->{     // O(M*logM)
            return a[0]-b[0];
        });

        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        // add all rooms to availableRooms      // O(N)
        for(int i=0; i<n; i++){
            availableRooms.offer(i);
        }
        PriorityQueue<int[]> occupiedRooms = new PriorityQueue<>((a, b)->{      // [endTime, roomIndex]
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        // iterate over meetings
        for(int[] meeting:meetings){        // O(M)
            int currSTime = meeting[0];
            int currETime = meeting[1];

            // if there is any meeting ending before current meeting start then we need to freeup that room first as the newly freed up room might have the lowest index
            // O(logN) because at max there can be N rooms and all can be occupied and none can be freed
            while(!occupiedRooms.isEmpty() && occupiedRooms.peek()[0] <= currSTime){
                availableRooms.offer(occupiedRooms.poll()[1]);  // in available rooms we just need room index.
            }

            // if rooms are available we can conduct the meeting but if not then we need to delay the meeting till a room is freed
            if(!availableRooms.isEmpty()){
                int freedAt = currETime;
                int room = availableRooms.poll();
                occupiedRooms.offer(new int[]{freedAt, room});
                count[room]++;
            } else {
                int[] earliestAvailable = occupiedRooms.poll();
                int freedAt = earliestAvailable[0] + (currETime - currSTime);   // current meeting will be held after the previous is finished so the actual end time for current meeting will be previous end time + current meeting duration.
                int room = earliestAvailable[1];
                occupiedRooms.offer(new int[]{freedAt, room});
                count[room]++;
            }
        }

        // use count[] to find the room that held most no of meetings.
        int result = 0;
        for(int i=1; i<n; i++){         // O(N)
            if(count[result] < count[i]){
                result = i;
            }
        }

        return result;
    }
}
