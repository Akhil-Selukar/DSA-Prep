package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastIndexOfNums1 = m - 1;
        int lastIndexOfNums2 = n - 1;
        int lastIndexOfFinalArray = m + n - 1;

        while(lastIndexOfNums2 >= 0){
            if(lastIndexOfNums1>=0 && nums1[lastIndexOfNums1] > nums2[lastIndexOfNums2]){
                nums1[lastIndexOfFinalArray] = nums1[lastIndexOfNums1];
                lastIndexOfNums1--;
                lastIndexOfFinalArray--;
            } else {
                nums1[lastIndexOfFinalArray] = nums2[lastIndexOfNums2];
                lastIndexOfNums2--;
                lastIndexOfFinalArray--;
            }
        }
    }
}