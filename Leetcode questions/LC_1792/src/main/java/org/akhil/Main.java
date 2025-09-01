package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] classes = {{1,2},{3,5},{2,2}};
        int extraStudents = 2;

        Solution solution = new Solution();
        System.out.println(solution.maxAverageRatio(classes, extraStudents));
    }
}