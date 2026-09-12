package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    // Here we are given that we can pick only 4 intervals and we need to maximize the score (i.e. total sum of their weights).
    // So here we can first simply check if this interval is allowed? i.e. if it is non overlapping with previous interval or not.
    // and if yes then we can simply check what max score we can get if we pick this interval and what max score we can
    // get if we skip this interval. and whatever is best we can return that. (This is simply a take and skip type of question
    // with additional conditions on valid interval(i.e. non overlapping) and at max 4 intervals)
    // Now if we take ith interval which is ending at 4, then for next interval we need to find an interval which starts with
    // 5 or more, and if we have 1000 intervals and out of it all 999 starts with either 4 or less then we will have to
    // iterate over 999 intervals to get to the valid one, this is not efficient so 1st thing we can do is we can sort the
    // intervals. But if we do then we will be messing up with the original indices of the interval in given input which we
    // need to return in result. So we can simply store original indices somehow (either in separate data structure or in
    // given input only by adding 1 more value).
    // even after storing the indices instead of scanning entire array from start to end in O(N) to find next indes we can
    // use binary search to find next valid interval.
    // now we are trying to maximize the score so we will need to propagate scores in every recursion but we want to return the
    // indices of chosen intervals so we need to keep track of indices as well. So somehow we need to return both the things
    // hence we need an custom object which can store both these values so that we can access them when needed. (i.e. node)

    // O(NlogN)/O(N*4)
    private class Node{
        long score = -1;
        List<Integer> indices = new ArrayList<>();
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        int[][] intervalsWithIndices = new int[n][4];   // to store original index as well
        for(int i=0; i<n; i++){
            intervalsWithIndices[i][0] = intervals.get(i).get(0);   // start
            intervalsWithIndices[i][1] = intervals.get(i).get(1);   // end
            intervalsWithIndices[i][2] = intervals.get(i).get(2);   // weight
            intervalsWithIndices[i][3] = i;         // stored the original index
        }

        Arrays.sort(intervalsWithIndices, (a, b)->{
            if(a[0] != b[0]){
                return a[0]-b[0];
            } else {
                return a[1]-b[1];
            }
        });

        // pre-compute the next interval index for each index if we choose to take it
        int[] nextIndex = new int[n];
        for (int i = 0; i < n; i++) {
            int currEnd = intervalsWithIndices[i][1];
            nextIndex[i] = findNext(intervalsWithIndices, currEnd, n);       // binary search
        }

        Node[][] dp = new Node[n+1][5];     // allowed only 4 intervals
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new Node();
            }
        }

        Node result = helper(intervalsWithIndices, nextIndex, dp, 0, 4);  // initially we are allowed to take 4 intervals and we are starting form index 0.

        int[] ans = new int[result.indices.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.indices.get(i);
        }

        return ans;
    }

    private Node helper(int[][] intervals, int[] nextInterval, Node[][] dp, int i, int k){
        if(k == 0 || i >= intervals.length){
            return new Node();  // empty node (i.e. no element)
        }

        if(dp[i][k].score != -1){
            return dp[i][k];
        }

        int currWeight = intervals[i][2];
        int currOriginalIndex = intervals[i][3];
        int nextIntervalIndex = nextInterval[i];

        // skip this interval
        Node skip = helper(intervals, nextInterval, dp, i+1, k);

        // take this interval
        Node rightResult = helper(intervals, nextInterval, dp, nextIntervalIndex, k-1);
        Node take = new Node();
        take.score = currWeight + rightResult.score;
        take.indices = new ArrayList<>(rightResult.indices);
        take.indices.add(currOriginalIndex);

        Collections.sort(take.indices);     // this is because in case of tie we need to return lexicographically smaller

        Node result;
        if(skip.score > take.score){
            result = skip;
        } else if(skip.score < take.score){
            result = take;
        } else {        // in case of same score
            result = getSmaller(take.indices, skip.indices) ? skip : take;  // in case of equal score find lexicographically smaller
        }

        dp[i][k] = result;
        return result;
    }

    private boolean getSmaller(List<Integer> take, List<Integer> skip){
        int len = Math.min(take.size(), skip.size());
        for (int i = 0; i < len; i++) {
            if (!take.get(i).equals(skip.get(i))) {
                return take.get(i) > skip.get(i);
            }
        }
        return take.size() < skip.size();
    }

    private int findNext(int[][] intervals, int currEnd, int n) {
        int start = 0;
        int end = n - 1;
        int result = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (intervals[mid][0] > currEnd) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}
