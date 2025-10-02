package org.akhil;

public class Solution {

    // For explanation of this look at 'https://www.youtube.com/watch?v=wpHzXTkuVkY'
    // O(N)/O(N)
//    public int maxChunksToSorted(int[] arr) {
//        if (arr == null || arr.length == 0) {
//            return 0;
//        }
//
//        int n = arr.length;
//
//        int[] greaterToLeft = new int[n];
//        greaterToLeft[0] = arr[0];
//
//        for(int i=1; i<n; i++){
//            greaterToLeft[i] = Math.max(greaterToLeft[i-1], arr[i]);
//        }
//
//        int count = 0;
//        for(int i=0; i<n; i++){
//            if(greaterToLeft[i] == i){
//                count++;
//            }
//        }
//        return count;
//    }


    // -----------------------
    // Solution 2 - More intuitive approach
    // if we want to make a partition and sort it, then to get the perfectly sorted array we will need all elements in the array in LHS
    // of the partition, no matter in which order because we will be sorting at the end.
    // now as it is asked to return max partitions possible we can make partition greedily at each index and check the left hand side sum with expected
    // sum. Now expected sum is nothing but the sum of numbers from 0 to that index (because it is given numbers are from o to n-1)
    // so just compare the total sum with expected sum and how many instances we get this equal that many partitions we can make.
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int count = 0;

        int expectedSum = 0;
        int actualSum = 0;

        for (int i = 0; i < n; i++) {
            expectedSum = expectedSum + i;
            actualSum = actualSum + arr[i];

            if (expectedSum == actualSum) {
                count++;
            }
        }
        return count;
    }
}
