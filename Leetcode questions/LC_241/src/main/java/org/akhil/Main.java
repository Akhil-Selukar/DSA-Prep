package org.akhil;

public class Main {
    public static void main(String[] args) {
        String expression = "2*3-4*5";

        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute(expression));
    }
}