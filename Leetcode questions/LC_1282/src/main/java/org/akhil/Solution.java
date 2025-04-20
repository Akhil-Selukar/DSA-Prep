package org.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // TC - O(N)
    // SC - O(N)
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        // populate the map having indices of all people with same group size
        for(int i=0; i<groupSizes.length; i++){     // population of map is O(N)
            List<Integer> indices = map.getOrDefault(groupSizes[i], new ArrayList<>());
            indices.add(i);
            map.put(groupSizes[i], indices);
        }

        // divide people in the groups of respective sizes.
        // Below for loop iterates O(U) times, where U is number of unique groupSizes
        // inside while loop will iterate O(people_with_same_GS/GS) times.
        // inside while loop we are adding each person to its respective group
        // So at the end we are adding each person to its respective group only once. And we are doing this for each person
        // hence overall time complexity for this entire for loop will be O(N)
        for(Map.Entry<Integer, List<Integer>> entry:map.entrySet()){
            int groupSize = entry.getKey();
            List<Integer> indices = entry.getValue();
            int groups = indices.size()/groupSize;
            int indexToAdd = 0;

            while(groups > 0){
                List<Integer> group = new ArrayList<>();

                for(int i=0; i<groupSize; i++){
                    group.add(indices.get(indexToAdd++));
                }
                ans.add(group);
                groups--;
            }
        }

        return ans;
    }
}
