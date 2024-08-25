package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int ansIndex = 0;
        int[] ans = new int[n];
        boolean[] check = new boolean[n];

        for (int val : arr2) {
            for (int j = 0; j < n; j++) {
                if (val == arr1[j]) {
                    ans[ansIndex] = arr1[j];
                    ansIndex++;
                    check[j] = true;
                }
            }
        }

        int[] remaining = new int[n-ansIndex];
        int remainingIndex = 0;

        for(int i=0; i<n;i++){
            if(!check[i]){
                remaining[remainingIndex] = arr1[i];
                remainingIndex++;
            }
        }

        Arrays.sort(remaining);

        for (int val : remaining) {
            ans[ansIndex] = val;
            ansIndex++;
        }

        return ans;
    }
}