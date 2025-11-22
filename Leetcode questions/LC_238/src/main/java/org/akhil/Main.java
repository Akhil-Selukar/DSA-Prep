package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

//    public static int[] productExceptSelf(int[] nums) {
//        int[] ans = new int[nums.length];
//        Arrays.fill(ans, 1);
//        int temp = 1;
//        for(int i=0; i<nums.length; i++){
//            ans[i] = ans[i] * temp;
//            temp = temp * nums[i];
//        }
//
//        temp = 1;
//        for(int i = nums.length-1; i>=0; i--){
//            ans[i] = ans[i] * temp;
//            temp = temp * nums[i];
//        }
//        return ans;
//    }

//    // Solution 2 - More intuitive approach
//    // O(N)/O(N)
//    public static int[] productExceptSelf(int[] nums) {
//        int[] leftProduct = new int[nums.length];
//        int[] rightProduct = new int[nums.length];
//        leftProduct[0] = 1;
//        rightProduct[nums.length-1] = 1;
//
//        for(int i=1; i<nums.length; i++){
//            leftProduct[i] = leftProduct[i-1] * nums[i-1];
//        }
//
//        for(int i=nums.length-2; i>=0; i--){
//            rightProduct[i] = rightProduct[i+1] * nums[i+1];
//        }
//
//        for(int i=0; i<nums.length; i++){
//            leftProduct[i] = leftProduct[i] * rightProduct[i];
//        }
//
//        return leftProduct;
//    }


    // ----------------------
    // Solution 2 - More intuitive approach (Space optimization) i.e. calculating right product on the fly
    // O(N)/O(N)
    public static int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int rightProduct = 1;
        leftProduct[0] = 1;

        for(int i=1; i<nums.length; i++){
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }

        for(int i=nums.length-2; i>=0; i--){
            rightProduct = rightProduct * nums[i+1];
            leftProduct[i] = leftProduct[i] * rightProduct;
        }

        return leftProduct;
    }
}