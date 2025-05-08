package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int numCourses = 3;
//        int[][] prerequisites = {{1,2},{1,0},{2,0}};
//        int[][] queries = {{1,0},{1,2}};

        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        int[][] queries = {{0,1},{1,0}};

        Solution solution = new Solution();

        System.out.println(solution.checkIfPrerequisite(numCourses, prerequisites, queries));
    }
}