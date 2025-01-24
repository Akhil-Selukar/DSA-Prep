package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>(Arrays.asList(intervals));
        List<int[]> answer = new ArrayList<>();
        ans.add(newInterval);
        Collections.sort(ans, (a, b)->{return a[0]-b[0];});

        int[] previous = ans.get(0);

        for(int i=1; i<ans.size(); i++){
            int[] current = ans.get(i);
            boolean merge = false;

            if(previous[1] >= current[0]){
                previous[0] = Math.min(previous[0], current[0]);
                previous[1] = Math.max(previous[1], current[1]);
                merge = true;
            }

            if(!merge){
                answer.add(previous);
                previous = current;
            }
        }

        answer.add(previous);

        return answer.toArray(new int[answer.size()][]);
    }
}
