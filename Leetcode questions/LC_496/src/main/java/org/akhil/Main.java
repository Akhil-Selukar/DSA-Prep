package org.akhil;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    // Using stack

//    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int[] answer = new int[nums1.length];
//        Arrays.fill(answer, -1);
//
//        for(int i=0; i<nums1.length; i++){
//            int value1 = nums1[i];
//            int j = nums2.length-1;
//            Stack<Integer> stack = new Stack<>();
//
//            while(nums2[j] != value1){
//                stack.push(nums2[j]);
//                j--;
//            }
//            while(!stack.isEmpty()){
//                int value = stack.pop();
//                if(value > value1){
//                    answer[i] = value;
//                    break;
//                }
//            }
//        }
//        return answer;
//    }

    // without using stack

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int max = -1;
            int j = nums2.length - 1;

            while (j >= 0 && nums2[j] != nums1[i]) {
                if (nums2[j] > nums1[i]) {
                    max = nums2[j];
                }
                j--;
            }
            ans[i] = max;
        }

        return ans;
    }
}