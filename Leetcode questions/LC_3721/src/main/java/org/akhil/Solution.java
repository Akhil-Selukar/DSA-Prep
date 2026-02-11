package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - Bruteforce (TLE)
    // O(N^2)/O(N)
//    public int longestBalanced(int[] nums) {
//        int n = nums.length;
//
//        int result = 0;
//        Map<Integer, Integer> lastSeenIndex = new HashMap<>();  // to store/retrieve last seen the index of a val if it is duplicate
//        int[] transformed = new int[n];
//
//        // Transformation values
//        // odd value = 1
//        // even value = -1
//        for (int i = 0; i < n; i++) {
//            int val = nums[i];
//
//            int transformedVal = (val % 2 == 0) ? -1 : 1;
//
//            // if the val is duplicate (i.e. we have already seen it before)
//            // Then we don't need to propagate its transformation beyond previously seen index
//            if (lastSeenIndex.containsKey(val)) {
//                int prevIndex = lastSeenIndex.get(val);
//
//                // as further in next loop we are propagating the transformedVal throughout hence to nullify it before prevIndex,
//                // we are already adding counterpart here
//                for (int j = 0; j <= prevIndex; j++) {
//                    transformed[j] -= transformedVal;       // subtracting because in case of -ve transformedVal it will become +ve here and will get nullify
//                }
//            }
//
//            // propagate the transformed value throughout to the left
//            for (int j = 0; j <= i; j++) {
//                transformed[j] += transformedVal;
//            }
//
//            // now, all balanced sub-arrays will result into 0 transformed sum.
//            // As we need longest balanced sub-array, we need the leftmost 0 from the current ith index
//            for (int j = 0; j <= i; j++) {
//                if (transformed[j] == 0) {
//                    // this is the first 0 to the left of i. (i.e. the farthest 0 to the left of i)
//                    result = Math.max(result, i - j + 1);
//                    break;
//                }
//            }
//
//            lastSeenIndex.put(val, i);
//        }
//
//        return result;
//    }


    // ------------------
    // Solution 1 - Using segment tree
    // The inner loops which are contributing the square part of TC replaced with logN
    // O(NlogN)/O(N)

    int[] segmentMin;
    int[] segmentMax;
    int[] lazyUpdateVal;
    int n;

    // populate/create the segment tree
    private void populate(int i, int start, int end){
        // if there are some updates pending then handle those first
        if(lazyUpdateVal[i] != 0){
            segmentMin[i] += lazyUpdateVal[i];
            segmentMax[i] += lazyUpdateVal[i];

            // if it was not the leaf node then need to propagate the lazy updates down to chile trees
            if(start != end){

                // left child start index = 2*currentNodeIndex + 1
                lazyUpdateVal[2*i+1] += lazyUpdateVal[i];

                // right child start index = 2*currentNodeIndex + 2
                lazyUpdateVal[2*i+2] += lazyUpdateVal[i];
            }

            // as current node's lazy update is performed hence reset it
            lazyUpdateVal[i] = 0;
        }
    }

    // update range
    private void updateRange(int rangeStart, int rangeEnd, int i, int start, int end, int val){     // start end is query start end and rangeStart,rangeEnd is current nodes range
        populate(i, start, end);

        // out of current node's range
        if(start > rangeEnd || end < rangeStart){
            return;
        }

        if(start >= rangeStart && end <= rangeEnd){
            lazyUpdateVal[i] += val;
            populate(i, start, end);
            return;
        }

        int mid = start + (end-start)/2;
        updateRange(rangeStart, rangeEnd, 2*i+1, start, mid, val);
        updateRange(rangeStart, rangeEnd, 2*i+2, mid+1, end, val);

        // Here we are keeping track of what is max and min in the segment (either -1, 0 or 1)
        // based on this we can further decide if there is a 0 in this segment or not
        // if yes then there is a possibility of finding balanced sub-array otherwise we can entirely skip.
        segmentMin[i] = Math.min(segmentMin[2*i+1], segmentMin[2*i+2]);
        segmentMax[i] = Math.max(segmentMax[2*i+1], segmentMax[2*i+2]);
    }

    private int getLeftMostZero(int i, int start, int end){
        populate(i, start, end);    // if there is any lazy update is pending then that need to happen first

        // if min is greater than 0 or max is less than 0 then there is no chance we can find 0 here.
        if(segmentMin[i] > 0 || segmentMax[i] < 0){
            return -1;
        }

        //  this is leaf node
        if(start == end){
            return start;
        }

        int mid = start + (end - start)/2;
        int left = getLeftMostZero(2*i+1, start, mid);
        if(left != -1){
            // found the leftMost zero
            return left;
        }

        // otherwise check in right side
        return getLeftMostZero(2*i+2, mid+1, end);
    }


    public int longestBalanced(int[] nums) {
        n = nums.length;

        int result = 0;
        Map<Integer, Integer> lastSeenIndex = new HashMap<>();  // to store/retrieve last seen the index of a val if it is duplicate
        segmentMin = new int[4*n];
        segmentMax = new int[4*n];
        lazyUpdateVal = new int[4*n];

        // Transformation values
        // odd value = 1
        // even value = -1
        for (int i = 0; i < n; i++) {
            int val = nums[i];

            int transformedVal = (val % 2 == 0) ? -1 : 1;

            // if the val is duplicate (i.e. we have already seen it before)
            // Then we don't need to propagate its transformation beyond previously seen index
            if (lastSeenIndex.containsKey(val)) {
                int prevIndex = lastSeenIndex.get(val);

                // as further in next loop we are propagating the transformedVal throughout hence to nullify it before prevIndex,
                // we are already adding counterpart here
                updateRange(0, prevIndex, 0, 0, n-1, -1*transformedVal);
            }

            // propagate the transformed value throughout to the left
            updateRange(0,i, 0, 0, n-1, transformedVal);

            // now, all balanced sub-arrays will result into 0 transformed sum.
            // As we need longest balanced sub-array, we need the leftmost 0 from the current ith index
            int leftMostZeroIndex = getLeftMostZero(0, 0, n-1);

            if(leftMostZeroIndex != -1) {
                result = Math.max(result, i - leftMostZeroIndex + 1);
            }

            lastSeenIndex.put(val, i);
        }

        return result;
    }
}
