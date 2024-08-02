package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,6,5,3,8,9,16,75,2,19};
        int target = 5;

        System.out.println(linearSearch(arr, target));
    }

    public static int linearSearch(int[] arr, int target){
        for(int i=0; i<arr.length; i++){
            if(target == arr[i])
                return i;
        }
        return -1;
    }
}