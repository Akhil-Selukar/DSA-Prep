package org.dsaprep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 1, 8, 3, 1, 2, 4};
        countSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static void countSort(int[] nums){
        if(nums == null || nums.length <= 1){
            return;
        }

        // finding the max value
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            if(num>max){
                max = num;
            }
        }

        // creating frequency array
        int[] frequency = new int[max+1];

        // populating frequency array
        for(int num:nums){
            frequency[num]++;
        }

        // modifying nums to get sorted array.
        int index = 0;
        for (int i=0; i<=max; i++){
            while(frequency[i] != 0){
                nums[index] = i;
                index++;
                frequency[i]--;
            }
        }
    }
}