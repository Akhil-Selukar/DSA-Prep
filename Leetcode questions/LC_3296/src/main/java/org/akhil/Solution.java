package org.akhil;

public class Solution {

    // Solution - Binary search on answer
    // TC -> O(n * log(Tmax * mountainHeight^2), where Tmax = maximum time among all workers in the input, n = length of workerTimes
    // SC -> O(1)
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxTime = 0;
        for(int time:workerTimes) {
            maxTime = Math.max(maxTime, time);
        }

        long start = 1;
        long end = (long) maxTime * mountainHeight * (mountainHeight + 1) / 2;

        long result = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (canReduce(mid, workerTimes, mountainHeight)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private boolean canReduce(long mid, int[] workerTimes, int height){
        long heightReduced = 0;

        for (int t : workerTimes) {
            heightReduced += (long)(Math.sqrt(2.0 * mid / t + 0.25) - 0.5);     // This formula derivation is the main part of this question. (Try on pen and paper)

            if (heightReduced >= height) {
                return true;
            }
        }

        return heightReduced >= height;
    }
}
