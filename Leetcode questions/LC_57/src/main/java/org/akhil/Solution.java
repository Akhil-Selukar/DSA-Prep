package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    // Solution 1 - Using sorting
    // O(NlogN)/O(N)
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        List<int[]> ans = new ArrayList<>(Arrays.asList(intervals));
//        List<int[]> answer = new ArrayList<>();
//        ans.add(newInterval);
//        Collections.sort(ans, (a, b)->{return a[0]-b[0];});
//
//        int[] previous = ans.get(0);
//
//        for(int i=1; i<ans.size(); i++){
//            int[] current = ans.get(i);
//            boolean merge = false;
//
//            if(previous[1] >= current[0]){
//                previous[0] = Math.min(previous[0], current[0]);
//                previous[1] = Math.max(previous[1], current[1]);
//                merge = true;
//            }
//
//            if(!merge){
//                answer.add(previous);
//                previous = current;
//            }
//        }
//
//        answer.add(previous);
//
//        return answer.toArray(new int[answer.size()][]);
//    }


    // Solution 2 - bruteforce without using sorting (as given intervals are already in sorted order hence this will work)
    // O(N)/O(N)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>();

        int n = intervals.length;
        int i=0;

        // add intervals till newInterval
        while(i<n && newInterval[0] > intervals[i][1]){             // newInterval = [2,5], intervals = [[1,3][6,8]]
            answer.add(intervals[i]);
            i++;
        }

        // if required merge newInterval with currentInterval at ith index
        while(i<n && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        answer.add(newInterval);

        // add remaining intervals in answer
        while(i<n){
            answer.add(intervals[i]);
            i++;
        }

        // convert list to array and return
        int[][] result = new int[answer.size()][2];
        int index = 0;
        for(int[] arr:answer){
            result[index++] = arr;
        }
        return result;
    }
}
