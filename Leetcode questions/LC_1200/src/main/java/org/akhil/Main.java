package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3,8,-10,23,19,-4,-14,27};

        System.out.println(minimumAbsDifference(arr));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();

        // Instead of writing insertion sorting algorithm you can simply use Arrays.sort(arr).
        // I have written this algorithm just to revise insertion sort code.

        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j>0; j--){
                if(arr[j]<arr[j-1]){
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
        int minDifference = Integer.MAX_VALUE;
        for(int i=1; i<arr.length; i++){
            if(minDifference == (arr[i]-arr[i-1])){
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if(minDifference > (arr[i]-arr[i-1])){
                ans.clear();
                minDifference = (arr[i]-arr[i-1]);
                ans.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return ans;
    }

    public static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}