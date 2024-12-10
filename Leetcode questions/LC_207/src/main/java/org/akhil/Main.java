package org.akhil;

public class Main {
    public static void main(String[] args) {
        int numberOfCourses = 2;
        int[][] prerequisites = {{1,0}};

        Solution solution = new Solution();

        System.out.println(solution.canFinish(numberOfCourses, prerequisites));
    }
}