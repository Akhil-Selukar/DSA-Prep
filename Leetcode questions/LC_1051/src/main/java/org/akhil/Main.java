package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};

        System.out.println(heightChecker(heights));
    }

    public static int heightChecker(int[] heights) {
        int[] copy = heights.clone();
        int count = 0;
        for(int i=0; i<heights.length-1; i++){
            for(int j=i+1; j>0; j--){
                if(heights[j]<heights[j-1]){
                    swap(heights, j, j-1);
                } else {
                    break;
                }
            }
        }

        for(int i=0; i<heights.length; i++){
            if(heights[i] != copy[i]){
                count++;
            }
        }
        return count;
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}