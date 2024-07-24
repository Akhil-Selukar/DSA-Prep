package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        System.out.println(Arrays.toString(createTargetArray(nums, index)));
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> ansList = new ArrayList<>();
        int[] ans = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            ansList.add(index[i],nums[i]);
        }
        for(int i=0; i<ans.length; i++){
            ans[i]=ansList.get(i);
        }
        return ans;
    }
}