package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {5, 3, 2, 1, 0, -3};

        System.out.println(thirdMax(nums));
    }

    public static int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        for(Integer num:nums){
            if(num.equals(max1) || num.equals(max2) || num.equals(max3)){
                continue;   // this means we have already considered this num.
            }
            if(max1 == null || num>max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if(max2 == null || num > max2){
                max3 = max2;
                max2 = num;
            } else if(max3 == null|| num>max3){
                max3 = num;
            }
        }
        return max3 == null ? max1 : max3;
    }
}