package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] fruits = {{1,2,3,4},{5,6,8,7},{9,10,11,12},{13,14,15,16}};

        Solution solution = new Solution();
        System.out.println(solution.maxCollectedFruits(fruits));
    }
}