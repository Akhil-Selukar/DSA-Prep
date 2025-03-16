package org.akhil;

public class Solution {

    // Time complexity will be dominant for the while loop which will be O(R * (log(max * cars^2)), This can be simplified by using simple logarithmic rules to O(R * (log max + log cars)).
    // Space complexity is O(1)
    public long repairCars(int[] ranks, int cars) {
        int max = Integer.MIN_VALUE;
        for(int rank:ranks){
            max = Math.max(max, rank);
        }
        
        long start = 1;
        long end = max * (long)Math.pow(cars, 2);
        long ans = start;
        
        while(start <= end){
            long mid = start + (end-start)/2;
            
            if(canRepair(mid, ranks, cars)){
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private boolean canRepair(long mid, int[] ranks, int cars) {
        long repairs = 0;
        for(int rank:ranks){
            repairs += (long)Math.sqrt(mid/rank);
        }

        if(repairs >= cars){
            return true;
        }
        return false;
    }
}
