package org.akhil;

public class Solution {
    // Solution 1 - Bruteforce (simulation)
    // O(N*M)/O(N) where N is the length of target array and M is the maximum value in target array.
//    public int minNumberOperations(int[] target) {
//        int start = 0;
//        int end = target.length-1;
//        int[] initial = new int[target.length];
//        int count = 0;
//
//        while(start < target.length){
//            count++;
//            for(int i = start; i <= end; i++){
//                initial[i]++;
//            }
//
//            while(start < target.length && initial[start] >= target[start]){
//                start++;
//            }
//
//            end = start+1;
//            while(end < target.length && initial[end] < target[end]){
//                end++;
//            }
//            end = end-1;
//        }
//        return count;
//    }

    // -----------------------
    // Solution 2 - Greedy (Visualization)
    // O(N)/O(1)

    // If we plot the target array in a bar graph we will be able to see kind increasing and decreasing buildings. If we start from 1st bar, for sure
    // that many steps will be required. Now on next bar we have already incremented all values till previous bar so we will only need difference of
    // increment. After that if we encounter any smaller bar then in that case we cant extend the increment operation from previous iteration hence we
    // we will have to track the previous height as well.
    public int minNumberOperations(int[] target) {
        int count = target[0];
        int previous = target[0];

        for(int i=1; i<target.length; i++){
            if(previous < target[i]){
                count = count + (target[i] - previous);
            }
            previous = target[i];
        }
        return count;
    }
}
