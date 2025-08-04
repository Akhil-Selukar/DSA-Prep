package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Solution using map and sliding window
    // O(N)/O(N)
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int p1 = 0;     // start
        int p2 = 0;     // end

        while (p2 < n) {
            map.put(fruits[p2], map.getOrDefault(fruits[p2], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[p1], map.get(fruits[p1]) - 1);
                if (map.get(fruits[p1]) == 0) {
                    map.remove(fruits[p1]);
                }
                p1++;
            }

            result = Math.max(result, p2 - p1 + 1);
            p2++;
        }

        return result;
    }
}
