package org.akhil;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    // TC - O(N + M log(M) + K log(M))  as K can at max be M hence O(N + 2MlogM) which is nothing but O(N+MlogM)
    // SC - O(N) at max there can be N unique elements and we will need O(N) space for map and O(N) for queue i.e. O(2N) which is O(N)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1]-a[1]);

        // O(N)
        for(int num:nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        // O(M) where M is number of unique elements in nums
        for(Map.Entry<Integer, Integer> entry:freq.entrySet()){
            queue.offer(new int[] {entry.getKey(), entry.getValue()});      // O(LogM)
        }

        int[] ans = new int[k];

        for(int i=0; i<k; i++){         // O(K)
            ans[i] = queue.poll()[0];   // O(LogM)
        }

        return ans;
    }
}
