package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] dimensions = {{9,3},{8,6}};

        Solution solution = new Solution();
        System.out.println(solution.areaOfMaxDiagonal(dimensions));
    }
}