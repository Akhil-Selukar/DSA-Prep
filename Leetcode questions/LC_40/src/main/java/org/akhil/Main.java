package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(candidates, target));
    }
}