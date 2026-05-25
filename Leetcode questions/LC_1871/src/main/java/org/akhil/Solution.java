package org.akhil;

public class Solution {

    // Solution 1 - simulation (TLE)
    // O(N^2)/O(N)

    // Here one thing we should note is we can only jump forward.
    // if we are at index i then we can only jump in range i+minJump to i+maxJump and only if the value at the index is 0.
    // so the simplest and bruteforce approach is to try out each possible way and check if we can reach till end or not. (this is simply DFS)
    // for example we have string like s = 01010210 , minJump = 2 and maxJump = 4
    // so we will start from index 0 and current range will be index 2 to index 4.
    // in this range we have 0 at index 2 and index 4 only, index 3 has '1' so we can not visit it.
    // so form index 0 first path we can take is jump to index 2.
    // PATH 1 ->
    //          new i = 2 so new range is from index 4 to index 6. In this range we have 0 at only one index i.e. index 4.
    //          so new i will be i = 4 and new range will be from index 6 to 8 (i.e. oob) so we can go till 7. i.e. till end
    //          so this is a valid path.
    // But if in case this wasn't the valid path then we should have explored the other path from i = 0 i.e. jumping to 4 instead of 2.

    // The issue with this approach if if we have string like s = "000000000000000000"
    // then no matter how small or big range we have, if we are starting at ith index then we will be visiting every single index in front of i.
    // and this process will happen for every single index which gives us O(N^2) Time complexity
//    public boolean canReach(String s, int minJump, int maxJump) {
//        return explore(s, 0, minJump, maxJump);
//    }
//
//    private boolean explore(String s, int i, int min, int max){
//        if(i == s.length()-1){
//            return true;
//        }
//
//        for(int currIndex = i+min; currIndex <= i+max; currIndex++){
//            if(currIndex < s.length() && s.charAt(currIndex) == '0'){
//                if(explore(s, currIndex, min, max)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    // -------------------------------
    // Solution 2 - Difference array technique
    // O(N)/O(N)

    // here we are sure that we can only move forward and in specific range.
    // so if we simply keep track of range where we can reach from current position then we can easily identify if we can reach till
    // end or not.
    // this tracking can simply be done using a difference array for example
    // we have string like s = 01010210 , minJump = 2 and maxJump = 4
    // So we can take an array of length n i.e. size of string
    // now from index i=0 our range becomes index 2 to 4 so simply mark the index 2 as 1 in the array indicating this position can be
    // reached and at the end (i.e. end of range) mark the array as -1 indicating from here onwards our reach is ended.
    // now while traversing the string if we encounter a '0' and we are withing reachable range then again mark the new range from
    // current point.
    // At the end if last index is within the reachable range then return true or else return false

    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        if(s.charAt(n - 1) != '0') {        // early exit
            return false;
        }

        int[] reach = new int[n];
        int cumulativeSum = 0;

        for(int i=0; i<n; i++){
            cumulativeSum = cumulativeSum + reach[i];

            if(i == 0 || (s.charAt(i) == '0' && cumulativeSum > 0)){
                // compute the new range and mark it
                int newMin = i + minJump;
                int newMax = i + maxJump;
                if(newMin < n) {
                    reach[newMin] += 1;
                }
                if(newMax+1 < n) {
                    reach[newMax+1] -= 1;
                }
            }
        }

        return cumulativeSum > 0;
    }
}
