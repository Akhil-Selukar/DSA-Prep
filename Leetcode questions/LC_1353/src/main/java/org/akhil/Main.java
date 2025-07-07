package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] events = {{1,2},{2,3},{3,4}};

        Solution solution = new Solution();
        System.out.println(solution.maxEvents(events));
    }
}