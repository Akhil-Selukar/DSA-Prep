package org.akhil;

public class Solution {

    // // Solution 1 - Using linear search (TLE)
    // // O(M*N)/O(1) where M is maxPossibleTime and N is number of values in batteries array
    // public long maxRunTime(int n, int[] batteries) {
    //     long sum = 0;
    //     for(int battery:batteries){
    //         sum = sum + battery;
    //     }

    //     long maxTimePossible = sum/n;

    //     for(long i=maxTimePossible; i>=0; i--) {
    //         if (isPossible(batteries, i, n)) {
    //             return i;
    //         }
    //     }
    //     return 0;
    // }

    // private boolean isPossible(int[] batteries, long timePerComp, int noOfComp){
    //     long requiredTime = timePerComp * noOfComp;

    //     for(int battery:batteries){
    //         requiredTime = requiredTime - Math.min(battery, timePerComp);       // min() because at max we can get power which current battery can give. It can be equal to required or max available to that battery

    //         if(requiredTime <= 0){
    //             return true;
    //         }
    //     }
    //     return false;
    // }


    // ---------------------------
    // Solution 2 - Using binary search
    // O(N*logM)/O(1) where M is maxPossibleTime and N is number of values in batteries array
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for(int battery:batteries){
            sum = sum + battery;
        }

        long min = 0;
        long maxTimePossible = sum/n;
        long result=0;

        while(min<=maxTimePossible){
            long mid = min + (maxTimePossible - min)/2;

            if (isPossible(batteries, mid, n)) {
                result = mid;
                min = mid+1;
            } else {
                maxTimePossible = mid-1;
            }
        }
        return result;
    }

    private boolean isPossible(int[] batteries, long timePerComp, int noOfComp){
        long requiredTime = timePerComp * noOfComp;

        for(int battery:batteries){
            requiredTime = requiredTime - Math.min(battery, timePerComp);       // min() because at max we can get power which current battery can give. It can be equal to required or max available to that battery

            if(requiredTime <= 0){
                return true;
            }
        }
        return false;
    }
}
