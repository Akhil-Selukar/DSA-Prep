package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
//        int[] nums = {2,1,3,4};

        System.out.println(check(nums));
    }

    public static boolean check(int[] nums) {
        int deviation = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > nums[(i+1)%nums.length]){
                deviation++;
            }
        }

        return (deviation <= 1);
    }
}