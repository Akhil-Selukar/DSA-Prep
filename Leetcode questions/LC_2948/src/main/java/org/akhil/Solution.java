package org.akhil;

import java.util.*;

public class Solution {
    // As we read the question the first thought might be go greedy and then try to optimize it. So if we go greedy then
    // we will probably check each element with every element ahead of it and if the next element is less and difference
    // is within the limit we will swap it. for example if nums is [1,7,2,18,6,1] with limit 2 then while we are at 1 we will get
    // |nums[0]-nums[2]| <= limit but 1 is already smaller than 2 so no swapping. But when we are at 7 we will get
    // |nums[1]-nums[4] <= limit and 6 is less than 7 so we will swap it to get [1,6,2,18,7,1]. Similarly at index 2
    // we will have |nums[2]-nums[5]| <= limit and nums[5] < nums[2] so swap it to get [1,6,1,18,7,2] which will be a correct
    // answer.

    // But this solution will fail. Consider testcase [3,2,1] and limit 1 now while at index 0 we will swap it with index 1 to get [2,3,1]
    // new when we again check index 0 with index 2 the absolute diff will be greater than limit so we will not swap 2 with 1.
    // in next iteration we will check 3 against 1 (i.e. index 1 and 2) here as well the difference is not withing limit so we
    // will not swap it and the final answer we will get is [2,3,1] which is Wrong, the answer should be [1,2,3].

    // Hence from this observation we can conclude that if the numbers have difference within limit then no matter where they
    // are placed (i.e. at what index) they will be in sorted order in the result and if the values are not within the limit then
    // those values will not move.
    // But there is another situation here, what if nums is [7,3,1,8,2,9] in this case values 1,2,3 has difference within the limit
    // and values 7,8,9 also has difference within the limit. then does that mean we can simply sort the array?, No. In this
    // case we need to make sure that the values has to be swapped with it's corresponding group value only so at 0th index
    // we can not put anything from 1,2,3 we have to put smallest from 7,8,9 only. So this gives another observation that we
    // need to group the values having difference within the range and are continuous. and make sure values are placed as
    // per there group only.

    // O(NlogN)/O(N)
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        // form groups and arrange the smallest in each group first (we can sort the entire array and put it in queue)
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        List<Queue<Integer>> groups = new ArrayList<>();    // to store groups in sorted form
        Map<Integer, Integer> map = new HashMap<>();    // to store which element belong to which group
        int groupId = -1;

        for(int i=0; i<temp.length; i++){
            if(i == 0){
                groups.add(new LinkedList<>());
                groups.get(groups.size()-1).offer(temp[i]);
                map.put(temp[i], ++groupId);
            } else {
                if (temp[i] - temp[i - 1] <= limit) {
                    // add in same group
                    groups.get(groups.size() - 1).offer(temp[i]);
                    map.put(temp[i], groupId);
                } else {
                    // create new group
                    groups.add(new LinkedList<>());
                    groups.get(groups.size() - 1).offer(temp[i]);
                    map.put(temp[i], ++groupId);    // started new group hence change the groupId
                }
            }
        }

        // arrange the elements to get result
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            int numGroup = map.get(num);

            nums[i] = groups.get(numGroup).poll();      // as we have filled queue with sorted elements hence we will get smallest first in each group
        }

        return nums;
    }
}
