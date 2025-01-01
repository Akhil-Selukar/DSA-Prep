package org.akhil;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4};
//        int[] arr = new int[] {1,-1,0};
        int k = 4;

        System.out.println(subarraySum(arr, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}