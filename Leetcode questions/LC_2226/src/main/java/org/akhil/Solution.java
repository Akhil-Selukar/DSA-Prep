package org.akhil;

public class Solution {

    // Solution 1 - O(Nlog(M))/O(1) where N is number of elements in candies array and M is the maximum of candies.
//    public int maximumCandies(int[] candies, long k) {
//        // Find sum of all candies
//        long sum = 0;
//        int max = Integer.MIN_VALUE;
//        for(int num:candies){
//            sum += num;
//            max = Math.max(max, num);
//        }
//
//        if(sum < k){
//            return 0;
//        }
//        if(sum == k){
//            return 1;
//        }
//
//        int low = 1;
//        int high = max;
//        int result = 0;
//
//        while(low <= high){
//            int mid = low + (high-low)/2;
//            if(canDistribute(candies, k, mid)){
//                result = mid;
//                low = mid+1;
//            } else {
//                high = mid-1;
//            }
//        }
//        return result;
//    }
//
//    private boolean canDistribute(int[] candies, long k, int pileSize){
//        long childrens = 0;
//        for(int candy:candies){
//            childrens = childrens + candy/pileSize;
//            if(childrens >= k){
//                return true;
//            }
//        }
//        return false;
//    }

    // Solution 1.1 - (same time and space complexity just slight change to reduce some loops)
    // Even though here the loop is eliminated still this is not a best solution as inside while loop we have a for loop
    // and in this case no matter how small our answer is the binary search algorithm will run for log(10000000) times which is not good.
    // because in most of the cases maximum max value will not be 10000000 and will be much less than that.

    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = 10000000;
        int result = 0;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(canDistribute(candies, k, mid)){
                result = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return result;
    }

    private boolean canDistribute(int[] candies, long k, int pileSize){
        long childrens = 0;
        for(int candy:candies){
            childrens = childrens + candy/pileSize;
            if(childrens >= k){
                return true;
            }
        }
        return false;
    }
}
