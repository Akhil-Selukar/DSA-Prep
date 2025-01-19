package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;

        Solution solution = new Solution();
        System.out.println(solution.combinationSum(candidates, target));
    }
}