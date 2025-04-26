package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};

        Solution solution = new Solution();
        System.out.println(solution.allPathsSourceTarget(graph));
    }
}