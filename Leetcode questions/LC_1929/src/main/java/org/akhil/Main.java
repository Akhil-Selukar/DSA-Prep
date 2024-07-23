package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,1};

        System.out.println(Arrays.toString(getConcatenation(arr)));
    }

    public static int[] getConcatenation(int[] nums) {
        int length = nums.length;
        if(length !=0){
            int[] ans = new int[(nums.length*2)];
            for(int i=0; i<length; i++){
                ans[i] = nums[i];
                ans[length+i] = nums[i];
            }
            return ans;
        }
        return new int[0];
    }
}