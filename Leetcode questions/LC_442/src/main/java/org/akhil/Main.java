package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};

        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        List<Integer> ans = new ArrayList<>();
        while(i < nums.length){
            int correctIndex = nums[i]-1;
            if(nums[i] != nums[correctIndex]){
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        // find duplicates
        for(int j=0; j<nums.length; j++){
            if(nums[j] != j+1){
                ans.add(nums[j]);
            }
        }
        return ans;
    }

    private static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}