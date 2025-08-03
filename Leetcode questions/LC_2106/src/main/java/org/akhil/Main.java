package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] fruits = {{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}};
        int startPos = 5;
        int k = 4;

        Solution solution = new Solution();
        System.out.println(solution.maxTotalFruits(fruits, startPos, k));
    }
}