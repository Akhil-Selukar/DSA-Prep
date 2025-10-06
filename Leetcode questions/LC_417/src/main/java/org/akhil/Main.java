package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
//        int[][] heights = {{1}};
//        int[][] heights = {{1,2,3},{8,9,4},{7,6,5}};

        Solution solution = new Solution();
        System.out.println(solution.pacificAtlantic(heights));
    }
}