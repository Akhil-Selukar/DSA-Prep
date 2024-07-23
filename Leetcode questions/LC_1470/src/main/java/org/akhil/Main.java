package org.akhil;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,5,1,3,4,7};
        int n = 3;
        System.out.println(Arrays.toString(shuffle(arr, n)));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n*2];
        int offset = 0;
        for(int i=0; i<n; i++){
            ans[offset] = nums[i];
            ans[offset+1] = nums[n+i];
            offset+=2;
        }
        return ans;
    }

    // Alternative approach
//    public static int[] shuffle(int[] nums, int n) {
//        int[] ans = new int[n*2];
//        int firstHalf = 0;
//        int secondHalf = n;
//        int index = 0;
//        while(firstHalf < n && secondHalf < 2*n){
//         ans[index++] = nums[firstHalf++];
//         ans[index++] = nums[secondHalf++];
//        }
//        return ans;
//    }
}