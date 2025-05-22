package org.akhil;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    // O(QlogQ) + O(NlogQ)   ->   QlogQ because of sorting and N for loop and logQ with it for fetching and pushing element in PQ
    // O(Q)  ->  for 2 PQ
    public int maxRemoval(int[] nums, int[][] queries) {

        // Sort the queries to get query starting early first
        Arrays.sort(queries, (a, b)-> a[0]-b[0]);

        PriorityQueue<Integer> availableQueries = new PriorityQueue<>((a, b) -> b-a);   // maxQueue
        PriorityQueue<Integer> inUsedQueries = new PriorityQueue<>((a, b) -> a-b);      // minQueue

        int queryIndex = 0;         // defined outside loop as once we are consumed or start consuming the query we dont have to visit the same query back as we cant reuse it.
        int usedQueryCount = 0;
        for(int i=0; i<nums.length; i++){
            // make all queries starting at index i available as we can start executing the queries
            while(queryIndex < queries.length && i == queries[queryIndex][0]){
                availableQueries.offer(queries[queryIndex][1]);     // only storing the end index as we don't need start index once we are past start index i.e. current i value.
                queryIndex++;
            }

            // if any query is/are active then first use the decrement by those queries.
            nums[i] = nums[i] - inUsedQueries.size();       // each query can decrement the value by 1 hence number of active queries = number of decrements.

            // if still the value is not 0 then check for available query if we have any
            while(nums[i] > 0 && !availableQueries.isEmpty() && availableQueries.peek() >= i){     // third check because there might be some unused queries which are already ended (i.e. end of query is already passed during iteration.
                int polled = availableQueries.poll();
                inUsedQueries.offer(polled);
                nums[i]--;
                usedQueryCount++;
            }

            // remove the queries ending at ith index from inUsedQueries as those queries will not be active at next index.
            while(!inUsedQueries.isEmpty() && i == inUsedQueries.peek()){
                inUsedQueries.poll();
            }

            // if after entire operations as well we are not able to make ith value in nums array 0 then we can not make the zero array.
            if(nums[i] > 0){
                return -1;
            }
        }

        return queries.length - usedQueryCount;
    }
}
