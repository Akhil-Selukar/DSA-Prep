package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution 1 - bruteforce (TLE)
    // O(n)/O(L) where L is length of nums array
//    public int minPatches(int[] nums, int n) {
//        List<Integer> list = new ArrayList<>();
//
//        for(int num:nums){
//            list.add(num);
//        }
//
//        for(int i=1; i<=n; i++){
//            if(!canForm(list, i, 0)){
//                list.add(i);
//            }
//        }
//
//        return list.size() - nums.length;
//    }
//
//    private boolean canForm(List<Integer> list, int target, int index){
//        if(target == 0){
//            return true;
//        }
//
//        if(index >= list.size() || target < 0){
//            return false;
//        }
//
//        boolean take = canForm(list, target-list.get(index), index+1);
//        boolean notTake = canForm(list, target, index+1);
//
//        return take || notTake;
//    }


    // Solution 2 - Simple observation
    // TC -> O(Max(logN,L))   where L is length of nums array and N = n
    // if we observe carefully then inside while loop every time maxRange is approximately getting doubled hence it will take logN time to reach maxReach to N.
    // SC -> O(1)
    public int minPatches(int[] nums, int n) {
        int patch = 0;
        long maxReach = 0;
        int index = 0;

        while(maxReach < n){
            if(index < nums.length && nums[index] <= maxReach+1){  // we were already able to reach till maxReach and now new number nums[i] is maxReach+1 hence no extra patch required.
                maxReach = maxReach + nums[index];  // because of considering nums[i] maxReach will increase
                index++;
            } else {
                patch++;
                maxReach = maxReach + (maxReach+1);    // new patch is maxReach+1 (i.e. greedy pick of lowest number which is not reachable which is just after maxReach)
            }
        }

        return patch;
    }
}
