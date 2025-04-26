package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};

        Solution solution = new Solution();
        System.out.println(solution.eventualSafeNodes(graph));
//        System.out.println(solution.eventualSafeNodes2(graph));
    }
}