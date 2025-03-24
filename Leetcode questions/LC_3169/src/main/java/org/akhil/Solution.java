package org.akhil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Solution 1 - TLE (O(N*D)/O(N)) where N is number of days and D is number of meetings
//    public int countDays(int days, int[][] meetings) {
//        boolean[] occupied = new boolean[days];
//
//        for(int[] meeting:meetings){
//            for(int day=meeting[0]; day<=meeting[1]; day++){
//                occupied[day-1] = true;
//            }
//        }
//
//        int count = 0;
//        for(boolean day:occupied){
//            if(!day){
//                count++;
//            }
//        }
//
//        return count;
//    }

    // Solution 2 - Still TLE (O(N^2)/O(N))
//    public int countDays(int days, int[][] meetings) {
//        Set<Integer> set = new HashSet<>();
//
//        for(int[] meeting:meetings){
//            for(int day=meeting[0]; day<=meeting[1]; day++){
//                set.add(day);
//            }
//        }
//
//        return days-set.size();
//    }


    // Solution 3 - O(MlogM)/O(logM) where M is number of elements in meetings array (MlogM because of sorting and logM space because of sorting only)
    public int countDays(int days, int[][] meetings) {
        // Sorting is important here.
        Arrays.sort(meetings, (a, b) -> a[0]-b[0]);

        int count = 0;
        int lastEnd = 0;

        for(int[] meeting:meetings){
            if(meeting[0]>lastEnd){
                count = count + (meeting[0] - lastEnd - 1);
            }
            lastEnd = Math.max(lastEnd, meeting[1]);
        }

        return count + (days-lastEnd);
    }
}
