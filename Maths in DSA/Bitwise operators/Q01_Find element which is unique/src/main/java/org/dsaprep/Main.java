package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2,4,6,3,1,3,4,2,1};
        int unique = findUnique(nums);
        System.out.println(unique);
    }

    protected static int findUnique(int[] nums) {
        int unique = 0;
        for(int num:nums){
            unique = unique^num;
        }

        return unique;
    }
}