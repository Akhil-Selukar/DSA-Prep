package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // O(N)/O(N)
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> groups = new HashMap<>();
        int count = 0;

        for(int ans:answers){
            groups.put(ans, groups.getOrDefault(ans, 0)+1);
        }

        for(Map.Entry<Integer, Integer> group:groups.entrySet()){
            int ans = group.getKey();

            if(ans == 0){
                count = count+group.getValue();    // if rabbit is saying there is no other rabbit of his color then that is the only rabbit we have to consider.
            } else {
                int rabbitsInGroup = ans + 1;       // if a rabbit says there are x other rabbits of same colors as that of me then that means total rabbits of that color are 'x+1'
                int totalAns = group.getValue();
                int uniqueGroups = (int)Math.ceil((double)totalAns/rabbitsInGroup);  // if there are 3 rabbits saying there is 1 more rabbit of my color then out of 3 two can be of same color and 1 will be of different color who is talking about some other rabbit which did not answer.

                count = count + uniqueGroups * (rabbitsInGroup);
            }
        }
        return count;
    }
}
