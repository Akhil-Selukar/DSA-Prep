package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[][] events = {{1,2,4},{3,4,3},{2,3,1}};
//        int k = 2;

        int[][] events = {{1,2,4},{3,4,3},{2,3,10}};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.maxValue(events, k));
    }
}