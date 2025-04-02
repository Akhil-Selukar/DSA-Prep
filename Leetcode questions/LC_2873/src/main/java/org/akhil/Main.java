package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {12,6,1,2,7};
//        int[] nums = {1000000,1,1000000};

        Solution solution = new Solution();
        System.out.println(solution.maximumTripletValue(nums));
    }
}