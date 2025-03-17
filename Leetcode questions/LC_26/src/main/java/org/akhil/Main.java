package org.akhil;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,2};

        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        List<Integer> ansList = new ArrayList();

        for(int i=0; i<nums.length; i++){
            if(!ansList.contains(nums[i])){
                ansList.add(nums[i]);
            }
        }

        for(int i=0; i<ansList.size(); i++){
            nums[i] = ansList.get(i);
        }
        return ansList.size();
    }

// ############### Another approach (As array is sorted) ##############
// As array is sorted, so we know that if the adjacent numbers are not same then there will not be any other duplicate of that number.

//    public static int removeDuplicates2(int[] nums) {
//        int uniqueCounter = 1;
//        for(int i=1; i<nums.length; i++){
//            if(nums[i] != nums[i-1]){
//                nums[uniqueCounter] = nums[i];
//                uniqueCounter++;
//            }
//        }
//        return uniqueCounter;
//    }

    public static int removeDuplicates2(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        while(p2 < nums.length){
            if(nums[p1] != nums[p2]){
                nums[++p1] = nums[p2++];
            } else {
                p2++;
            }
        }
        return p1+1;
    }
}