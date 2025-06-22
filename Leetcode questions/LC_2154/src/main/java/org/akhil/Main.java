package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {5,3,6,1,12};
        int original = 3;

        Solution solution = new Solution();
        System.out.println(solution.findFinalValue(nums, original));
    }
}