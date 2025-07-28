package org.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // O(N+M)/O(min(N)) as we are adding N elements in map
    // where N is length of nums1 and M is length of nums2
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> temp = new ArrayList<>();

        for(int num:nums1){             // O(N)
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        for(int num:nums2){             // O(M)
            if(freq.containsKey(num)){
                temp.add(num);

                freq.put(num, freq.get(num)-1);
                if(freq.get(num) == 0){
                    freq.remove(num);
                }
            }
        }

        int[] result = new int[temp.size()];

        for(int i=0; i<temp.size(); i++){
            result[i] = temp.get(i);
        }

        return result;
    }
}
