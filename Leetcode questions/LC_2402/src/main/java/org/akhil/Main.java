package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 2;
        int[][] meetings = {{0,10},{1,5},{2,7},{3,4}};

        Solution solution = new Solution();
        System.out.println(solution.mostBooked(n, meetings));
    }
}