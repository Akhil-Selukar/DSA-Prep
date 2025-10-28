package org.akhil;

public class Solution {
    /**
     * COUNT SORT CODE
     * Sorts an array of integers using the Counting Sort algorithm.
     *
     * TC -> O(M+N) where M is the largest number in given array
     * SC -> O(M+N)
     *
     * @param arr The array to be sorted.
     */
//    public void countSort(int[] arr){
//        // write your code here
//        if(arr == null || arr.length == 0){
//            return;
//        }
//
//        int max = 0;
//        for(int num:arr){
//            max = Math.max(max, num);
//        }
//
//        int[] count = new int[max+1];
//
//        for(int num:arr){
//            count[num]++;
//        }
//
//        int index = 0;
//        for(int i=0; i<=max; i++){
//            while (count[i] > 0) {
//                arr[index++] = i;
//                count[i]--;
//            }
//        }
//    }


    // try stable algorithm as well
    public void countSort(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        int max = 0;
        for(int num:arr){
            max = Math.max(max, num);
        }

        int[] count = new int[max+1];

        for(int num:arr){
            count[num]++;
        }

        // calculate prefix sum
        for(int i=1; i<count.length; i++){
            count[i] = count[i] + count[i-1];
        }

        // sort using prefix sum array
        int[] result = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            int index = count[arr[i]] - 1;
            result[index] = arr[i];
            count[arr[i]]--;
        }

        for(int i=0; i<arr.length; i++){
            arr[i] = result[i];
        }
    }
}
