package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] reservedSeats = {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};

        Solution solution = new Solution();
        System.out.println(solution.maxNumberOfFamilies(n, reservedSeats));
    }
}