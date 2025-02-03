package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int remainder = 0;
        for(int i=0; i<nums.length; i++){
            remainder = remainder + nums[i];
            remainder = remainder % k;

            if(remainder == 0 && i > 0){        // i>0 because we want subarray of at least 2 elements.
                return true;
            }

            // map.containsKey(remainder) means we had got this remainder earlier and to get the same remainder again we have to add multiple of K in earlier number that means we have a subarray of having sum multiple of K.
            if(map.containsKey(remainder) && i - map.get(remainder) > 1){       // map.get(remainder) - i > 1 will ensure that size of subarray is at least 2
                return true;
            }

            if(!map.containsKey(remainder)){
                map.put(remainder, i);
            }
        }

        return false;
    }
}
