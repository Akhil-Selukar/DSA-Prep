package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] nums1 = {3,2,0,1,0};
//        int[] nums2 = {6,5,0};

//        int[] nums1 = {2,0,2,0};
//        int[] nums2 = {1,4};

//        int[] nums1 = {2,2,0};
//        int[] nums2 = {1,4};

//        int[] nums1 = {2,2,1};
//        int[] nums2 = {1,4};

//        int[] nums1 = {2,5,2,0};
//        int[] nums2 = {1,4,0,2};

//        int[] nums1 = {8,13,15,18,0,18,0,0,5,20,12,27,3,14,22,0};
//        int[] nums2 = {29,1,6,0,10,24,27,17,14,13,2,19,2,11};

        int[] nums1 = {20,0,18,11,0,0,0,0,0,0,17,28,0,11,10,0,0,15,29};
        int[] nums2 = {16,9,25,16,1,9,20,28,8,0,1,0,1,27};

        Solution solution = new Solution();
        System.out.println(solution.minSum(nums1, nums2));
    }
}