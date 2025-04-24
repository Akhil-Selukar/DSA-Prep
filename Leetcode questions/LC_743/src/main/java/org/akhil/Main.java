package org.akhil;

public class Main {
    public static void main(String[] args) {

        int[][] times = {{1,2,1},{2,3,2},{1,3,2}};

        Solution solution = new Solution();
        System.out.println(solution.networkDelayTime(times, 3, 1));
    }
}