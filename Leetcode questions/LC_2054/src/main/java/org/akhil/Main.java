package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] events = {{1,3,2},{4,5,2},{2,4,3}};
//        int[][] events = {{1,3,2},{4,5,2},{1,5,5}};
//        int[][] events = {{1,5,3},{1,5,1},{6,6,5}};

        Solution solution = new Solution();
        System.out.println(solution.maxTwoEvents(events));
    }
}